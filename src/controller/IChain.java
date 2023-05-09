package controller;
public interface IChain {

    void setNext(IChain nextIChain);

    double handle(String operation);
}
