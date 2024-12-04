package org.codingdojo.yatzy3;

import java.util.List;
import org.codingdojo.yatzy3.calculator.YatzyCalculator;
import org.codingdojo.yatzy3.categories.YatzyCategory;
import org.codingdojo.yatzy3.calculator.ScoreCalculator;
import org.codingdojo.yatzy3.factories.ScorerFactory;

public class Yatzy3 implements YatzyCalculator {

    @Override
    public int score(List<Integer> dice, YatzyCategory category) {
        ScoreCalculator scorer = ScorerFactory.getScorer(category);
        return scorer.calculateScore(dice);
    }
}
