package com.encountercalculator.controller;

import com.encountercalculator.engine.EncounterEngine;
import com.encountercalculator.model.Difficulty;
import com.encountercalculator.model.EnemyParty;
import com.encountercalculator.model.PCParty;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;

import java.util.Map;

import static com.encountercalculator.engine.PCThresholdEngine.calculatePCThresholds;

@Controller("/encounter")
public class EncounterController {

    ObjectMapper mapper = JsonFactory.create();

    @Post("/difficulty")
    public static String getEncounterDifficulty(@Body String input)
    {
//        Map<Difficulty, Integer> pcThresholds = readPcThresholds(input);
//        EnemyParty enemyParty = readEnemyParty(input);
//        Difficulty result = EncounterEngine.getEncounterDifficulty(pcThresholds, enemyParty);
//        return result.toString();
        return "hello";
    }

    @Post("/pc-thresholds")
    public Map<Difficulty, Integer> generatePCThresholds(@Body String input) {
        PCParty pcParty = readPcParty(input);
        return calculatePCThresholds(pcParty);
    }

//    private Map<Difficulty, Integer> readPcThresholds(String input)
//    {
//
//}
//
//    private EnemyParty readEnemyParty(String input)
//    {
//
//    }

    private PCParty readPcParty(String input)
    {
        return new PCParty(mapper.parser().parseIntArray(input));
    }
}
