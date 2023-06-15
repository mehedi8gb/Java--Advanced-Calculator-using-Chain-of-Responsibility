package controller.request.cases.handler;

import controller.request.IRequest;
import controller.request.exception.InvalidOperatorException;
import controller.app.sys.Context;
import controller.request.cases.validator.OperatorValidator;

public class OperatorCaseHandler implements IRequest {
    private IRequest nextInIRequest;

    @Override
    public void setNext(IRequest nextIRequest) {
        this.nextInIRequest = nextIRequest;
    }

    @Override
    public String handle(String operation) {
        if (Context.shouldContinue()) {
            try {
                String validated = new OperatorValidator().validateRequest(operation);
                return this.nextInIRequest.handle(validated);
            } catch (InvalidOperatorException e) {
                Context.setFlag(false);
                System.out.println("Invalid Operator: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return operation;
    }
}
