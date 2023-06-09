package controller;

import sys.Context;

import java.util.ArrayList;
import java.util.List;

public class DivisionHandler implements IChain {

    private IChain nextInIChain;

    @Override
    public void setNext(final IChain nextIChain) {
        this.nextInIChain = nextIChain;
    }

    @Override
    public double handle(String operation) {

        if (operation.contains("/") && Context.shouldContinue()) {
            List<String> equations = new ArrayList<>(List.of(operation.split("/")));
            double total = nextInIChain.handle(equations.get(0));
            for (int i = 1; i < equations.size(); i++) {
                    total /= nextInIChain.handle(equations.get(i));
            }
            return total;
        } else {
            return this.nextInIChain.handle(operation);
        }
    }
}