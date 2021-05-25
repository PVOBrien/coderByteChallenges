package CoderByteChallenges;

import java.util.Stack;

public class BracketMatcher {

    public static String BracketMatcher(String str) {
        Stack<String> bStack = new Stack();

        for (char theLetter : str.toCharArray()) {
            if (theLetter == '(') {
                bStack.add("x");
            }
            if (theLetter == (')') && bStack.isEmpty()) {
                return "0";
            } else if (theLetter == ')') {
                bStack.pop();
            }
        }

        return bStack.isEmpty() ? "1" : "0";
    }
}
