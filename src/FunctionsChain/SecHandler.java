package FunctionsChain;

import lib.Maths;

public class SecHandler implements FChain {
    private FChain nextInFChain;

    @Override
    public void setNext(FChain nextFChain) {
    this.nextInFChain = nextFChain;
    }

    @Override
    public double handle(String expression) {
        if (expression.contains("sec")) {
            String[] expressionArray = expression.split("sec");
            return Maths.sec(this.nextInFChain.handle(expressionArray[1]));
        }
        return nextInFChain.handle(expression);
    }
}
