package com.canefaitrien.gitpong;

public class Player {
	private Paddle paddle;
	private Skill[] skills;
	private double health, healthMax;
	
	public Player(){
		
	}
	/**
	 * getter setter
	 */
	public Skill[] getSkills(){
		return skills;
	}
	public double getHealth(){
		return health;
	}
}
