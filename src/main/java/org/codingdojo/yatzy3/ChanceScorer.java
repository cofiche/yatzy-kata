package org.codingdojo.yatzy3;

import java.util.List;

public class ChanceScorer implements ScoreCalculator {
    @Override
    public int calculateScore(List<Integer> dice) {
        return DiceUtils.calculateSum(dice);
    }
}
