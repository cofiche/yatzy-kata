package org.codingdojo.yatzy3.scoring;

import org.codingdojo.yatzy3.utils.DiceUtils;
import org.codingdojo.yatzy3.calculator.ScoreCalculator;

import java.util.List;

public class ChanceScorer implements ScoreCalculator {
    @Override
    public int calculateScore(List<Integer> dice) {
        return DiceUtils.calculateSum(dice);
    }
}
