package request.cases.validator;

import request.exception.InvalidFunctionException;
import request.exception.InvalidOperatorException;
import request.exception.InvalidRequestException;

public interface IValidator {
    String validateRequest(String request) throws InvalidRequestException, InvalidOperatorException, InvalidFunctionException;
}
