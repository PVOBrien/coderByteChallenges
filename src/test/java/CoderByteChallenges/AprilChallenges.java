package CoderByteChallenges;

import org.junit.jupiter.api.*;

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
            Assertions.assertEquals("aksfaje", MinWinSubstring.minWindowSubstring(testArrOne));
        }

        @Test
        @DisplayName("One, Custom")
        public void minWinTestOneCustom() {
            MinWinSubstring minWinSubstring = new MinWinSubstring();
//            MinWinSubstring.minWindowSubstring(testArrOne);
            System.out.println("");
            Assertions.assertEquals("aksfaje", MinWinSubstring.minWindowSubstring(testArrOneCustom));
        }

        @Test
        @DisplayName("Custom Three")
        public void minWinTestThreeC() {
            MinWinSubstring minWinSubstring = new MinWinSubstring();
//            MinWinSubstring.minWindowSubstring(testArrOne);
            System.out.println("");
            Assertions.assertEquals("affhkkse", MinWinSubstring.minWindowSubstring(testArrThreeCustom));
        }

    }
}
