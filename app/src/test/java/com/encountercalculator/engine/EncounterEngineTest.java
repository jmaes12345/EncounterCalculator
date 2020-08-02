package com.encountercalculator.engine;

import com.encountercalculator.model.Difficulty;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

import static com.encountercalculator.engine.EncounterEngine.calculateEncounterThreshold;
import static com.encountercalculator.engine.PCThresholdEngine.generateThresholdMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EncounterEngineTest {

    @ParameterizedTest
    @MethodSource("encounterThresholdScenarios")
    void testCalculateEncounterThreshold(Difficulty expectedDifficulty, Map<Difficulty, Integer> pcThresholds, int enemyXPTotal) {
        assertEquals(expectedDifficulty, calculateEncounterThreshold((TreeMap<Difficulty, Integer>) pcThresholds, enemyXPTotal));
    }

    private static Stream<Arguments> encounterThresholdScenarios() {
        return Stream.of(
                // 4 PCs at Level 3
                Arguments.of(Difficulty.TOO_EASY, generateThresholdMap(0, 300, 600, 900, 1600, 3200), 1),
                Arguments.of(Difficulty.TOO_EASY, generateThresholdMap(0, 300, 600, 900, 1600, 3200), 299),
                Arguments.of(Difficulty.EASY, generateThresholdMap(0, 300, 600, 900, 1600, 3200), 300),
                Arguments.of(Difficulty.EASY, generateThresholdMap(0, 300, 600, 900, 1600, 3200), 599),
                Arguments.of(Difficulty.MEDIUM, generateThresholdMap(0, 300, 600, 900, 1600, 3200), 600),
                Arguments.of(Difficulty.MEDIUM, generateThresholdMap(0, 300, 600, 900, 1600, 3200), 899),
                Arguments.of(Difficulty.HARD, generateThresholdMap(0, 300, 600, 900, 1600, 3200), 900),
                Arguments.of(Difficulty.HARD, generateThresholdMap(0, 300, 600, 900, 1600, 3200), 1599),
                Arguments.of(Difficulty.DEADLY, generateThresholdMap(0, 300, 600, 900, 1600, 3200), 1600),
                Arguments.of(Difficulty.DEADLY, generateThresholdMap(0, 300, 600, 900, 1600, 3200), 3199),
                Arguments.of(Difficulty.IMPOSSIBLE, generateThresholdMap(0, 300, 600, 900, 1600, 3200), 3200),
                Arguments.of(Difficulty.IMPOSSIBLE, generateThresholdMap(0, 300, 600, 900, 1600, 3200), 4800)
        );
    }
}
