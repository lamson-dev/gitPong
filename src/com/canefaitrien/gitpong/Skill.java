package com.canefaitrien.gitpong;

public class Skill {
	private String type; //offense, defense, utility, passive
	private String name;
	private int cooldownMax,cooldown;
	// constructor
	public Skill(){
		
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
