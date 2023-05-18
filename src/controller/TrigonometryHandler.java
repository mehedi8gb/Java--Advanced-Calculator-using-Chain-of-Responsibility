package controller;

public class TrigonometryHandler implements IChain {

    private IChain nextInIChain;

    @Override
    public void setNext(IChain nextIChain) {
        this.nextInIChain = nextIChain;
    }
    @Override
    public double handle(String operation) {
        String[] operands;
        if (operation.contains("sin(")) {
             operands = operation.split("sin\\((\\d+)\\)");
            operation = operation.replaceAll("sin\\((\\d+)\\)",String.valueOf(Math.sin(nextInIChain.handle(operands[1]))));
            return operation.contains("sin(") ? this.handle(operation) : nextInIChain.handle(operation);
        } else if (operation.contains("cos")) {
              operands = operation.split("cos");
            return Math.cos(nextInIChain.handle(operands[1]));
        } else if (operation.contains("tan")) {
              operands = operation.split("tan");
            return Math.tan(nextInIChain.handle(operands[1]));
        } else if (operation.contains("cot")) {
              operands = operation.split("cot");
            return 1 / Math.tan(nextInIChain.handle(operands[1]));
        } else if (operation.contains("sec")) {
              operands = operation.split("sec");
            return 1 / Math.cos(nextInIChain.handle(operands[1]));
        } else if (operation.contains("csc")) {
              operands = operation.split("csc");
            return 1 / Math.sin(nextInIChain.handle(operands[1]));
        } else {
            return this.nextInIChain.handle(operation);
        }
    }
}
