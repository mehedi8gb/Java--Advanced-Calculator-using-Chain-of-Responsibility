package request;

import controller.Calculator;

public class Validate {
    public Validate(String expression) {
             this.Check(expression);
    }

 public String Check(String expression) {
    if (expression.matches("^[\\d+\\-*/^()\\s]+$")) {
        expression = expression.replaceAll("\\s+", ""); // Remove whitespace
        if (expression.matches(".*sin\\(\\d+\\).*") ||
                expression.matches(".*cos\\(\\d+\\).*") ||
                expression.matches(".*tan\\(\\d+\\).*")) {
            return expression;
        } else {
            Calculator.showErrorMessage("Invalid trigonometric function");
            return "invalid"; // or throw an exception, depending on your requirements
        }
    } else {
        Calculator.showErrorMessage("Invalid input");
        return "invalid"; // or throw an exception, depending on your requirements
    }
}

}
