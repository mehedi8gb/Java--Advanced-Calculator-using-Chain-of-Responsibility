package controller.app.handler;

import controller.app.ResponsibilityChain;
import controller.app.sys.Context;

public class PowerHandler implements ResponsibilityChain {
    private ResponsibilityChain nextInResponsibilityChain;
    private double result;

    @Override
    public void setNext(final ResponsibilityChain nextResponsibilityChain) {
        this.nextInResponsibilityChain = nextResponsibilityChain;
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
            return this.nextInResponsibilityChain.handle(operation);
        }
    }
}
