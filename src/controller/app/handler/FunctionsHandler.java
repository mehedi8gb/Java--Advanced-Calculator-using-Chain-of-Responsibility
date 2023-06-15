package controller.app.handler;
import controller.app.ResponsibilityChain;
import controller.function.FChain;
import controller.app.sys.Context;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FunctionsHandler implements ResponsibilityChain {
    private ResponsibilityChain nextChain;

    @Override
    public void setNext(ResponsibilityChain nextChain) {
        this.nextChain = nextChain;
    }

    public double handle(String expression) {
        if (!Context.shouldContinue()) {
            return nextChain.handle(expression);
        }

        FChain fChain = new FChain();
        String pattern = "(\\w+)\\(([^()]+)\\)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(expression);
        StringBuilder replacedExpression = new StringBuilder();

        while (matcher.find()) {
            String functionName = matcher.group(1);
            String functionValue = String.valueOf(nextChain.handle(matcher.group(2)));
            double evaluatedValue = fChain.startTChain(functionName, functionValue);
            matcher.appendReplacement(replacedExpression, String.valueOf(evaluatedValue));
        }

        matcher.appendTail(replacedExpression);
        return nextChain.handle(replacedExpression.toString());
    }
}
