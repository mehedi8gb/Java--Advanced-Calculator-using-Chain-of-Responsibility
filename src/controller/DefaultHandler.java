package controller;

import sys.Context;

public class DefaultHandler implements IChain {
    private IChain nextInIChain;
    @Override
    public void setNext(final IChain nextIChain) {
      //
    }

    @Override
    public double handle(String operation) {
        return Double.parseDouble(operation);
    }
}
