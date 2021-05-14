package CoderByteChallenges;

import org.junit.jupiter.api.*;

@DisplayName("www.coderbyte.com")
public class AprilChallenges {


    @Nested
    @DisplayName("MinWinSubstringTests")
    class MinWinSubStringTests {

        String[] testArrOne = {"ahffaksfajeeubsne", "jefaa"};
        String[] testArrTwo = {"aaffhkksemckelloe", "fhaa"};
        String[] testArrThree = {"aaffhkksemckelloe", "fhea"};

        @Test
        @DisplayName("Sanity Check")
        public void minWinTestOne() {
            MinWinSubstring minWinSubstring = new MinWinSubstring();
//            MinWinSubstring.minWindowSubstring(testArrOne);
            System.out.println("");
            Assertions.assertEquals("affhkkse", MinWinSubstring.minWindowSubstring(testArrThree));
        }

    }
}
