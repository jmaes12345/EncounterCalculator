package com.encountercalculator.engine;

import com.encountercalculator.model.Enemy;
import com.encountercalculator.model.EnemyParty;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnemyEngineTest {

    @ParameterizedTest
    @MethodSource("enemyMultiplierScenarios")
    void testCalculateEnemyMultiplier(double expectedMultiplier, EnemyParty party) {
        assertEquals(expectedMultiplier, EnemyEngine.calculateEnemyMultiplier(party));
    }

    @ParameterizedTest
    @MethodSource("enemyCalculatorScenarios")
    void testCalculateEnemyXPTotal(int expectedXP, List<Enemy> partyList) {
        assertEquals(expectedXP, EnemyEngine.calculateEnemyXPTotal(new EnemyParty(partyList)));
    }

	static Stream<Arguments> enemyCalculatorScenarios() {
        return Stream.of(
		        // Multiplier is applied
		        Arguments.of(1, Arrays.asList(new Enemy(1))),
		        Arguments.of(3, Arrays.asList(new Enemy(1), new Enemy(1))),
		        Arguments.of(6, Arrays.asList(new Enemy(1), new Enemy(1), new Enemy(1))),
		        // values are added together
		        Arguments.of(150, Arrays.asList(new Enemy(50), new Enemy(50)))
        );
    }

    private static EnemyParty createParty(int partySize) {
        List<Enemy> partyList = new ArrayList<>();
        for (int i = 0; i < partySize; i++) {
	        Enemy e = new Enemy(0);
            partyList.add(e);
        }
        return new EnemyParty(partyList);
    }

	private static Stream<Arguments> enemyMultiplierScenarios() {
		return Stream.of(
				Arguments.of(1, createParty(1)),
				Arguments.of(1.5, createParty(2)),
				Arguments.of(2, createParty(3)),
				Arguments.of(2, createParty(6)),
				Arguments.of(2.5, createParty(7)),
				Arguments.of(2.5, createParty(10)),
				Arguments.of(3, createParty(11)),
				Arguments.of(3, createParty(14)),
				Arguments.of(4, createParty(15)),
				Arguments.of(4, createParty(20))
		);
	}
}