package com.canefaitrien.gitpong;

import java.util.Random;

public class Skill {
	private String slot; //offense, defense, utility, passive
	private String name;
	private int cooldownMax,cooldown;
	// constructor
	public Skill(){
		slot = "offense";
		name = "Pound";
		cooldownMax = 50;
		cooldown = cooldownMax;
	}
	//getters setters
	public int getCooldownMax(){
		return cooldownMax;
	}
	public int getCooldown(){
		return cooldown;
	}
	public String getName(){
		return name;
	}
}
