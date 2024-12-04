package org.codingdojo.yatzy3;

import static org.codingdojo.YatzyCategory.*;

import java.util.List;
import org.codingdojo.YatzyCalculator;
import org.codingdojo.YatzyCategory;

public class Yatzy3 implements YatzyCalculator {

    @Override
    public int score(List<Integer> dice, YatzyCategory category) {
        ScoreCalculator scorer = ScorerFactory.getScorer(category);
        return scorer.calculateScore(dice);
    }
}
