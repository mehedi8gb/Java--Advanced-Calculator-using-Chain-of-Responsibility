package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BraceHandler implements IChain {
    private IChain nextInIChain;

    @Override
    public void setNext(final IChain nextIChain) {
        nextInIChain = nextIChain;
    }

    @Override
    public double handle(String operation) {
        String content;
        String val;
        String pattern = "\\((?<content>[^()]+)\\)";
        Matcher matcher = Pattern.compile(pattern).matcher(operation);

        while (matcher.find()) {
            content = matcher.group("content");
            val = String.valueOf(nextInIChain.handle(content));
            operation = operation.replace(matcher.group(), val);
            matcher = Pattern.compile(pattern).matcher(operation);
        }
        return this.nextInIChain.handle(operation);
    }
}
