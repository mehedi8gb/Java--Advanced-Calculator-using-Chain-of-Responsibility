package TrigonoChain;

public class SecHandler implements TChain{
        private TChain nextInTChain;

    @Override
    public void setNext(TChain nextTChain) {
    this.nextInTChain = nextTChain;
    }

    @Override
    public double handle(String expression) {
        String[] expressionArray = expression.split("sin(\\(|)");
        if (expressionArray[0].equals("sin")) {
            double deg = Math.toRadians(this.nextInTChain.handle(expressionArray[1]));
            double value = Math.sin(deg);
            return Math.round(value);
        }
        return nextInTChain.handle(expression);
    }
}
