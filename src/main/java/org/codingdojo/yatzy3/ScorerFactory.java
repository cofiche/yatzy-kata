package org.codingdojo.yatzy3;

import org.codingdojo.YatzyCategory;

import java.util.HashMap;
import java.util.Map;

import static org.codingdojo.YatzyCategory.*;


public class ScorerFactory {
    private static final Map<YatzyCategory, ScoreCalculator> scorers = new HashMap<>();

    static {
        scorers.put(CHANCE, new ChanceScorer());
        scorers.put(YATZY, new YatzyPointsScorer());
        scorers.put(ONES, new NumberScorer(1));
        scorers.put(TWOS, new NumberScorer(2));
        scorers.put(THREES, new NumberScorer(3));
        scorers.put(FOURS, new NumberScorer(4));
        scorers.put(FIVES, new NumberScorer(5));
        scorers.put(SIXES, new NumberScorer(6));
        scorers.put(PAIR, new RepeatedCountScorer(2));
        scorers.put(THREE_OF_A_KIND, new RepeatedCountScorer(3));
        scorers.put(FOUR_OF_A_KIND, new RepeatedCountScorer(4));
        scorers.put(SMALL_STRAIGHT, new StraightScorer(1));
        scorers.put(LARGE_STRAIGHT, new StraightScorer(6));
        scorers.put(TWO_PAIRS, new TwoPairsScorer());
        scorers.put(FULL_HOUSE, new FullHouseScorer());
    }

    public static ScoreCalculator getScorer(YatzyCategory category) {
        ScoreCalculator scorer = scorers.get(category);
        return scorer;
    }
}

