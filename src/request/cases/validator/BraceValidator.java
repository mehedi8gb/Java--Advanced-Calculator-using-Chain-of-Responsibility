package request.cases.validator;

import request.exception.InvalidRequestException;

import java.util.Stack;

public class BraceValidator {
    private static final char OPEN_BRACE = '(';
    private static final char CLOSE_BRACE = ')';

    public String validateRequest(String request) throws InvalidRequestException {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < request.length(); i++) {
            char c = request.charAt(i);

            if (c == OPEN_BRACE) {
                stack.push(c);
            } else if (c == CLOSE_BRACE) {
                if (stack.isEmpty()) {
                    throw new InvalidRequestException("Unmatched closing brace");
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            System.out.println(stack.toString());
            throw new InvalidRequestException("Error: Unmatched opening brackets");
        }
        return request;
    }
}

