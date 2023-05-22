package FunctionsChain;

import lib.Maths;

public class CosecHandler implements FChain {
    private FChain nextInFChain;

    @Override
    public void setNext(FChain nextFChain) {
    this.nextInFChain = nextFChain;
    }

    @Override
    public double handle(String expression) {
        if (expression.contains("csc")) {
            String[] expressionArray = expression.split("csc");
            return Maths.cosec(this.nextInFChain.handle(expressionArray[1]));
        }
        return nextInFChain.handle(expression);
    }
}
