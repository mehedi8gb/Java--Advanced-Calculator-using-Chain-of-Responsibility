package controller.app.sys;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Context {
    private static boolean flag = true;
    private static boolean specialFlag = false;

    public static boolean getFlag() {
        return flag;
    }

    public static boolean shouldContinue() {
        return flag;
    }

    public static void setFlag(boolean flag) {
        Context.flag = flag;
    }

    public static boolean shouldContinueSpecialOperation() {
        return specialFlag;
    }

    public static void setContinueSpecialOperation(boolean flag) {
       specialFlag = flag;
    }

    public static List<Double> extractNumberGroup(String expression, String regex) {
        List<Double> numberGroup = new ArrayList<>();

        // Create a pattern object
        Pattern functionRegex = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = functionRegex.matcher(expression);

        // Find all matches and extract the numbers
        while (matcher.find()) {
            String numberStr = matcher.group(1);
            double number = Double.parseDouble(numberStr);
            numberGroup.add(number);
        }

        return numberGroup;
    }
}
