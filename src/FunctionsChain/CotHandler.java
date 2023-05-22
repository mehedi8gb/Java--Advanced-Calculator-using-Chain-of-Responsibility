package FunctionsChain;

import lib.Maths;

public class CotHandler implements FChain {
    private FChain nextInFChain;

    @Override
    public void setNext(FChain nextFChain) {
    this.nextInFChain = nextFChain;
    }

    @Override
    public double handle(String expression) {
        if (expression.contains("cot")) {
            String[] expressionArray = expression.split("cot");
            return Maths.cot(this.nextInFChain.handle(expressionArray[1]));
        }
        return nextInFChain.handle(expression);
    }
}
