package com.encountercalculator.engine;

import com.encountercalculator.model.Difficulty;
import com.encountercalculator.model.EnemyParty;

import java.util.Map;
import java.util.TreeMap;

import static com.encountercalculator.engine.EnemyEngine.calculateEnemyXPTotal;

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

    public static Difficulty getEncounterDifficulty(Map<Difficulty, Integer> pcThresholds, EnemyParty enemyParty) {
        int enemyXPTotal = calculateEnemyXPTotal(enemyParty);
        return calculateEncounterThreshold((TreeMap<Difficulty, Integer>) pcThresholds, enemyXPTotal);
    }
}
