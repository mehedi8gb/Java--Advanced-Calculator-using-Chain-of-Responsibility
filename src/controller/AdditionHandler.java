package controller;

import sys.Context;

import java.util.ArrayList;
import java.util.Arrays;

public class AdditionHandler implements IChain {

    private IChain nextInIChain;

    @Override
    public void setNext(final IChain nextIChain) {
        nextInIChain = nextIChain;
    }

    @Override
    public double handle(String operation) {
        double result;
        if (operation.contains("+") && !operation.contains("*+") || !operation.contains("*-") && Context.shouldContinue()) {
            ArrayList<String> operands = new ArrayList<>(Arrays.asList(operation.split("\\+")));

            if (operands.get(0).isEmpty()) {
                operands.remove(0);
            }

            result = nextInIChain.handle(operands.get(0));
            for (int i = 1; i < operands.size(); i++) {
                OperationRecorder.OperationRecordReader(operands, "+", i - 1);
                result += nextInIChain.handle(operands.get(i));
            }
            return result;
        } else {
            return nextInIChain.handle(operation);
        }
    }
}