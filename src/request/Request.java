package request;

import java.util.regex.*;

import controller.Calculator;
import request.cases.*;

public class Request {

    IRequest operatorCaseHandler;
    IRequest operandCaseHandler;
    IRequest braceCaseHandler;
    IRequest defaultHandler;
    public Request() {
        this.braceCaseHandler = new braceCaseHandler();
        this.operatorCaseHandler = new operatorCaseHandler();
        this.operandCaseHandler = new operandCaseHandler();
        this.defaultHandler = new defaultHandler();

        this.braceCaseHandler.setNext(this.operatorCaseHandler);
        this.operatorCaseHandler.setNext(this.operandCaseHandler);
        this.operandCaseHandler.setNext(this.defaultHandler);
    }
    public static String validateInput(String input) {
//        String regexPattern = "\\d+\\.\\d+|\\d+|[+\\-*/()]|(sin|cos|tan)";
//        String operatorPattern = "[+\\-*/]";
//        Pattern pattern = Pattern.compile(regexPattern);
//        Matcher matcher = pattern.matcher(input);
//
//        if (matcher.matches()) {
//            return input.replaceAll("\\s+", "");
//        } else {
//            Calculator.showErrorMessage(Calculator.ERROR_MESSAGE);
            return null; // or throw an exception, depending on your requirements
//        }
    }
}
