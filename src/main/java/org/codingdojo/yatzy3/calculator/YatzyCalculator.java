package org.codingdojo.yatzy3.calculator;


import org.codingdojo.yatzy3.categories.YatzyCategory;

import java.util.List;

public interface YatzyCalculator {
    int score(List<Integer> dice, YatzyCategory category);
}
