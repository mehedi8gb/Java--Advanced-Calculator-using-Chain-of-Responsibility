package controller.request.cases.handler;

import controller.request.IRequest;

public class DefaultHandler implements IRequest {
    private IRequest nextInIRequest;
    @Override
    public void setNext(IRequest nextIRequest) {
        this.nextInIRequest = nextIRequest;
    }

    @Override
    public String handle(String expression) {
        return expression;
    }
}
