package request;

import controller.Calculator;

public class Request {

    public static String validateInput(final String input) {
    if (input.matches("^[0-9\\+\\-*\\/\\^\\(\\).\\s]+$")) {
        return input.replaceAll("\\s+", "");
    } else {
        Calculator.showErrorMessage("Invalid input");
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
