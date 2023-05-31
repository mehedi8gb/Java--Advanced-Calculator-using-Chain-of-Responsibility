package request.chain;

import controller.FunctionsHandler;
import exception.CalculatorExceptions;

public interface IRequest {
    void setNext(IRequest nextIRequest);
    String handle(String expression) throws CalculatorExceptions;
}
