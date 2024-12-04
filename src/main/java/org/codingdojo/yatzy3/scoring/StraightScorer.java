package org.codingdojo.yatzy3.scoring;

import org.codingdojo.yatzy3.calculator.ScoreCalculator;

import java.util.List;

import static org.codingdojo.yatzy3.utils.DiceUtils.calculateFrequencies;
import static org.codingdojo.yatzy3.utils.DiceUtils.calculateSum;

public class StraightScorer implements ScoreCalculator {
    private final int straightIncludes;

    public StraightScorer(int straightIncludes) {
        this.straightIncludes = straightIncludes;
    }

    @Override
    public int calculateScore(List<Integer> dice) {
        if (isStraight(dice) && calculateFrequencies(dice).get(straightIncludes) != 0) {
            return calculateSum(dice);
        }
        return 0;
    }

    private boolean isStraight(List<Integer> dice) {
        return calculateFrequencies(dice).values().stream().filter(f -> f == 1).toList().size() == 5;
    }
}
