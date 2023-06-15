package request.chain.cases;

import exception.CalculatorExceptions;
import request.chain.Error;
import request.chain.IRequest;

import java.util.regex.*;

public class BraceCaseHandler extends Exception implements IRequest {
    private IRequest nextInIRequest;
    private String regexOfInnerBrace = "\\([^\\(\\)]*\\)";
    private Matcher matcher = Pattern.compile(regexOfInnerBrace).matcher(regexOfInnerBrace);


    @Override
    public void setNext(IRequest nextIRequest) {
        this.nextInIRequest = nextIRequest;
    }

    @Override
    public String handle(String expression) throws CalculatorExceptions {
        if (!matcher.matches()) {
            // Perform syntax error handling logic
            throw new CalculatorExceptions(Error.MISSING_BRACKET_ERROR);
        }
        while (matcher.find()) {
            String innerBrace = matcher.group();
            String innerBraceWithoutBraces = innerBrace.substring(1, innerBrace.length() - 1);
            String innerBraceResult = nextInIRequest.handle(innerBraceWithoutBraces);
            expression = expression.replace(innerBrace, innerBraceResult);
            this.nextInIRequest.handle(expression);
        }
        return nextInIRequest.handle(expression);
    }
}