package controller;

import java.util.Arrays;
public class NonArrayHandler implements IChain {
    // TODO: Implement the handle method
    private IChain nextInChain;
    @Override
    public void setNext(IChain nextIChain) {
          this.nextInChain = nextIChain;
    }

    @Override
    public double handle(String operation) {
        String[] operands = operation.split("[+\\-\\s]");
        if(operands[0].matches("[+\\-\\s]")){
            operands[0] = String.valueOf(Double.parseDouble(operands[1]) * -1);
            return Double.parseDouble(Arrays.toString(operands));
        }
        else if (operation.contains("--")) {
            operation = operation.replaceAll("--", "-");
        }
        else if (operation.contains("-+") || operation.contains("+-")) {
            operation = operation.replaceAll("-\\+", "-");
        }
        else if (operation.contains("++")) {
            operation = operation.replaceAll("\\++", "+");
        }

        return this.nextInChain.handle(operation);
    }
}
// --- DO NOT EDIT BELOW THIS LINE ---

