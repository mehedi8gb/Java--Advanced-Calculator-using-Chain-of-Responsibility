package controller;

public class PowerHandler implements IChain{
    private IChain nextInIChain;
                private double result;
    @Override
    public void setNext(final IChain nextIChain) {
        this.nextInIChain = nextIChain;
    }

    @Override
     public double handle(String operation) {
        if (operation.contains("*-"))
            nextInIChain.handle(operation);
        if (operation.contains("^")) {
            final String[] operands = operation.split("\\^");
//            double result = nextInIChain.handle(operands[0]);
            for (String operand : operands) {
                this.result = Math.pow(Double.parseDouble(operands[0]), Double.parseDouble(operands[1]));
            }
            return this.result;
        } else {
            return this.nextInIChain.handle(operation);
        }
    }
}
