package controller;

public class Calculator {
    Chain subtractionHandler;
    Chain defaultHandler;
    Chain additionHandler;
    Chain divisionHandler;
    Chain multiplicationHandler;
    private Double result;


    public Calculator() {
        defaultHandler = new DefaultHandler();
        divisionHandler = new DivisionHandler();
        multiplicationHandler = new MultiplicationHandler();
        additionHandler = new AdditionHandler();
        subtractionHandler = new SubtractionHandler();


        subtractionHandler.setNext(additionHandler);
        additionHandler.setNext(multiplicationHandler);
        multiplicationHandler.setNext(divisionHandler);
        divisionHandler.setNext(defaultHandler);
    }

    public Double calculate(String input) {
            this.result = subtractionHandler.handle(input);
            System.out.println(input + " = " + result);
        return result;
    }

    public double getResult() {
        return this.result;
    }
}
