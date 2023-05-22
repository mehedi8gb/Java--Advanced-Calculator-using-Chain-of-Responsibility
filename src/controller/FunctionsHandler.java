package controller;

import FunctionsChain.Functions;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class FunctionsHandler implements IChain {

    private IChain nextInIChain;
    private Functions TChain;


       public FunctionsHandler() {
           this.TChain = new Functions();
       }

    @Override
    public void setNext(IChain nextIChain) {
        this.nextInIChain = nextIChain;

    }
    public double handle(String expression) {
        // Added ".*" to match the entire expression
        if (expression.matches("(sin|cos|tan|cosec|sec|cot).*")) {
            String functionRegex = "(\\w+\\(\\d+(\\.\\d+)?\\))";
            Matcher matcher = Pattern.compile(functionRegex).matcher(expression);
            // Initialize a new variable to store the replaced expression
            String replacedExpression = expression;

            while (matcher.find()) {
                String match = matcher.group();
                double value = TChain.startFunctionsChain(match);
                // Replace in the new variable
                replacedExpression = replacedExpression.replaceAll(match, String.valueOf(value));
            }

            return TChain.startFunctionsChain(replacedExpression); // Use the replaced expression
        } else {
            return nextInIChain.handle(expression);
        }
    }

}
