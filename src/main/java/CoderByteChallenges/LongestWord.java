package CoderByteChallenges;

import java.util.Arrays;

public class LongestWord {

    public String longWordFinder(String sen) {

        String resultWord = "";

        String[] arrSen = sen.split("[^a-zA-Z\\\\d]+");
        System.out.println("arrSen" + Arrays.toString(arrSen));
        for (String string: arrSen) {
            if (string.length() > resultWord.length()) resultWord = string;
            }

        return resultWord;
    }
}
