package org.codingdojo.yatzy3.scoring;

import org.codingdojo.yatzy3.calculator.ScoreCalculator;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.codingdojo.yatzy3.utils.DiceUtils.*;

public class TwoPairsScorer implements ScoreCalculator {
    @Override
    public int calculateScore(List<Integer> dice) {
        Map<Integer, Integer> frequencies = calculateFrequencies(dice);
        int score = 0;
        if (calculateFrequencies(dice).values().stream().filter(f -> f >= 2).toList().size() == 2) {
            score = Stream.of(6, 5, 4, 3, 2, 1)
                .mapToInt(i -> i)
                .filter(i -> frequencies.get(i) == 2)
                .map(i -> i * 2)
                .sum();
        }
        return score;
    }
}
