package com.encountercalculator.model;

import java.util.ArrayList;
import java.util.List;

public class EnemyParty {
    private List<Enemy> enemyList = new ArrayList<>();

    public EnemyParty(List<Enemy> enemies) {
        enemies.forEach(this::addEnemy);
    }

    public List<Enemy> getEnemyList() {
        return enemyList;
    }

    public void setEnemyList(List<Enemy> enemyList) {
        this.enemyList = enemyList;
    }

    public boolean addEnemy(Enemy enemy) {
        return enemyList.add(enemy);
    }

}
