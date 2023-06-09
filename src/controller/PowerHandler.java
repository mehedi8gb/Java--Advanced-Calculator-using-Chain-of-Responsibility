package controller;

import sys.Context;

public class PowerHandler implements IChain {
    private IChain nextInIChain;
    private double result;

    @Override
    public void setNext(final IChain nextIChain) {
        this.nextInIChain = nextIChain;
    }

    @Override
    public double handle(String operation) {
        if (operation.contains("^") && Context.shouldContinue()) {
            final String[] operands = operation.split("\\^");
            for (int i = 0; i < operands.length - 1; i++) {
                this.result = Math.pow(Double.parseDouble(operands[i]), Double.parseDouble(operands[i + 1]));
            }
            return this.result;
        } else {
            return this.nextInIChain.handle(operation);
        }
    }
}
