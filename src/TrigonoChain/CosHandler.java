package TrigonoChain;

public class CosHandler implements TChain {
        private TChain nextInTChain;

    @Override
    public void setNext(TChain nextTChain) {
    this.nextInTChain = nextTChain;
    }

    @Override
    public double handle(String expression) {
        if (expression.contains("cos")) {
            String[] expressionArray = expression.split("cos");
            return Math.cos(this.nextInTChain.handle(expressionArray[1]));
        }
        return nextInTChain.handle(expression);
    }
}
