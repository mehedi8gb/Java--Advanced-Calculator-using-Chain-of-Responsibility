package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnaryHandler implements IChain {
    // TODO: Implement the handle method
    private IChain nextInChain;
    private boolean flag = true;

    @Override
    public void setNext(final IChain nextIChain) {
          this.nextInChain = nextIChain;
    }

    @Override
    public double handle(String operation) {
        final String regex = "(\\+\\+)|(--)|(\\+-)|(-\\+)";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(operation);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
                   operation = operation.replace("+-", "-").replace("-+", "-");
                   operation = operation.replace("++", "+").replace("--", "+");
        }
            System.out.println(operation);
        return this.nextInChain.handle(operation);
    }
}
// --- DO NOT EDIT BELOW THIS LINE ---

