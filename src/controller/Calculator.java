package controller;

import javax.swing.*;

public class Calculator {
    IChain powerHandler;
    IChain nonArrayHandler;
    IChain subtractionHandler;
    IChain defaultHandler;
    IChain additionHandler;
    IChain divisionHandler;
    IChain multiplicationHandler;
    private Double result;


    public Calculator() {
        // initialize the chain of responsibility
        this.defaultHandler = new DefaultHandler();
        this.powerHandler = new PowerHandler();
        this.nonArrayHandler = new NonArrayHandler();
        this.divisionHandler = new DivisionHandler();
        this.multiplicationHandler = new MultiplicationHandler();
        this.additionHandler = new AdditionHandler();
        this.subtractionHandler = new SubtractionHandler();

        // define the chain of responsibility
        this.nonArrayHandler.setNext(this.powerHandler);
        this.powerHandler.setNext(this.additionHandler);
        this.additionHandler.setNext(this.subtractionHandler);
        this.subtractionHandler.setNext(this.multiplicationHandler);
        this.multiplicationHandler.setNext(this.divisionHandler);
        this.divisionHandler.setNext(this.defaultHandler);
    }
    // calculate the result of the input
    public Double calculate(final String input) {
            result = this.nonArrayHandler.handle(validateInput(input) ? input : "0.00");
            System.out.println(input + " = " + this.result);
        return this.result;
    }

    /*
     regex to filter only number and operator to make decision its valid input or not,
     and show error message
    */
    private boolean validateInput(final String input) {
        if (input.matches("^[0-9\\+\\-\\*\\/\\^\\.\\s]+$")) {
            return true;
        } else {
            showErrorMessage("Invalid input");
            return false;
        }
    }

    //    show error message
    public static void showErrorMessage(final String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    // convert double to float to avoid precision errors
    public float getFloatResult() {
        return result.floatValue();
    }

}
