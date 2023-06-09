package TrigonoChain;

import controller.IChain;

public class DefaultHandler implements TChain{
    @Override
    public void setNext(TChain nextTChain, IChain nextInIChain) {
        // TODO Auto-generated method stub
    }

    @Override
    public double handle(String expression, String value) {
        return Double.parseDouble(value);
    }
}
