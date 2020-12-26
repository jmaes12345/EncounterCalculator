package com.encountercalculator.model;

public class Enemy {
    private int XP;
    private String name;
    private MonsterType monsterType;

	public Enemy(int XP) {
		this.XP = XP;
	}

	public int getXP() {
		return XP;
	}

	public void setXP(int XP) {
		this.XP = XP;
	}
}
