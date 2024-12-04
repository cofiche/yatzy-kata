package org.codingdojo.yatzy3.scoring;

import org.codingdojo.yatzy3.utils.DiceUtils;
import org.codingdojo.yatzy3.calculator.ScoreCalculator;

import java.util.List;

public class NumberScorer implements ScoreCalculator {
    private final int number;

    public NumberScorer(int number) {
        this.number = number;
    }

    @Override
    public int calculateScore(List<Integer> dice) {
        return DiceUtils.calculateFrequencies(dice).get(number) * number;
    }
}
