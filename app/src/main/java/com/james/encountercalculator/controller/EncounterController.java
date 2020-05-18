package com.james.encountercalculator.controller;

import com.james.encountercalculator.engine.EncounterEngine;
import com.james.encountercalculator.model.Difficulty;
import com.james.encountercalculator.model.EnemyParty;
import com.james.encountercalculator.model.PCParty;

import java.util.Map;
import java.util.TreeMap;

import static com.james.encountercalculator.engine.EnemyEngine.calculateEnemyXPTotal;
import static com.james.encountercalculator.engine.PCThresholdEngine.calculatePCThresholds;

public class EncounterController {

    private PCParty pcParty;
    private EnemyParty enemyParty;

    public Difficulty getEncounterDifficulty() {
        Map<Difficulty, Integer> pcThresholds = calculatePCThresholds(pcParty);
        int enemyXPTotal = calculateEnemyXPTotal(enemyParty);
        return EncounterEngine.calculateEncounterThreshold((TreeMap<Difficulty, Integer>) pcThresholds, enemyXPTotal);
    }
}
