package controller.app.handler;

import controller.app.ResponsibilityChain;
import controller.app.sys.Context;
import controller.app.sys.OperationRecorder;

import java.util.ArrayList;
import java.util.Arrays;

public class AdditionHandler implements ResponsibilityChain {

    private ResponsibilityChain nextInResponsibilityChain;

    @Override
    public void setNext(final ResponsibilityChain nextResponsibilityChain) {
        nextInResponsibilityChain = nextResponsibilityChain;
    }

    @Override
    public double handle(String operation) {
        double result;
        if (operation.contains("+") && !operation.contains("*+") || !operation.contains("*-") && Context.shouldContinue()) {
            ArrayList<String> operands = new ArrayList<>(Arrays.asList(operation.split("\\+")));

            if (operands.get(0).isEmpty()) {
                operands.remove(0);
            }

            result = nextInResponsibilityChain.handle(operands.get(0));
            for (int i = 1; i < operands.size(); i++) {
                OperationRecorder.OperationRecordReader(operands, "+", i - 1);
                result += nextInResponsibilityChain.handle(operands.get(i));
            }
            return result;
        } else {
            return nextInResponsibilityChain.handle(operation);
        }
    }
}