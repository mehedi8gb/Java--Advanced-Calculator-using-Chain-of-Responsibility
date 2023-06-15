package controller.app.handler;

import controller.app.ResponsibilityChain;
import controller.app.sys.Context;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnaryHandler implements ResponsibilityChain {
    // TODO: Implement the handle method
    private ResponsibilityChain nextInChain;
    private boolean flag = true;
    private double result = 0.0;

    @Override
    public void setNext(final ResponsibilityChain nextResponsibilityChain) {
          this.nextInChain = nextResponsibilityChain;
    }

    @Override
    public double handle(String operation) {
        if (Context.shouldContinue()) {
            final String regex = "(\\+\\+)|(--)|(\\+-)|(-\\+)";
//            final String SpecialOperatorRegex = "(\\d+\\*\\-\\d+)";
            final Matcher matcher = Pattern.compile(regex, Pattern.MULTILINE).matcher(operation);
//            final Matcher SpecialOperatorMatcher = Pattern.compile(SpecialOperatorRegex, Pattern.MULTILINE).matcher(operation);

            while (matcher.find()) {
                operation = operation.replace("+-", "-").replace("-+", "-");
                operation = operation.replace("++", "+").replace("--", "+");
            }


        }
        return this.nextInChain.handle(operation);
    }
}
// --- DO NOT EDIT BELOW THIS LINE ---

