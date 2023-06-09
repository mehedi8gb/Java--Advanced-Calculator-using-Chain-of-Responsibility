package TrigonoChain;

import controller.Calculator;
import controller.IChain;

public class TanHandler implements TChain{
     private IChain nextInIChain;
    private TChain nextInTChain;

    @Override
    public void setNext(TChain nextTChain, IChain nextInIChain) {
        this.nextInIChain = nextInIChain;
        this.nextInTChain = nextTChain;
    }

    @Override
    public double handle(String functionName, String value) {
        if (functionName.equals("tan")) {
            return Math.tan(this.nextInIChain.handle(value));
        }

        return nextInTChain.handle(functionName, value);
    }
}
