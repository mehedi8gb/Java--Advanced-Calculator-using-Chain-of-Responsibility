package controller;

public abstract class CalculatorHandler {
    protected CalculatorHandler nextHandler;

    public void setNext(final CalculatorHandler handler) {
        this.nextHandler = handler;
    }

    public abstract double handle(String operation);
}
