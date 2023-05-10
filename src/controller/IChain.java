package controller;
public interface IChain {

    void setNext(final IChain nextIChain);

    double handle(String operation);
}
