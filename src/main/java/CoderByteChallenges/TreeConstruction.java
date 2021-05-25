package CoderByteChallenges;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreeConstruction {

    public static String TreeConstructor(String[] strArr) {
        // check for true that each tree node has only 2 child nodes hence binary tree.
        // heck, if the only detail being checked is that a node has two children, then just checking if there is any instance of the same digit > 2 times, it'll do the trick.
        Boolean endBool = false;
        Map<String, Integer> bstCheck = new HashMap<>();
        String lastDigits = "";
        String firstDigits;

        String lastDigitsRegex = "(\\d+)(?!.*\\d)"; // the second () is negative lookahead, aka going forward, there will be no additional matches able to be made in the enclosed pattern.
        Pattern lastDigitsPattern = Pattern.compile(lastDigitsRegex);

        String firstDigitsRegex = "(\\d+)"; // captures first instance of a digits group.
        Pattern firstDigitsPattern = Pattern.compile(firstDigitsRegex);

        for (String bstString : strArr) {
            System.out.println(bstString);
            Matcher lastMatcher = lastDigitsPattern.matcher(bstString);
//            Matcher firstMatcher = firstDigitsPattern.matcher(bstString);
            if (lastMatcher.find()) {
                lastDigits = bstString.substring(lastMatcher.start(), lastMatcher.end());
            }

//            if (firstMatcher.find()) {
//                firstDigits = bstString.substring(firstMatcher.start(), firstMatcher.end());
//            }

            if (bstCheck.containsKey(lastDigits)) {
                int next = bstCheck.get(lastDigits) + 1;
                bstCheck.put(lastDigits, next);
            } else {
                System.out.println("hit");
                bstCheck.put(lastDigits, 1);
            }
            System.out.println(bstCheck.get(lastDigits));

            if (bstCheck.get(lastDigits) > 2) return "false";
        }

        return Boolean.toString(true);
    }
}

