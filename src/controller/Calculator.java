package controller;

import request.Request;

import javax.swing.*;

public class Calculator {
    IChain functionsHandler;
    IChain BraceHandler;
    IChain powerHandler;
    IChain UnaryHandler;
    IChain subtractionHandler;
    IChain defaultHandler;
    IChain additionHandler;
    IChain divisionHandler;
    IChain multiplicationHandler;
    public static final String ERROR_MESSAGE = "Invalid input";
    private Double result;

    public Calculator() {
        // initialize the chain of responsibility
        this.BraceHandler = new BraceHandler();
        this.defaultHandler = new DefaultHandler();
        this.powerHandler = new PowerHandler();
        this.UnaryHandler = new UnaryHandler();
        this.divisionHandler = new DivisionHandler();
        this.multiplicationHandler = new MultiplicationHandler();
        this.additionHandler = new AdditionHandler();
        this.subtractionHandler = new SubtractionHandler();
        this.functionsHandler = new FunctionsHandler();

        // define the chain of responsibility
        this.BraceHandler.setNext(this.UnaryHandler);
        this.UnaryHandler.setNext(this.additionHandler);
        this.additionHandler.setNext(this.subtractionHandler);
        this.subtractionHandler.setNext(this.multiplicationHandler);
        this.multiplicationHandler.setNext(this.divisionHandler);
        this.divisionHandler.setNext(this.functionsHandler);
        this.functionsHandler.setNext(this.powerHandler);
        this.powerHandler.setNext(this.defaultHandler);
    }
    // calculate the result of the expression
    public Double calculate(String expression) {
//            this.result = this.BraceHandler.handle(Request.validated(expression));
            this.result = this.BraceHandler.handle(expression);
            System.out.println(expression + " = " + this.result);
        return this.result;
    }

    /*
     regex to filter only number and operator to make decision its valid input or not,
     and show error message
    */



    //    show error message
    public static void showErrorMessage(final String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // convert double to float to avoid precision errors
    public float getFloatResult() {
        return this.result.floatValue();
    }

}
