package CoderByteChallenges;

import org.junit.jupiter.api.*;

public class AugustChallenges {

    @Nested
    @DisplayName("Easy Peasy Longest Word")
    class LongestWordTest {

        String testtest = "I am too sore evens steven";
        String testWnonLetters = "fun&!! time";

        @Test
        @DisplayName("Run the tests")
        public void testOne() {
            LongestWord lw = new LongestWord();
            Assertions.assertEquals("steven", lw.longWordFinder(testtest));
        }

        @Test
        @DisplayName("Run the tests 2 now with nonLetters")
        public void testTwo() {
            LongestWord lw = new LongestWord();
            Assertions.assertEquals("time", lw.longWordFinder(testWnonLetters));
        }

    }

}
