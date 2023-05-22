package request;

import controller.Calculator;

import java.util.regex.*;

public class Request {


    public static String validateInput(final String input) {
        // regex patter to validate input string with only numbers and operators and functions only sin, cos, tan, cosec, sec, cot and braces only '(' and ')' and spaces only ' ' and no other characters are allowed in the input string and no consecutive operators are allowed in the input string and no consecutive functions are allowed in the input string and no consecutive braces are allowed in the input string
        final String regexPattern = "^(?:\\d+|[+\\-*^/()]|sin|cos|tan|cosec|sec|cot|\\s)+$";

        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
//            if (input.matches("cosec.*")){
//                input.replaceAll("cosec.*", "csc");
//            }
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
