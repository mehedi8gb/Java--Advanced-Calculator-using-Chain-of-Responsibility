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
            for (String operand : operands) {
                this.result = Math.pow(this.nextInIChain.handle(String.valueOf(Double.parseDouble(operands[0]))),
                        this.nextInIChain.handle(String.valueOf(Double.parseDouble(operands[1]))));
            }
            return this.result;
        } else {
            return this.nextInIChain.handle(operation);
        }
    }
}
