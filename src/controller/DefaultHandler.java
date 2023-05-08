package controller;

public class DefaultHandler implements Chain{
    private Chain nextInChain;
    @Override
    public void setNext(Chain nextChain) {
      //
    }

    @Override
    public double handle(String operation) {
        return Double.parseDouble(operation);
    }
}
