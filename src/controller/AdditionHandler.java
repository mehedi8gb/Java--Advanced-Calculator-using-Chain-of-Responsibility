package controller;

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
        if (operation.contains("+")){
           ArrayList<String> operands = new ArrayList<>(Arrays.asList(operation.split("(?<=\\d)\\+")));

           if(operands.get(0).matches("([+\\s]|^$)")){
               operands.remove(0);
               nextInIChain.handle(operands.get(0));
            }
            result = nextInIChain.handle(operands.get(0));
            for (int i = 1; i < operands.size(); i++) {
                OperationRecorder.OperationRecordReader(operands,  "+", i-1);
                result += nextInIChain.handle(operands.get(i));
            }
            return result;
        } else {
            return nextInIChain.handle(operation);
        }
    }
}