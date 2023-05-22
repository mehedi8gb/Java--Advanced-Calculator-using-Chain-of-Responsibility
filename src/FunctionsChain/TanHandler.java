package FunctionsChain;

public class TanHandler implements FChain {
    private FChain nextInFChain;

    @Override
    public void setNext(FChain nextFChain) {
    this.nextInFChain = nextFChain;
    }

    @Override
    public double handle(String expression) {
        if (expression.contains("tan")) {
            String[] expressionArray = expression.split("tan");
            return Math.tan(this.nextInFChain.handle(expressionArray[1]));
        }
        return nextInFChain.handle(expression);
    }
}
