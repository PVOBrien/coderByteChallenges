package CoderByteChallenges;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import org.w3c.dom.ls.LSOutput;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("www.coderbyte.com")
public class AprilChallenges {


    @Nested
    @DisplayName("MinWinSubstringTests")
    class MinWinSubStringTests {

        String[] testArrOne = {"ahffaksfajeeubsne", "jefaa"};
        String[] testArrOneCustom = {"aksfajeeubsne", "jefaa"};
        String[] testArrTwo = {"aaffhkksemckelloe", "fhaa"};
        String[] testArrThreeCustom = {"affhkkse", "fhea"};
        String[] testArrThree = {"aaffhkksemckelloe", "fhea"};


        @Test
        @DisplayName("One")
        public void minWinTestOne() {
            MinWinSubstring minWinSubstring = new MinWinSubstring();
//            MinWinSubstring.minWindowSubstring(testArrOne);
            System.out.println("");
            assertEquals("aksfaje", MinWinSubstring.minWindowSubstring(testArrOne));
        }

        @Test
        @DisplayName("One, Custom")
        public void minWinTestOneCustom() {
            MinWinSubstring minWinSubstring = new MinWinSubstring();
//            MinWinSubstring.minWindowSubstring(testArrOne);
            System.out.println("");
            assertEquals("aksfaje", MinWinSubstring.minWindowSubstring(testArrOneCustom));
        }

        @Test
        @DisplayName("Custom Three")
        public void minWinTestThreeC() {
            MinWinSubstring minWinSubstring = new MinWinSubstring();
//            MinWinSubstring.minWindowSubstring(testArrOne);
            System.out.println("");
            assertEquals("affhkkse", MinWinSubstring.minWindowSubstring(testArrThreeCustom));
        }
    }

    @Nested
    @DisplayName("Bracket Combos")
    class BracketCombinationsTest {

        @Test
        @DisplayName("sanity for 0")
        public void bracketTestOne() {
            assertEquals (0, BracketCombinations.bracketCombinations(0));
        }

        @Test
        @DisplayName("sanity for 1")
        public void bracketTestTwo() {
            assertEquals (1, BracketCombinations.bracketCombinations(1));
        }

        @Test
        @DisplayName("sanity for 2")
        public void bracketTestThree() {
            assertEquals (2, BracketCombinations.bracketCombinations(2));
        }

        @Test
        @DisplayName("test for 3")
        public void bracketTestFour() {
            assertEquals (5, BracketCombinations.bracketCombinations(3));
        }

        @Test
        @DisplayName("test for 5")
        public void bracketTestFive() { // unknown if true!
            assertEquals (42, BracketCombinations.bracketCombinations(5));
        }
    }

    @Nested
    @DisplayName("Right Tree Form")
    class TreeConstructTest {

        String[] testString = new String[]{"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"};
        String[] testString2 = new String[]{"(1,2)", "(3,2)", "(2,12)", "(5,2)"};

        @Test
        @DisplayName("Tree time!")
        public void TreeTestOne() {
            assertEquals("true", TreeConstruction.TreeConstructor(testString));
        }

        @Test
        @DisplayName("Tree time!")
        public void TreeTestTwo() {
            assertEquals("false", TreeConstruction.TreeConstructor(testString2));
        }
    }

    @Nested
    @DisplayName("Bracket Matcher")
    class BracketMatcherTest {

        String testOne = "(coder)(byte))";
        String testTwo = "(c(oder)) b(yte)";

        @Test
        @DisplayName("Bracket One!")
        public void BrackAttackOne() {
            assertEquals("0", BracketMatcher.BracketMatcher(testOne));
        }

        @Test
        @DisplayName("Bracket Two!")
        public void BrackAttackTwo() {
            assertEquals("1", BracketMatcher.BracketMatcher(testTwo));
        }
    }
}
