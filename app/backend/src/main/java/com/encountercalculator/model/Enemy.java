package com.encountercalculator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Enemy {
	private int XP;
	private String name;
	private MonsterType monsterType;

	public Enemy(int XP) {
		this.XP = XP;
	}

	//JsonProperty tags required so constructor works and doesn't fail when called by Micronaut
	public Enemy(@JsonProperty("XP") int XP, @JsonProperty("name")String name, @JsonProperty("MonsterType")MonsterType monsterType) {
		this.XP = XP;
		this.name = name;
		this.monsterType = monsterType;
	}
}
