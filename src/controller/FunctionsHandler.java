package controller;

import TrigonoChain.FChain;
import sys.Context;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class FunctionsHandler implements IChain {

    private IChain nextInIChain;
    private Calculator calculator;

    public FunctionsHandler(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void setNext(IChain nextIChain) {
        this.nextInIChain = nextIChain;
    }

    public double handle(String expression) {
        // Added ".*" to match the entire expression
        if (Context.shouldContinue()) {

            FChain TChain = new FChain(this);
            String pattern = "(\\w+)\\(([^()]+)\\)";

            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(expression);

            StringBuilder replacedExpression = new StringBuilder();

            while (matcher.find()) {
                String functionName = matcher.group(1);
                String functionValue = matcher.group(2);

                double evaluatedValue = TChain.startTChain(functionName, functionValue);

                matcher.appendReplacement(replacedExpression, String.valueOf(evaluatedValue));
            }

            matcher.appendTail(replacedExpression);


//            String fullMatcher = "(?<fullMatch>\\w+\\(\\d+(\\.\\d+)?\\))";
//            String fullMatcher = "(sin|cos|tan)\\((?<content>[^()]+)\\)";
//            String functionRegex = "(?<funcName>sin|cos|tan)";
//            Matcher functionNameMatcher = Pattern.compile(functionRegex).matcher(expression);
//            Matcher FullMatcher = Pattern.compile(fullMatcher).matcher(expression);
//
//            // Initialize a new variable to store the replaced expression
//            String replacedExpression = null;
//
//            while (functionNameMatcher.find()) {
//                String fullMatch = FullMatcher.group("fullMatch");
//                replacedExpression = expression.replace(fullMatch, String.valueOf(TChain.startTChain(expression)));
//            }
            return nextInIChain.handle(replacedExpression.toString());
        } else {
            return nextInIChain.handle(expression);
        }
    }
}
