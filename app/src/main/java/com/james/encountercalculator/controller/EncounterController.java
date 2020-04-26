package com.james.encountercalculator.controller;

import com.james.encountercalculator.engine.EncounterEngine;
import com.james.encountercalculator.model.Difficulty;
import com.james.encountercalculator.model.EnemyParty;
import com.james.encountercalculator.model.PCParty;

import java.util.Map;

import static com.james.encountercalculator.engine.EnemyEngine.calculateEnemyXPTotal;
import static com.james.encountercalculator.engine.PCThresholdEngine.calculatePCThresholds;

public class EncounterController {

    PCParty pcParty;
    EnemyParty enemyParty;

    public Difficulty getEncounterDifficulty() {
        Map<Difficulty, Integer> pcThresholds = calculatePCThresholds(pcParty);
        int enemyXPTotal = calculateEnemyXPTotal(enemyParty);
        return EncounterEngine.calculateEncounterThreshold(pcThresholds, enemyXPTotal);
    }
}
