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
            return Math.sin(this.nextInTChain.handle(expressionArray[1]));
        }
        return nextInTChain.handle(expression);
    }
}
