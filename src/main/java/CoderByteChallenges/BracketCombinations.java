package CoderByteChallenges;

import java.util.HashSet;
import java.util.Set;

public class BracketCombinations {
    public static int bracketCombinations(int num) {
        if (num < 3) return num;

        Set<String> bracketCombos = new HashSet<>();
        bracketCombos = bracketCreator(new StringBuilder("()"), bracketCombos, 1, num);
        return bracketCombos.size();
    }

    private static Set<String> bracketCreator(StringBuilder brackets, Set<String> bracketSet, int currentCount, int stoppingPoint) {
        if (currentCount == stoppingPoint) { // uncertain if this is the correct place...
            bracketSet.add(brackets.toString());
            return bracketSet;
        }
        for (int i = 0; i < brackets.length(); i++) {
            StringBuilder nextLevelSB = new StringBuilder(brackets);
            nextLevelSB.insert(i, "()");
            bracketSet = bracketCreator(nextLevelSB, bracketSet, currentCount + 1, stoppingPoint);
        }
        return bracketSet;
    }
}
