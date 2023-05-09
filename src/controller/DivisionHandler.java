package controller;

import java.util.ArrayList;
import java.util.List;

public class DivisionHandler implements IChain {

    private IChain nextInIChain;

    @Override
    public void setNext(IChain nextIChain) {
        this.nextInIChain = nextIChain;
    }

    @Override
    public double handle(String operation) {
        if (operation.contains("/")) {
            String[] equations = operation.split("\\s+");
            List<String> remainingEquations = new ArrayList<>();
            double total = 0.0;

            for (String equation : equations) {
                if (!equation.contains("/")) {
                    remainingEquations.add(equation);
                } else {
                    String[] operands = equation.split("\\/");
                    double result = this.nextInIChain.handle(operands[0]);
                    for (int i = 1; i < operands.length; i++) {
                        result /= this.nextInIChain.handle(operands[i]);
                    }
                    total += result;
                }
            }

            remainingEquations.add(Double.toString(total));

            String[] output = new String[remainingEquations.size()];
            output = remainingEquations.toArray(output);
            return total;
        } else {
            return this.nextInIChain.handle(operation);
        }
    }
}