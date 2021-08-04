package CoderByteChallenges;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class JulyChallenges {

    @Nested
    @DisplayName("Between two digits that sum to 10 are exactly 3 ? marks")
    class QuestionMarksTest {

        String testOne = "acc?7??sss?3rr1??????5";
        String testTrue = "acc?7??sss?3";
        String testNinesOne = "9???1???9??1???9";
        String testOffFives = "5??aaaaaaaaaaaaaaaaaaa?5?5";
        String testFinale = "mbbv???????????4??????ddsdsdcc9?";

        @Test
        @DisplayName("finds the one group. true")
        public void qmSimple(){
            assertEquals("true", QuestionMarks.QuestionsMarks(testTrue));
        }

        @Test
        @DisplayName("finds the one group. true")
        public void qmOne(){
            assertEquals("true", QuestionMarks.QuestionsMarks(testOne));
        }

        @Test
        @DisplayName("finds the one group. true")
        public void qmNinesOnesTest(){
            assertEquals("false", QuestionMarks.QuestionsMarks(testNinesOne));
        }

        @Test
        @DisplayName("finds the one group. true")
        public void qmFivesTest(){
            assertEquals("false", QuestionMarks.QuestionsMarks(testOffFives));
        }

        @Test
        @DisplayName("finds the one group. true")
        public void qmFinaleTest(){
            assertEquals("false", QuestionMarks.QuestionsMarks(testFinale));
        }

    }

}
