package controller;

public class SubtractionHandler implements Chain {

    private Chain nextInChain;

    @Override
    public void setNext(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public double handle(String operation) {
        if (operation.contains("-")) {
            String[] operands = operation.split("\\-");
            double result = this.nextInChain.handle(operands[0]);
            for (int i = 1; i < operands.length; i++) {
                result -= this.nextInChain.handle(operands[i]);
            }
            return result;
        } else {
            return this.nextInChain.handle(operation);
        }
    }
}
