package TrigonoChain;

import lib.Maths;

public class CotHandler implements TChain {
        private TChain nextInTChain;

    @Override
    public void setNext(TChain nextTChain) {
    this.nextInTChain = nextTChain;
    }

    @Override
    public double handle(String expression) {
        String[] expressionArray = expression.split("cot(\\(|)");
        if (expressionArray[0].equals("cot")) {
            double deg = Math.toRadians(this.nextInTChain.handle(expressionArray[1]));
//            double value = Maths.cot(deg);
//            return Math.round(value);
        }
        return nextInTChain.handle(expression);
    }
}
