package controller;

public class DefaultHandler implements IChain {
    private IChain nextInIChain;
    @Override
    public void setNext(IChain nextIChain) {
      //
    }

    @Override
    public double handle(String operation) {
        return Double.parseDouble(operation);
    }
}
