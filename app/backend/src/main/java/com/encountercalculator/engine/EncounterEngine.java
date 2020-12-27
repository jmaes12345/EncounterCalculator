package com.encountercalculator.engine;

import com.encountercalculator.model.Difficulty;

import java.util.Map;
import java.util.TreeMap;

public class EncounterEngine {

    public static Difficulty calculateEncounterThreshold(TreeMap<Difficulty, Integer> pcThresholds, int enemyXpTotal) {
        Difficulty overallDifficulty = Difficulty.TOO_EASY;

        for (Map.Entry<Difficulty, Integer> threshold : pcThresholds.entrySet()) {
            if (enemyXpTotal >= threshold.getValue()) {
                overallDifficulty = threshold.getKey();
            }
        }

        return overallDifficulty;
    }
}
