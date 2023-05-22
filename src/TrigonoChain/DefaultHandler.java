package TrigonoChain;

public class DefaultHandler implements TChain{
    @Override
    public void setNext(TChain nextTChain) {
        // TODO Auto-generated method stub
    }

    @Override
    public double handle(String expression) {
        return Double.parseDouble(expression);
    }
}
