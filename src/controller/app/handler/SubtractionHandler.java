package controller.app.handler;

import controller.app.ResponsibilityChain;
import controller.app.sys.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class SubtractionHandler implements ResponsibilityChain {

    private ResponsibilityChain nextInResponsibilityChain;

    @Override
    public void setNext(final ResponsibilityChain nextResponsibilityChain) {
        nextInResponsibilityChain = nextResponsibilityChain;
    }

    @Override
    public double handle(String operation) {
        if (operation.contains("-") && !operation.contains("*-") && Context.shouldContinue()) {
            ArrayList<String> operands = new ArrayList<>(Arrays.asList(operation.split("-")));
            double result;
            if (operands.get(0).isEmpty() && Pattern.compile("^-").matcher(operation).find()) {

                operands.remove(0);
                return nextInResponsibilityChain.handle(operands.get(0)) * -1;
            }
            if (operation.contains("*-")) {
                return nextInResponsibilityChain.handle(operation);
            }

            result = nextInResponsibilityChain.handle(operands.get(0));
            for (int i = 1; i < operands.size(); i++) {
                result -= nextInResponsibilityChain.handle(operands.get(i));
            }
            return result;
        } else {
            return nextInResponsibilityChain.handle(operation);
        }
    }
}
