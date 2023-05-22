package FunctionsChain;

public class DefaultHandler implements FChain {
    @Override
    public void setNext(FChain nextFChain) {
        // TODO Auto-generated method stub
    }

    @Override
    public double handle(String expression) {
        return Double.parseDouble(expression);
    }
}
