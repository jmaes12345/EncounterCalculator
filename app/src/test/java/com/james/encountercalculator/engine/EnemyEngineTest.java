package com.james.encountercalculator.engine;

import com.james.encountercalculator.model.Enemy;
import com.james.encountercalculator.model.EnemyParty;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnemyEngineTest {

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

    private static EnemyParty createParty(int partySize) {
        List<Enemy> partyList = new ArrayList<>();
        for (int i = 0; i < partySize; i++) {
            Enemy e = new Enemy();
            partyList.add(e);
        }
        return new EnemyParty(partyList);
    }

    @ParameterizedTest
    @MethodSource("enemyMultiplierScenarios")
    void calculateEnemyMultiplier(double expectedMultiplier, EnemyParty party) {
        assertEquals(expectedMultiplier, EnemyEngine.calculateEnemyMultiplier(party));
    }
}