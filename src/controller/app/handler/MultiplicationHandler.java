package controller.app.handler;

import controller.app.ResponsibilityChain;
import controller.app.sys.Context;

import java.util.ArrayList;
import java.util.Arrays;

public class MultiplicationHandler implements ResponsibilityChain {

    private ResponsibilityChain nextInResponsibilityChain;
    private Double result = 0.0;

    @Override
    public void setNext(final ResponsibilityChain nextResponsibilityChain) {
        this.nextInResponsibilityChain = nextResponsibilityChain;
    }

    @Override
    public double handle(String operation) {
        if (operation.contains("*") && Context.shouldContinue()) {
            ArrayList<String> operands = new ArrayList<>(Arrays.asList(operation.split("\\*")));
            if (operation.contains("*-") || operation.contains("*+")) {
                result = nextInResponsibilityChain.handle(operands.get(0));
                for (int i = 1; i < operands.size(); i++) {
                    result *= nextInResponsibilityChain.handle(operands.get(i));
                }
                return result;
            } else {
                result = nextInResponsibilityChain.handle(operands.get(0));
                for (int i = 1; i < operands.size(); i++) {
                    result *= nextInResponsibilityChain.handle(operands.get(i));
                }
            }
            return result;
        } else {
            return this.nextInResponsibilityChain.handle(operation);
        }
    }
}
