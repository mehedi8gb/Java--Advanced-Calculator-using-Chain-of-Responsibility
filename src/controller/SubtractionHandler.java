package controller;

public class SubtractionHandler implements IChain {

    private IChain nextInIChain;

    @Override
    public void setNext(final IChain nextIChain) {
        nextInIChain = nextIChain;
    }

    @Override
    public double handle(final String operation) {
        if (operation.contains("-") && !operation.startsWith("-") && !operation.contains("--")) {
            final String[] operands = operation.split("\\-");
            double result = nextInIChain.handle(operands[0]);
            for (int i = 1; i < operands.length; i++) {
                result -= nextInIChain.handle(operands[i]);
            }
            return result;
        } else {
            return nextInIChain.handle(operation);
        }
    }
}
