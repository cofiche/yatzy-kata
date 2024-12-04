package org.codingdojo.yatzy3.scoring;

import org.codingdojo.yatzy3.utils.DiceUtils;
import org.codingdojo.yatzy3.calculator.ScoreCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RepeatedCountScorer implements ScoreCalculator {
    private final int count;

    public RepeatedCountScorer(int count) {
        this.count = count;
    }

    @Override
    public int calculateScore(List<Integer> dice) {
        Map<Integer, Integer> frequencies = DiceUtils.calculateFrequencies(dice);
        for (int i : Arrays.asList(6, 5, 4, 3, 2, 1)) {
            if (frequencies.get(i) >= count) {
                return i * count;
            }
        }
        return 0;
    }
}
