package com.james.encountercalculator.engine;

import com.james.encountercalculator.model.EnemyParty;

public class EnemyEngine {
    public static double calculateEnemyMultiplier(EnemyParty enemyParty) {
        int enemyCount = enemyParty.getEnemyList().size();

        if (enemyCount <= 1) {
            return 1;
        } else if (enemyCount == 2) {
            return 1.5;
        } else if (enemyCount <= 6) {
            return 2;
        } else if (enemyCount <= 10) {
            return 2.5;
        } else if (enemyCount <= 14) {
            return 3;
        } else {
            return 4;
        }
    }


}
