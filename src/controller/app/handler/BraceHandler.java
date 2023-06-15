package controller.app.handler;

import controller.app.Calculator;
import controller.app.ResponsibilityChain;
import controller.app.sys.Context;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BraceHandler implements ResponsibilityChain {
    private ResponsibilityChain nextInResponsibilityChain;

    @Override
    public void setNext(final ResponsibilityChain nextResponsibilityChain) {
        nextInResponsibilityChain = nextResponsibilityChain;
    }

    @Override
    public double handle(String operation) {
        Matcher funcMatcher = Pattern.compile("sin|cos|tan").matcher(operation);
        if (funcMatcher.find()){
            Calculator calculator = new Calculator();
           return calculator.runChainAgain(operation);
        }
        if (Context.shouldContinue()) {
            String content;
            String val;
            String pattern = "\\((?<content>[^()]+)\\)";
            Matcher matcher = Pattern.compile(pattern).matcher(operation);

            while (matcher.find()) {
                content = matcher.group("content");
                val = String.valueOf(nextInResponsibilityChain.handle(content));
                operation = operation.replace(matcher.group(), val);
                matcher = Pattern.compile(pattern).matcher(operation);
            }
        }
        return this.nextInResponsibilityChain.handle(operation);
    }
}
