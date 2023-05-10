package controller;

import java.util.ArrayList;
import java.util.Arrays;

public class SubtractionHandler implements IChain {

    private IChain nextInIChain;

    @Override
    public void setNext(final IChain nextIChain) {
        nextInIChain = nextIChain;
    }

    @Override
    public double handle(String operation) {
            double result;
        if (operation.contains("-")) {
            ArrayList<String> operands = new ArrayList<>(Arrays.asList(operation.split("(?<=\\d)-")));
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
