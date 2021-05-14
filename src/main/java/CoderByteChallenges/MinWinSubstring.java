package CoderByteChallenges;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MinWinSubstring {
    public static String minWindowSubstring(String[] strArr) { // started @ 10:30 5/13 pause 11:25 back at 7:30
        String strToCheck = strArr[0]; // make it easily readable
        String charsToRegex = String.format("[%s]", strArr[1]); // make it easily readable
        ArrayList<String> results = new ArrayList<>();

        String minWindow = strToCheck; // starting "shortest"
        String thisWindow = null;

        System.out.println("String to check from Arr: " + strToCheck); // Sanity Checks
        System.out.println("Chars to Regex against: " + charsToRegex); // Sanity Checks

        Pattern pattern = Pattern.compile(charsToRegex);
        Matcher matcher;

        for (int i = strToCheck.length()-1; i > 1; i--) { // remove end chars that will never be used because they are not chars to include/check for.
            CharSequence letterToCheck = strToCheck.substring(i,i+1);
            matcher = pattern.matcher(letterToCheck);
            if (matcher.matches()) {
                strToCheck = strToCheck.substring(0, i+1);
                break;
            }
        }
        System.out.println("String to check after Arr strip(): " + strToCheck); // Sanity Checks

        int counter = 0;
        for (Character letter : strToCheck.toCharArray()) {
            matcher = pattern.matcher(letter.toString());
            if (matcher.matches()) { // not absolutely necessary in this code challenge it is guaranteed al
                charsToRegex = charsToRegex.replaceFirst(letter.toString(), "");
                System.out.println("cTR after: " + charsToRegex);
                thisWindow = windowSearcherFunction(strToCheck.substring(counter), counter, charsToRegex); // begin recursion!
            }
            results.add(thisWindow);
//            if (thisWindow.length() < minWindow.length()) minWindow = thisWindow;
            counter++;
        }
        System.out.println(results);
        strArr[0] = minWindow;
        return strArr[0];
    }

    private static String windowSearcherFunction(String currentString, int counter, String regex) {

        if (regex.length() == 2 || currentString.length() == 1) return currentString.substring(0, counter); // base case (because the challenge is happy and can always be solved) // todo: show error with equal 0

        String letter = currentString.substring(counter, counter+1);
        System.out.println("Regex: " + regex);
        System.out.println("InR, The letter: " + letter);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(letter); // this would have to be checked if it weren't guaranteed that the string contained all necessary letters.

        if (matcher.matches()) {
            regex = regex.replaceFirst(letter, "");
            System.out.println("success");
        }
        counter++;
        return windowSearcherFunction(currentString, counter, regex); // needs more testing here.
    }
}
