package TrigonoChain;

public class TanHandler implements TChain{
    private TChain nextInTChain;

    @Override
    public void setNext(TChain nextTChain) {
    this.nextInTChain = nextTChain;
    }

    @Override
    public double handle(String expression) {
        String[] expressionArray = expression.split("tan(\\(|)");
        if (expressionArray[0].equals("tan")) {
            double deg = Math.toRadians(this.nextInTChain.handle(expressionArray[1]));
            double value = Math.tan(deg);
            return Math.round(value);
        }
        return nextInTChain.handle(expression);
    }
}
