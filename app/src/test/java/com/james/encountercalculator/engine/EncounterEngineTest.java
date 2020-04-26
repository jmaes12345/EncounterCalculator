package com.james.encountercalculator.engine;

import com.james.encountercalculator.model.Difficulty;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static com.james.encountercalculator.engine.EncounterEngine.calculateEncounterThreshold;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EncounterEngineTest {

    @ParameterizedTest
    @MethodSource("encounterThresholdScenarios")
    void testCalculateEncounterThreshold(Difficulty expectedDifficulty, Map<Difficulty, Integer> pcThresholds, int enemyXPTotal) {
        assertEquals(expectedDifficulty, calculateEncounterThreshold(pcThresholds, enemyXPTotal));
    }

    // TODO add scenarios
    private static Stream<Arguments> encounterThresholdScenarios() {
        return Stream.of(
                Arguments.of(Difficulty.TOO_EASY, null, 0)
        );
    }
}
