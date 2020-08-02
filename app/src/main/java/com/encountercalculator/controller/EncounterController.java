package com.encountercalculator.controller;

import com.encountercalculator.engine.EncounterEngine;
import com.encountercalculator.model.Difficulty;
import com.encountercalculator.model.EnemyParty;
import com.encountercalculator.model.PCParty;

import java.util.Map;
import java.util.TreeMap;

import static com.encountercalculator.engine.EnemyEngine.calculateEnemyXPTotal;
import static com.encountercalculator.engine.PCThresholdEngine.calculatePCThresholds;

public class EncounterController {

    public static Difficulty getEncounterDifficulty(Map<Difficulty, Integer> pcThresholds, EnemyParty enemyParty) {
        int enemyXPTotal = calculateEnemyXPTotal(enemyParty);
        return EncounterEngine.calculateEncounterThreshold((TreeMap<Difficulty, Integer>) pcThresholds, enemyXPTotal);
    }

    public static Map<Difficulty, Integer> generatePCThresholds(PCParty pcParty) {
        return calculatePCThresholds(pcParty);
    }
}
