package controller;

import javax.swing.*;

public class Calculator {
    IChain BraceHandler;
    IChain powerHandler;
    IChain UnArrayHandler;
    IChain subtractionHandler;
    IChain defaultHandler;
    IChain additionHandler;
    IChain divisionHandler;
    IChain multiplicationHandler;
    private Double result;


    public Calculator() {
        // initialize the chain of responsibility
        this.BraceHandler = new BraceHandler();
        this.defaultHandler = new DefaultHandler();
        this.powerHandler = new PowerHandler();
        this.UnArrayHandler = new UnaryHandler();
        this.divisionHandler = new DivisionHandler();
        this.multiplicationHandler = new MultiplicationHandler();
        this.additionHandler = new AdditionHandler();
        this.subtractionHandler = new SubtractionHandler();

        // define the chain of responsibility
        this.BraceHandler.setNext(this.UnArrayHandler);
        this.UnArrayHandler.setNext(this.additionHandler);
        this.additionHandler.setNext(this.subtractionHandler);
        this.subtractionHandler.setNext(this.multiplicationHandler);
        this.multiplicationHandler.setNext(this.divisionHandler);
        this.divisionHandler.setNext(this.powerHandler);
        this.powerHandler.setNext(this.defaultHandler);
    }
    // calculate the result of the input
    public Double calculate(String input) {
            this.result = this.BraceHandler.handle(validateInput(input));
            System.out.println(input + " = " + this.result);
        return this.result;
    }

    /*
     regex to filter only number and operator to make decision its valid input or not,
     and show error message
    */
private String validateInput(final String input) {
    if (input.matches("^[0-9\\+\\-*\\/\\^\\(\\).\\s]+$")) {
        return input.replaceAll("\\s+", "");
    } else {
        showErrorMessage("Invalid input");
        return null; // or throw an exception, depending on your requirements
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
