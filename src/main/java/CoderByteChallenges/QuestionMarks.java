package CoderByteChallenges;

import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuestionMarks {

    public static String QuestionsMarks(String str) {

        boolean isContained = false;

        final Pattern digitPattern = Pattern.compile("\\d");
        final Pattern questionPattern = Pattern.compile("\\?");
        final Matcher digitMatcher = digitPattern.matcher(str);

        int digitStart;
        int digitEnd;

        if (digitMatcher.find()) {
            digitStart = digitMatcher.start();
        } else {
            return Boolean.toString(false);
        }

        while (digitMatcher.find()) {
            digitEnd = digitMatcher.start();
            if (Integer.parseInt(str.substring(digitStart, digitStart + 1)) + Integer.parseInt(str.substring(digitEnd, digitEnd + 1)) == 10) {
                Matcher questionMatcher = questionPattern.matcher(str.substring(digitStart + 1, digitEnd));
                int qMarkCount = 0;
                while (questionMatcher.find()) {
                    qMarkCount++;
                }
                isContained = qMarkCount == 3; // TODO: these two lines can be refactored prettier
                if (!isContained) return "false";
            }
            digitStart = digitEnd;
        }
        return isContained ? "true" : "false";
    }
}
