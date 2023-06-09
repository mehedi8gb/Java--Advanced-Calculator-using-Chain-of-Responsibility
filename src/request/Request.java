package request;

import request.cases.*;

public class Request {

    IRequest operatorCaseHandler;
    IRequest operandCaseHandler;
    IRequest braceCaseHandler;
    IRequest defaultHandler;
    public Request() {
        this.braceCaseHandler = new BraceCaseHandler();
        this.operatorCaseHandler = new OperatorCaseHandler();
        this.operandCaseHandler = new OperandCaseHandler();
        this.defaultHandler = new DefaultHandler();

        this.braceCaseHandler.setNext(this.operatorCaseHandler);
        this.operatorCaseHandler.setNext(this.operandCaseHandler);
        this.operandCaseHandler.setNext(this.defaultHandler);
    }
    public String validateRequest(String input) {
//           if (input.contains(" ")){
//            input = input.replaceAll(" ", "");
//        }
            return braceCaseHandler.handle(input);
    }
}
