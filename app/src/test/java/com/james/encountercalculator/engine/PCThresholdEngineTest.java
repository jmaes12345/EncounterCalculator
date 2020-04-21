package com.james.encountercalculator.engine;

import com.james.encountercalculator.model.Difficulty;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static com.james.encountercalculator.engine.PCThresholdEngine.generateThresholdMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PCThresholdEngineTest {

    @Test
    void testCalculatePCThresholds() {
        //TODO
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
        for (Difficulty diff : Difficulty.values()) {
            assertNotNull(thresholdMap.get(diff));
        }
    }
}