package problem.hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class Problem68Test {

    @Test
    public void testCalculateFrequencyAndAverage() {
        Map<Integer, String> expected = Map.of(
                1, "Freq: 2, Avg: 1.75",
                2, "Freq: 1, Avg: 1.75",
                3, "Freq: 1, Avg: 1.75"
        );
        assertEquals(expected, Problem68.calculateFrequencyAndAverage(Arrays.asList(1, 2, 1, 3)));
    }
}
