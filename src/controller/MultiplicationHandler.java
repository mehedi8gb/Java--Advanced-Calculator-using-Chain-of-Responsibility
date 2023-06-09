package controller;

import sys.Context;

import java.util.ArrayList;
import java.util.Arrays;

public class MultiplicationHandler implements IChain {

    private IChain nextInIChain;
    private Double result = 0.0;

    @Override
    public void setNext(final IChain nextIChain) {
        this.nextInIChain = nextIChain;
    }

    @Override
    public double handle(String operation) {
        if (operation.contains("*") && Context.shouldContinue()) {
            ArrayList<String> operands = new ArrayList<>(Arrays.asList(operation.split("\\*")));
            if (operation.contains("*-") || operation.contains("*+")) {
                result = nextInIChain.handle(operands.get(0));
                for (int i = 1; i < operands.size(); i++) {
                    result *= nextInIChain.handle(operands.get(i));
                }
                return result;
            } else {
                result = nextInIChain.handle(operands.get(0));
                for (int i = 1; i < operands.size(); i++) {
                    result *= nextInIChain.handle(operands.get(i));
                }
            }
            return result;
        } else {
            return this.nextInIChain.handle(operation);
        }
    }
}
