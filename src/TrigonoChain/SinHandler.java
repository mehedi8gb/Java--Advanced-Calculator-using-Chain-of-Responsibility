package TrigonoChain;

public class SinHandler implements TChain{

    private TChain nextInTChain;

    @Override
    public void setNext(TChain nextTChain) {
    this.nextInTChain = nextTChain;
    }

    @Override
    public double handle(String expression) {
        if (expression.contains("sin")) {
            String[] expressionArray = expression.split("sin");
            double deg = Math.toRadians(this.nextInTChain.handle(expressionArray[1]));
            double value = Math.sin(deg);
            return Math.round(value);
        }
        return nextInTChain.handle(expression);
    }
}
