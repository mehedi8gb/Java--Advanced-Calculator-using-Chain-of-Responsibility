package request.cases;

import request.IRequest;
import request.cases.validator.BraceValidator;
import request.exception.InvalidRequestException;
public class BraceCaseHandler implements IRequest {
    private IRequest nextInIRequest;
    @Override
    public void setNext(IRequest nextIRequest) {
        this.nextInIRequest = nextIRequest;
    }
    @Override
    public String handle(String operation) {
        try {
            String validated = new BraceValidator().validateRequest(operation);
            return this.nextInIRequest.handle(validated);
        } catch (InvalidRequestException e) {
            System.out.println("Invalid request: " + e.getMessage());
            e.printStackTrace();
        }
        return operation;
    }
}