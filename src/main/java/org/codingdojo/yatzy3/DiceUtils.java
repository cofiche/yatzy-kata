package org.codingdojo.yatzy3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiceUtils {

    public static Map<Integer, Integer> calculateFrequencies(List<Integer> dice) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for (int i : Arrays.asList(6, 5, 4, 3, 2, 1)) {
            frequencies.put(i, 0);
        }
        for (int die : dice) {
            frequencies.put(die, frequencies.get(die) + 1);
        }

        return frequencies;
    }


    public static int calculateSum(List<Integer> dice) {
        return dice.stream().mapToInt(Integer::intValue).sum();
    }
}
