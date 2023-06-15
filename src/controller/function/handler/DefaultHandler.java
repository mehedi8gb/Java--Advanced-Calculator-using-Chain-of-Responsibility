package controller.function.handler;

import controller.function.IFunction;

public class DefaultHandler implements IFunction {
    @Override
    public void setNext(IFunction nextTChain) {
        // TODO Auto-generated method stub
    }

    @Override
    public double handle(String expression, String value) {
        return Double.parseDouble(value);
    }
}
