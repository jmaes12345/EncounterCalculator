package com.encountercalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class EnemyParty {
    private List<Enemy> enemyList;

    public boolean addEnemy(Enemy enemy) {
        return enemyList.add(enemy);
    }
}
