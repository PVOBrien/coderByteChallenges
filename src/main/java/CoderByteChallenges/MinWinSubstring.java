package CoderByteChallenges;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MinWinSubstring {
    public static String minWindowSubstring(String[] strArr) {
        String strToCheck = strArr[0]; // make it easily readable
        String charsInRegex = strArr[1];
        List<String> results = new ArrayList<>();
        String thisWindow = null;

        String charsToRegex = String.format("[%s]", strArr[1]); // make it easily readable
        Pattern pattern = Pattern.compile(charsToRegex);
        Matcher matcher;

        for (int i = strToCheck.length() - 1; i > 1; i--) { // remove end chars that will never be used because they are not chars to include/check for.
            CharSequence letterToCheck = strToCheck.substring(i, i + 1);
            matcher = pattern.matcher(letterToCheck);
            if (matcher.matches()) {
                strToCheck = strToCheck.substring(0, i + 1);
                break;
            }
        }

        int counter = 0; // realized I did need a counter, but was already to deep into the enhanced for loop
        String stringForRegexCheck = strToCheck;
        for (Character letter : strToCheck.toCharArray()) {
            boolean canFind = true;
            String currentSubString = stringForRegexCheck.substring(counter);
            for (int i = 0; i < charsInRegex.length(); i++) {
                String thisChar = Character.toString(charsInRegex.charAt(i));

                if (!currentSubString.contains(thisChar)) { // checks to ensure the string WILL satisfy the necessary characters
                    canFind = false;
                    System.out.println("Letter:" + letter + "strToCheck Substring: " + strToCheck.substring(counter));
                } else {
                    currentSubString = currentSubString.replaceFirst(Character.toString(charsInRegex.charAt(i)), ""); // this is necessary otherwise if there's only one letter in the string, but two needing to be satisfied, this would still trip the flag.
                }
            }

            matcher = pattern.matcher(letter.toString());
            if (canFind // ensures it's possible at all.
                    && matcher.matches() // checks if the first letter is relevant.
                    && strToCheck.substring(counter).length() > charsInRegex.length()) { // perhaps not necessary in this code challenge it is guaranteed always to solve wo exception.
                charsToRegex = charsToRegex.replaceFirst(letter.toString(), "");
                thisWindow = windowSearcherFunction(strToCheck.substring(counter), 0, charsToRegex, strToCheck); // begin recursion!
                results.add(thisWindow);
            }
            counter++;
            stringForRegexCheck = strToCheck; // restore string for next regex check.
        }

        results.sort(Comparator.comparingInt(String::length)); // compliment of
        return results.get(0);
    }

    private static String windowSearcherFunction(String currentString, int counter, String regex, String fullString) {

        if (regex.length() == 2) {
            return currentString.substring(0, counter); // base case (because the challenge is happy and can always be solved) // todo: show error with equal 0
        }

        if (currentString.length() < regex.length()) return fullString;

        String letter = currentString.substring(counter, counter + 1);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(letter); // this would have to be checked if it weren't guaranteed that the string contained all necessary letters.

        if (matcher.matches()) {
            regex = regex.replaceFirst(letter, "");
        }
        return windowSearcherFunction(currentString, counter+1, regex, fullString); // needs more testing here.
    }
}
