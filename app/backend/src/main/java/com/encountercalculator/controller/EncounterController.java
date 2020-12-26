package com.encountercalculator.controller;

import com.encountercalculator.engine.EncounterEngine;
import com.encountercalculator.model.Difficulty;
import com.encountercalculator.model.EnemyParty;
import com.encountercalculator.model.PCParty;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.Map;
import java.util.TreeMap;

import static com.encountercalculator.engine.EnemyEngine.calculateEnemyXPTotal;
import static com.encountercalculator.engine.PCThresholdEngine.calculatePCThresholds;

@Controller("/encounter")
public class EncounterController {

    @Get("/difficulty")
    public static Difficulty getEncounterDifficulty(Map<Difficulty, Integer> pcThresholds, EnemyParty enemyParty) {
        int enemyXPTotal = calculateEnemyXPTotal(enemyParty);
        return EncounterEngine.calculateEncounterThreshold((TreeMap<Difficulty, Integer>) pcThresholds, enemyXPTotal);
    }

    @Get("/pc-thresholds")
    public static Map<Difficulty, Integer> generatePCThresholds(PCParty pcParty) {
        return calculatePCThresholds(pcParty);
    }
}
