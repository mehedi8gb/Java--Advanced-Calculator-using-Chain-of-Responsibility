package controller;
public interface Chain {
    
    public void setNext(Chain nextChain);

    public double handle(String operation);
}
