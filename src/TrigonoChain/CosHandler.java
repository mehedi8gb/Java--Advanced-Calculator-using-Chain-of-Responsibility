package TrigonoChain;

public class CosHandler implements TChain {
        private TChain nextInTChain;

    @Override
    public void setNext(TChain nextTChain) {
    this.nextInTChain = nextTChain;
    }

    @Override
    public double handle(String expression) {
        String[] expressionArray = expression.split("cos(\\(|)");
        if (expressionArray[0].equals("cos")) {
            double deg = Math.toRadians(this.nextInTChain.handle(expressionArray[1]));
            double value = Math.cos(deg);
            return Math.round(value);
        }
        return nextInTChain.handle(expression);
    }
}