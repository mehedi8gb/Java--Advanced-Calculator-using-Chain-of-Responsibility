package request.chain.cases;

import exception.CalculatorExceptions;
import request.chain.IRequest;

public class functionCaseHandler extends Exception implements IRequest {
    private IRequest nextInIRequest;

    @Override
    public void setNext(IRequest nextIRequest) {
        this.nextInIRequest = nextIRequest;
    }

    @Override
    public String handle(String expression) throws CalculatorExceptions {
        return expression;
    }
}
