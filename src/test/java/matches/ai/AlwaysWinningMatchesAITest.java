package matches.ai;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlwaysWinningMatchesAITest {

    @Test
    public void testPickMatches() {
        AlwaysWinningMatchesAI ai = new AlwaysWinningMatchesAI();
        int[][] testData = {
            { 6, 3, 1 },
            { 5, 3, 3 },
            { 4, 3, 3 },
            { 3, 3, 2 },
            { 2, 3, 1 },
        };

        for (int[] testDatum : testData) {
            assertEquals(
                String.format("Matches left = %d, max matches = %d.", testDatum[0], testDatum[1]),
                testDatum[2],
                ai.pickMatches(testDatum[0], testDatum[1])
            );
        }

    }
}
