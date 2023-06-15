package controller.app;
public interface ResponsibilityChain {

    void setNext(final ResponsibilityChain nextResponsibilityChain);

    double handle(String operation);
}
