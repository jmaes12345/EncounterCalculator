package com.james.encountercalculator.engine;

import com.james.encountercalculator.model.Difficulty;
import com.james.encountercalculator.model.PCParty;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static com.james.encountercalculator.engine.PCThresholdEngine.generateThresholdMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PCThresholdEngineTest {

    @ParameterizedTest
    @MethodSource("testCalculatePCThresholdsParams")
    void testCalculatePCThresholds(int tooEasy, int easy, int medium, int hard, int deadly, int impossible, PCParty PCParty) {
        Map<Difficulty, Integer> expectedThresholds = generateThresholdMap(tooEasy, easy, medium, hard, deadly, impossible);
        Map<Difficulty, Integer> partyMap = PCThresholdEngine.calculatePCThresholds(PCParty);

        for (Difficulty diff : Difficulty.values()) {
            assertEquals(partyMap.get(diff), expectedThresholds.get(diff), "Difficulty for " + diff + " did not match");
        }
    }

    @ParameterizedTest(name = "level={0}, easy={1}, medium={2}, hard={3}, deadly={4}")
    @CsvSource({
            "1, 25, 50, 75, 100",
            "20, 2800, 5700, 8500, 12700"
    })
    void testGetThresholdValueForLevel_validValues(int level, int easy, int medium, int hard, int deadly) {
        Map<Difficulty, Integer> level1Map = PCThresholdEngine.getThresholdValueForLevel(level);
        assertEquals(easy, level1Map.get(Difficulty.EASY));
        assertEquals(medium, level1Map.get(Difficulty.MEDIUM));
        assertEquals(hard, level1Map.get(Difficulty.HARD));
        assertEquals(deadly, level1Map.get(Difficulty.DEADLY));
    }

    @Test
    void testGenerateThresholdMap() {
        Map<Difficulty, Integer> thresholdMap = generateThresholdMap();

        assertEquals(6, thresholdMap.size());

        for (Difficulty diff : Difficulty.values()) {
            assertNotNull(thresholdMap.get(diff));
            assertEquals(0, thresholdMap.get(diff));
        }
    }

    static Stream<Arguments> testCalculatePCThresholdsParams() {
        return Stream.of(
                Arguments.of(0, 25, 50, 75, 100, 200, new PCParty(new int[]{1})),
                Arguments.of(0, 100, 200, 300, 400, 800, new PCParty(new int[]{2, 2})),
                Arguments.of(0, 225, 450, 675, 1200, 2400, new PCParty(new int[]{3, 3, 3})),
                Arguments.of(0, 500, 1000, 1500, 2000, 4000, new PCParty(new int[]{4, 4, 4, 4})),
                Arguments.of(0, 1250, 2500, 3750, 5500, 11000, new PCParty(new int[]{5, 5, 5, 5, 5})),
                Arguments.of(0, 11200, 22800, 34000, 50800, 101600, new PCParty(new int[]{20, 20, 20, 20})),
                Arguments.of(0, 450, 900, 1350, 2000, 4000, new PCParty(new int[]{3, 4, 5}))
        );
    }
}