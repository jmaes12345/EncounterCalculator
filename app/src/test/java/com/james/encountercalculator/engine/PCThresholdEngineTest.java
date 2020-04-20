package com.james.encountercalculator.engine;

import com.james.encountercalculator.model.Difficulty;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.james.encountercalculator.engine.PCThresholdEngine.generateThresholdMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

class PCThresholdEngineTest {

    @Test
    void testCalculatePCThresholds() {
        fail();
    }

    @Test
    void testGetThresholdValueForLevel_level1() {
        Map<Difficulty, Integer> level1Map = PCThresholdEngine.getThresholdValueForLevel(1);
        assertEquals(25, level1Map.get(Difficulty.EASY));
        assertEquals(50, level1Map.get(Difficulty.MEDIUM));
        assertEquals(75, level1Map.get(Difficulty.HARD));
        assertEquals(100, level1Map.get(Difficulty.DEADLY));
    }

    @Test
    void testGetThresholdValueForLevel_level20() {
        Map<Difficulty, Integer> level1Map = PCThresholdEngine.getThresholdValueForLevel(20);
        assertEquals(2800, level1Map.get(Difficulty.EASY));
        assertEquals(5700, level1Map.get(Difficulty.MEDIUM));
        assertEquals(8500, level1Map.get(Difficulty.HARD));
        assertEquals(12700, level1Map.get(Difficulty.DEADLY));
    }

    @Test
    void testGenerateThresholdMap() {
        Map<Difficulty, Integer> thresholdMap = generateThresholdMap();
        for (Difficulty diff : Difficulty.values()) {
            assertNotNull(thresholdMap.get(diff));
        }
    }
}