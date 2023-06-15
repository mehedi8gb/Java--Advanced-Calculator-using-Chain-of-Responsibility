package controller.app.handler;

import controller.app.ResponsibilityChain;

public class DefaultHandler implements ResponsibilityChain {
    private ResponsibilityChain nextInResponsibilityChain;
    @Override
    public void setNext(final ResponsibilityChain nextResponsibilityChain) {
      //
    }

    @Override
    public double handle(String operation) {
        return Double.parseDouble(operation);
    }
}
