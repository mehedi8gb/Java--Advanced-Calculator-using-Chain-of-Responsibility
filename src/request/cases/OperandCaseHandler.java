package request.cases;

import request.IRequest;

public class OperandCaseHandler implements IRequest {
    private IRequest nextInIRequest;
    @Override
    public void setNext(IRequest nextIRequest) {
        this.nextInIRequest = nextIRequest;
    }

    @Override
    public String handle(String expression) {
//        if (expression.matches("\s")){
//            expression = expression.replaceAll("\\s", "");
//        }
        return expression;
    }
}
