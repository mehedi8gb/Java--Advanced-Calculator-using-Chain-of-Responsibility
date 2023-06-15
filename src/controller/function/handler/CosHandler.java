package controller.function.handler;

import controller.function.IFunction;

public class CosHandler implements IFunction {
    private IFunction nextInTChain;

    @Override
    public void setNext(IFunction nextTChain) {
        this.nextInTChain = nextTChain;
    }

    @Override
    public double handle(String functionName, String value) {
        if (functionName.equals("cos")) {
            return Math.cos(Double.parseDouble(value));
        }

        return nextInTChain.handle(functionName, value);
    }
}
