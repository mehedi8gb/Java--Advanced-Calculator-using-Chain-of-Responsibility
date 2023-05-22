package request;

import java.util.regex.*;
import controller.Calculator;

public class Request {


public static String validateInput(final String input) {
    String regexPattern = "^\\s*(?:\\d+(?:\\.\\d+)?|sin|cos|tan)\\s*(?:[-+*/]\\s*(?:\\d+(?:\\.\\d+)?|sin|cos|tan)\\s*)*$";
    Pattern pattern = Pattern.compile(regexPattern);
    Matcher matcher = pattern.matcher(input);

    if (matcher.matches()) {
        return input.replaceAll("\\s+", "");
    } else {
        Calculator.showErrorMessage(Calculator.ERROR_MESSAGE);
        return null; // or throw an exception, depending on your requirements
    }
}



// public static String validate(String expression) {
//    if (expression.matches("^[\\d+\\-*/^()\\s]+$")) {
//        expression = expression.replaceAll("\\s+", ""); // Remove whitespace
//        if (expression.matches(".*sin\\(\\d+\\).*") ||
//                expression.matches(".*cos\\(\\d+\\).*") ||
//                expression.matches(".*tan\\(\\d+\\).*")) {
//            return expression;
//        } else {
//            Calculator.showErrorMessage("Invalid trigonometric function");
//            return "invalid"; // or throw an exception, depending on your requirements
//        }
//    } else {
//        Calculator.showErrorMessage("Invalid input");
//        return "invalid"; // or throw an exception, depending on your requirements
//    }
//}

}
