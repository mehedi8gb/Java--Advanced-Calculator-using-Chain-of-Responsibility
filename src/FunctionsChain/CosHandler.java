package FunctionsChain;

public class CosHandler implements FChain {
        private FChain nextInFChain;

    @Override
    public void setNext(FChain nextFChain) {
    this.nextInFChain = nextFChain;
    }

    @Override
    public double handle(String expression) {
      if (expression.contains("cos")) {
            String[] expressionArray = expression.split("cos");
            return Math.cos(this.nextInFChain.handle(expressionArray[1]));
        }
        return nextInFChain.handle(expression);
    }
}
