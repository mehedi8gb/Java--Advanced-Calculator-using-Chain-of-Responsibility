package request.cases.validator;

import request.exception.InvalidFunctionException;
import sys.Context;

import java.util.regex.*;

public class FunctionValidator implements IValidator {
    public String validateRequest(String request) throws InvalidFunctionException {

        // regex to check if the request contains any of the operators
        String functionRegex = "\\b(?!(sin|cos|tan|pow|sqrt)\\b)[a-zA-Z]+\\b";
        Pattern functionPattern = Pattern.compile(functionRegex);
        Matcher functionMatcher = functionPattern.matcher(request);

        boolean validFunctionFound = false;
        while (functionMatcher.find()) {
            validFunctionFound = true;
        }

        if (!validFunctionFound) {
            Context.setFlag(false);
            throw new InvalidFunctionException("No valid functions found in the input");
        }

        return request;
    }
}
