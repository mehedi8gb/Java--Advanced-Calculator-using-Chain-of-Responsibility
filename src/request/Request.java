package request;

import exception.CalculatorExceptions;
import request.chain.RequestChain;

public class Request {
    public static String validated(String input) throws CalculatorExceptions {
       return new RequestChain().handle(input);
    }
}
