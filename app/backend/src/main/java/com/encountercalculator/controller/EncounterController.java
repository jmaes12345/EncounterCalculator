package com.encountercalculator.controller;

import com.encountercalculator.engine.EnemyEngine;
import com.encountercalculator.model.Difficulty;
import com.encountercalculator.model.Enemy;
import com.encountercalculator.model.EnemyParty;
import com.encountercalculator.model.PCParty;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;
import java.util.Map;

import static com.encountercalculator.engine.PCThresholdEngine.calculatePCThresholds;

/**
 * Encounter Controller
 */
@Controller("/encounter")
public class EncounterController {

//    /**
//     * Test endpoint
//     * @return "hello"
//     */
//    @Get(uri = "/hello")
//    public String hello() {
//        return "hello";
//    }

	/**
	 * Endpoint to calculate the thresholds for the party provided
	 *
	 * @param pcLevels PC party, one item for each member of the party represented by their level
	 * @return Map of PC thresholds for the provided party
	 */
	@Post("/pc-thresholds")
	@ApiResponse(
			content = @Content(
					examples = @ExampleObject("{\n" +
							"  \"TOO_EASY\": 0,\n" +
							"  \"EASY\": 275,\n" +
							"  \"MEDIUM\": 550,\n" +
							"  \"HARD\": 825,\n" +
							"  \"DEADLY\": 1200,\n" +
							"  \"IMPOSSIBLE\": 2400\n" +
							"}")))
	@ApiResponse(responseCode = "500", description = "Internal Server Error")
	public Map<Difficulty, Integer> generatePCThresholds(@Body List<Integer> pcLevels) {
		PCParty pcParty = new PCParty(pcLevels);
		return calculatePCThresholds(pcParty);
	}

	/**
	 * Endpoint to calculate the enemy party total XP
	 *
	 * @param enemyPartyInput The enemy party
	 * @return
	 */
	@Post("/enemy-xp")
	@ApiResponse(responseCode = "500", description = "Internal Server Error")
	public int calculateEnemyXPTotal(@Body List<Enemy> enemyPartyInput) {
		EnemyParty enemyparty = new EnemyParty(enemyPartyInput);
		return EnemyEngine.calculateEnemyXPTotal(enemyparty);
	}
}
