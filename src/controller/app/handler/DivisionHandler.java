package controller.app.handler;

import controller.app.ResponsibilityChain;
import controller.app.sys.Context;

import java.util.ArrayList;
import java.util.List;

public class DivisionHandler implements ResponsibilityChain {

    private ResponsibilityChain nextInResponsibilityChain;

    @Override
    public void setNext(final ResponsibilityChain nextResponsibilityChain) {
        this.nextInResponsibilityChain = nextResponsibilityChain;
    }

    @Override
    public double handle(String operation) {

        if (operation.contains("/") && Context.shouldContinue()) {
            List<String> equations = new ArrayList<>(List.of(operation.split("/")));
            double total = nextInResponsibilityChain.handle(equations.get(0));
            for (int i = 1; i < equations.size(); i++) {
                    total /= nextInResponsibilityChain.handle(equations.get(i));
            }
            return total;
        } else {
            return this.nextInResponsibilityChain.handle(operation);
        }
    }
}