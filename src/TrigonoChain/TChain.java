package TrigonoChain;

public interface TChain {

        void setNext(final TChain nextTChain);

        double handle(String expression);
}
