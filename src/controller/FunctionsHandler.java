package controller;

import TrigonoChain.Magic;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class FunctionsHandler implements IChain {

    private IChain nextInIChain;
    private Magic TChain;


       public FunctionsHandler() {
           this.TChain = new Magic();
       }

    @Override
    public void setNext(IChain nextIChain) {
        this.nextInIChain = nextIChain;

    }
    public double handle(String expression) {
        // Added ".*" to match the entire expression
        if (expression.matches("(sin|cos|tan).*")) {
            String functionRegex = "(\\w+\\(\\d+(\\.\\d+)?\\))";
            Matcher matcher = Pattern.compile(functionRegex).matcher(expression);
            // Initialize a new variable to store the replaced expression
            String replacedExpression = expression;

            while (matcher.find()) {
                String match = matcher.group();
                double value = TChain.startTChain(match);
                // Replace in the new variable
                replacedExpression = replacedExpression.replaceAll(match, String.valueOf(value));
            }

            return TChain.startTChain(replacedExpression); // Use the replaced expression
        } else {
            return nextInIChain.handle(expression);
        }
    }

}
