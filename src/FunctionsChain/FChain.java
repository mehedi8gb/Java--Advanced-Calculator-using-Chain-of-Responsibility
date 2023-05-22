package FunctionsChain;

public interface FChain {

        void setNext(final FChain nextFChain);

        double handle(String expression);
}
