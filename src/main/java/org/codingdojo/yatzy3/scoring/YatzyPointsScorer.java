package org.codingdojo.yatzy3.scoring;

import org.codingdojo.yatzy3.utils.DiceUtils;
import org.codingdojo.yatzy3.calculator.ScoreCalculator;

import java.util.List;

public class YatzyPointsScorer implements ScoreCalculator {
    @Override
    public int calculateScore(List<Integer> dice) {
        if (DiceUtils.calculateFrequencies(dice).containsValue(5)) {
            return 50;
        }
        return 0;
    }
}
