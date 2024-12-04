package org.codingdojo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.codingdojo.yatzy3.Yatzy3;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class Yatzy3Test {
    

    static Stream<YatzyCalculator> yatzyProvider() {
        return Stream.of(new Yatzy3());
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void chance_scores_sum_of_all_dice(YatzyCalculator calculator) {
        assertEquals(15, calculator.score(List.of(2,3,4,5,1), YatzyCategory.CHANCE));
        assertEquals(16, calculator.score(List.of(3,3,4,5,1), YatzyCategory.CHANCE));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void yatzy_scores_50(YatzyCalculator yatzy2) {
        assertEquals(50, yatzy2.score(List.of(4,4,4,4,4), YatzyCategory.YATZY));
        assertEquals(50, yatzy2.score(List.of(6,6,6,6,6), YatzyCategory.YATZY));
        assertEquals(0, yatzy2.score(List.of(6,6,6,6,3), YatzyCategory.YATZY));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void test_1s(YatzyCalculator yatzy2) {
        assertEquals(1, yatzy2.score(List.of(1,2,3,4,5), YatzyCategory.ONES));
        assertEquals(2, yatzy2.score(List.of(1,2,1,4,5), YatzyCategory.ONES));
        assertEquals(0, yatzy2.score(List.of(6,2,2,4,5), YatzyCategory.ONES));
        assertEquals(4, yatzy2.score(List.of(1,2,1,1,1), YatzyCategory.ONES));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")

    public void twos(YatzyCalculator yatzy2) {
        assertEquals(4, yatzy2.score(List.of(1,2,3,2,6), YatzyCategory.TWOS));
        assertEquals(10, yatzy2.score(List.of(2,2,2,2,2), YatzyCategory.TWOS));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")

    public void threes(YatzyCalculator yatzy2) {
        assertEquals(6, yatzy2.score(List.of(1,2,3,2,3), YatzyCategory.THREES));
        assertEquals(12, yatzy2.score(List.of(2,3,3,3,3),YatzyCategory.THREES));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")

    public void fours(YatzyCalculator yatzy2)
    {
        assertEquals(12, yatzy2.score(List.of(4,4,4,5,5), YatzyCategory.FOURS));
        assertEquals(8, yatzy2.score(List.of(4,4,5,5,5), YatzyCategory.FOURS));
        assertEquals(4, yatzy2.score(List.of(4,5,5,5,5), YatzyCategory.FOURS));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void fives(YatzyCalculator yatzy2) {
        assertEquals(10, yatzy2.score(List.of(4,4,4,5,5), YatzyCategory.FIVES));
        assertEquals(15, yatzy2.score(List.of(4,4,5,5,5), YatzyCategory.FIVES));
        assertEquals(20, yatzy2.score(List.of(4,5,5,5,5), YatzyCategory.FIVES));
    }
    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void sixes(YatzyCalculator yatzy2) {
        assertEquals(0, yatzy2.score(List.of(4,4,4,5,5), YatzyCategory.SIXES));
        assertEquals(6, yatzy2.score(List.of(4,4,6,5,5), YatzyCategory.SIXES));
        assertEquals(18, yatzy2.score(List.of(6,5,6,6,5),YatzyCategory.SIXES));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
   public void pair(YatzyCalculator yatzy2) {
       assertEquals(6, yatzy2.score(List.of(3,4,3,5,6), YatzyCategory.PAIR));
       assertEquals(10, yatzy2.score(List.of(5,3,3,3,5),YatzyCategory.PAIR));
       assertEquals(12, yatzy2.score(List.of(5,3,6,6,5),YatzyCategory.PAIR));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void two_pair(YatzyCalculator yatzy2) {
        assertEquals(16, yatzy2.score(List.of(3,3,5,4,5), YatzyCategory.TWO_PAIRS));
        assertEquals(14, yatzy2.score(List.of(2,3,2,5,5), YatzyCategory.TWO_PAIRS));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void three_of_a_kind(YatzyCalculator yatzy2)
    {
        assertEquals(9, yatzy2.score(List.of(3,3,3,4,5), YatzyCategory.THREE_OF_A_KIND));
        assertEquals(15, yatzy2.score(List.of(5,3,5,4,5), YatzyCategory.THREE_OF_A_KIND));
        assertEquals(9, yatzy2.score(List.of(3,3,3,3,5), YatzyCategory.THREE_OF_A_KIND));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void four_of_a_knd(YatzyCalculator yatzy2) {
        assertEquals(12, yatzy2.score(List.of(3,3,3,3,5), YatzyCategory.FOUR_OF_A_KIND));
        assertEquals(20, yatzy2.score(List.of(5,5,5,4,5), YatzyCategory.FOUR_OF_A_KIND));
        assertEquals(12, yatzy2.score(List.of(3,3,3,3,3), YatzyCategory.FOUR_OF_A_KIND));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void smallStraight(YatzyCalculator yatzy2) {
        assertEquals(15, yatzy2.score(List.of(1,2,3,4,5),YatzyCategory.SMALL_STRAIGHT ));
        assertEquals(15, yatzy2.score(List.of(2,3,4,5,1),YatzyCategory.SMALL_STRAIGHT ));
        assertEquals(0, yatzy2.score(List.of(1,2,2,4,5), YatzyCategory.SMALL_STRAIGHT));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void largeStraight(YatzyCalculator yatzy2) {
        assertEquals(20, yatzy2.score(List.of(6,2,3,4,5), YatzyCategory.LARGE_STRAIGHT));
        assertEquals(20, yatzy2.score(List.of(2,3,4,5,6), YatzyCategory.LARGE_STRAIGHT));
        assertEquals(0, yatzy2.score(List.of(1,2,2,4,5), YatzyCategory.LARGE_STRAIGHT));
    }
    @ParameterizedTest
    @MethodSource("yatzyProvider")
    public void fullHouse(YatzyCalculator yatzy2) {
        assertEquals(18, yatzy2.score(List.of(6,2,2,2,6), YatzyCategory.FULL_HOUSE));
        assertEquals(0, yatzy2.score(List.of(2,3,4,5,6), YatzyCategory.FULL_HOUSE));
    }

}
