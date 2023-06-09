package controller;

import sys.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnaryHandler implements IChain {
    // TODO: Implement the handle method
    private IChain nextInChain;
    private boolean flag = true;
    private double result = 0.0;

    @Override
    public void setNext(final IChain nextIChain) {
          this.nextInChain = nextIChain;
    }

    @Override
    public double handle(String operation) {
        if (Context.shouldContinue()) {
            final String regex = "(\\+\\+)|(--)|(\\+-)|(-\\+)";
//            final String SpecialOperatorRegex = "(\\d+\\*\\-\\d+)";
            final Matcher matcher = Pattern.compile(regex, Pattern.MULTILINE).matcher(operation);
//            final Matcher SpecialOperatorMatcher = Pattern.compile(SpecialOperatorRegex, Pattern.MULTILINE).matcher(operation);

            while (matcher.find()) {
                operation = operation.replace("+-", "-").replace("-+", "-");
                operation = operation.replace("++", "+").replace("--", "+");
            }


        }
        return this.nextInChain.handle(operation);
    }
}
// --- DO NOT EDIT BELOW THIS LINE ---

