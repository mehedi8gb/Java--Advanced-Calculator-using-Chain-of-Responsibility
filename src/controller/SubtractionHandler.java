package controller;

import sys.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubtractionHandler implements IChain {

    private IChain nextInIChain;

    @Override
    public void setNext(final IChain nextIChain) {
        nextInIChain = nextIChain;
    }

    @Override
    public double handle(String operation) {
        if (operation.contains("-") && !operation.contains("*-") && Context.shouldContinue()) {
            ArrayList<String> operands = new ArrayList<>(Arrays.asList(operation.split("-")));
            double result;
            if (operands.get(0).isEmpty() && Pattern.compile("^-").matcher(operation).find()) {

                operands.remove(0);
                return nextInIChain.handle(operands.get(0)) * -1;
            }
            if (operation.contains("*-")) {
                return nextInIChain.handle(operation);
            }

            result = nextInIChain.handle(operands.get(0));
            for (int i = 1; i < operands.size(); i++) {
                result -= nextInIChain.handle(operands.get(i));
            }
            return result;
        } else {
            return nextInIChain.handle(operation);
        }
    }
}
