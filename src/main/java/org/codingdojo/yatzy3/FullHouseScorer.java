package org.codingdojo.yatzy3;

import java.util.List;
import java.util.Map;

public class FullHouseScorer implements ScoreCalculator {
    @Override
    public int calculateScore(List<Integer> dice) {
        Map<Integer, Integer> frequencies = DiceUtils.calculateFrequencies(dice);
        if (frequencies.containsValue(2) && frequencies.containsValue(3)) {
            return DiceUtils.calculateSum(dice);
        }
        return 0;
    }
}
