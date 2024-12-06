package org.codingdojo.yatzy3.factories;

import org.codingdojo.yatzy3.categories.YatzyCategory;
import org.codingdojo.yatzy3.calculator.ScoreCalculator;
import org.codingdojo.yatzy3.scoring.*;

import java.util.HashMap;
import java.util.Map;

import static org.codingdojo.yatzy3.categories.YatzyCategory.*;


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
        return scorers.get(category);
    }

    public static void registerScorer(YatzyCategory category, ScoreCalculator scorer) {
        if (scorers.containsKey(category)) {
            throw new IllegalArgumentException("Scorer for category " + category + " is already registered.");
        }
        scorers.put(category, scorer);
    }
}

