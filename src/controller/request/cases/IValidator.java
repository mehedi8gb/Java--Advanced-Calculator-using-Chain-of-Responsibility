package controller.request.cases.validator;

import controller.request.exception.InvalidFunctionException;
import controller.request.exception.InvalidOperatorException;
import controller.request.exception.InvalidRequestException;

public interface IValidator {
    String validateRequest(String request) throws InvalidRequestException, InvalidOperatorException, InvalidFunctionException;
}
