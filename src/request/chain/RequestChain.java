package request.chain;

import exception.CalculatorExceptions;
import request.chain.cases.*;

public class RequestChain {
    IRequest operatorCaseHandler;
    IRequest operandCaseHandler;
    IRequest braceCaseHandler;
    IRequest defaultHandler;
    public RequestChain() {
        // Create chain of responsibility
        this.braceCaseHandler = new BraceCaseHandler();
        this.operatorCaseHandler = new operatorCaseHandler();
        this.operandCaseHandler = new operandCaseHandler();
        this.defaultHandler = new defaultHandler();
        // Set next in chain objects
        this.braceCaseHandler.setNext(this.operatorCaseHandler);
        this.operatorCaseHandler.setNext(this.operandCaseHandler);
        this.operandCaseHandler.setNext(this.defaultHandler);
    }
    public String handle(String expression) throws CalculatorExceptions {
        return this.braceCaseHandler.handle(expression);
    }
}
