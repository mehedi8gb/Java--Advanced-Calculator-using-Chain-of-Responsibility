package TrigonoChain;

import controller.IChain;

public interface TChain {

        void setNext(final TChain nextTChain, IChain nextInIChain);

        double handle(String functionName, String value);
}
