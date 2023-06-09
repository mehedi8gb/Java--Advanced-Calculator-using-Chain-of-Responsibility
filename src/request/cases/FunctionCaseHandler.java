package request.cases;

import request.IRequest;
import request.cases.validator.BraceValidator;
import request.cases.validator.FunctionValidator;
import request.exception.InvalidFunctionException;
import request.exception.InvalidRequestException;

public class FunctionCaseHandler implements IRequest {
    private IRequest nextInIRequest;
    @Override
    public void setNext(IRequest nextIRequest) {
        this.nextInIRequest = nextIRequest;
    }

    @Override
    public String handle(String expression) {
        try {
            String validated = new FunctionValidator().validateRequest(expression);
            return this.nextInIRequest.handle(validated);
        } catch (InvalidFunctionException e) {
            System.out.println("Invalid Functions: " + e.getMessage());
            e.printStackTrace();
        }
        return expression;
    }
}
