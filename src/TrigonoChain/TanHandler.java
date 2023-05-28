package TrigonoChain;

public class TanHandler implements TChain{
    private TChain nextInTChain;

    @Override
    public void setNext(TChain nextTChain) {
    this.nextInTChain = nextTChain;
    }

    @Override
    public double handle(String expression) {
      if (expression.contains("tan")) {
            String[] expressionArray = expression.split("tan");
            return Math.tan(this.nextInTChain.handle(expressionArray[1]));
        }
        return nextInTChain.handle(expression);
    }
}
