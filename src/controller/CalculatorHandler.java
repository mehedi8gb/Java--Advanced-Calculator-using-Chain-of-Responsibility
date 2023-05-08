package controller;

public abstract class CalculatorHandler {
    protected CalculatorHandler nextHandler;

    public void setNext(CalculatorHandler handler) {
        nextHandler = handler;
    }

    public abstract double handle(String operation);
}
