package controller;

import sys.Context;

import javax.swing.*;

public class Calculator {
    IChain FunctionsHandler;
    IChain BraceHandler;
    IChain PowerHandler;
    IChain UnaryHandler;
    IChain SubtractionHandler;
    IChain DefaultHandler;
    IChain AdditionHandler;
    IChain DivisionHandler;
    IChain MultiplicationHandler;
    public static final String ERROR_MESSAGE = "Invalid input";
    private Double result;

    public Calculator() {
        // initialize the chain of responsibility
        this.BraceHandler = new BraceHandler();
        this.DefaultHandler = new DefaultHandler();
        this.PowerHandler = new PowerHandler();
        this.UnaryHandler = new UnaryHandler();
        this.DivisionHandler = new DivisionHandler();
        this.MultiplicationHandler = new MultiplicationHandler();
        this.AdditionHandler = new AdditionHandler();
        this.SubtractionHandler = new SubtractionHandler();
        this.FunctionsHandler = new FunctionsHandler(this);

        // define the chain of responsibility
        this.FunctionsHandler.setNext(this.BraceHandler);
        this.BraceHandler.setNext(this.UnaryHandler);
        this.UnaryHandler.setNext(this.AdditionHandler);
        this.AdditionHandler.setNext(this.SubtractionHandler);
        this.SubtractionHandler.setNext(this.MultiplicationHandler);
        this.MultiplicationHandler.setNext(this.DivisionHandler);
        this.DivisionHandler.setNext(this.PowerHandler);
        this.PowerHandler.setNext(this.DefaultHandler);
    }

    /**
     * Calculate double.
     * calculate the result of the expression
     *
     * @param expression the expression
     * @return the double
     */
    public double calculate(String expression) {
          if (Context.shouldContinue()) {
            try {
//                String validated = new Request().validateRequest(expression);
                this.result = this.FunctionsHandler.handle(expression);
            } catch (Exception e) {
                Context.setFlag(false);
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
          }
        return this.result;
    }
    // convert double to float to avoid precision errors
    public float getFloatResult() {
        return this.result.floatValue();
    }

    public double runChainAgain(String expression){
       return this.FunctionsHandler.handle(expression);
    }

}
