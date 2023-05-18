package controller;

import java.util.ArrayList;
import java.util.Arrays;

public class MultiplicationHandler implements IChain {

    private IChain nextInIChain;

    @Override
    public void setNext(final IChain nextIChain) {
        this.nextInIChain = nextIChain;
    }

    @Override
    public double handle(String operation) {
        if (operation.contains("*")) {
         ArrayList<String> operands = new ArrayList<>(Arrays.asList(operation.split("\\*")));
            if(operands.get(0).matches("\\*-")){
               operands.remove(0);
               operands.set(0, String.valueOf(Double.parseDouble(operands.get(1)) * -1));
               nextInIChain.handle(operands.toString());
            }
            double result = nextInIChain.handle(operands.get(0));
            for (int i = 1; i < operands.size(); i++) {
                result *= nextInIChain.handle(operands.get(i));
            }
            return result;
        } else {
            return this.nextInIChain.handle(operation);
        }
    }

}
