package request.cases.validator;

import request.exception.InvalidOperatorException;
import sys.Context;

import java.util.regex.*;

public class OperatorValidator implements IValidator{
    public String validateRequest(String request) throws InvalidOperatorException {
        // regex to check if the request contains any of the operators
        String singleOperatorRegex = "[+\\-*/^%()]{1}";

        Pattern singlePattern = Pattern.compile(singleOperatorRegex);
        Matcher singleMatcher = singlePattern.matcher(request);

        if (!singleMatcher.find()) {
            Context.setFlag(false);
            throw new InvalidOperatorException("Invalid Operator: " + singleMatcher.toString());
        }
        return request;
    }
}