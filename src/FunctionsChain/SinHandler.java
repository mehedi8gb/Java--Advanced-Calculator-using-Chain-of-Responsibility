package FunctionsChain;

public class SinHandler implements FChain {

    private FChain nextInFChain;

    @Override
    public void setNext(FChain nextFChain) {
    this.nextInFChain = nextFChain;
    }

    @Override
    public double handle(String expression) {
        if (expression.contains("sin")) {
            String[] expressionArray = expression.split("sin");
            return Math.sin(this.nextInFChain.handle(expressionArray[1]));
        }
        return nextInFChain.handle(expression);
    }
}
