package com.axis.springbootdemo.entity;

import java.util.Objects;

public class Cricketer {
	private int cricketerId;
	private String name;
	private int runsScored;
	private int balls;
	private int fours;
	private int sxies;
	private double strikeRate;
	public Cricketer() {
	}
	public Cricketer(int cricketerId, String name, int runsScored, int balls, int fours, int sxies, double strikeRate) {
	
		this.cricketerId = cricketerId;
		this.name = name;
		this.runsScored = runsScored;
		this.balls = balls;
		this.fours = fours;
		this.sxies = sxies;
		this.strikeRate = strikeRate;
	}
	public int getCricketerId() {
		return cricketerId;
	}
	public void setCricketerId(int cricketerId) {
		this.cricketerId = cricketerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRunsScored() {
		return runsScored;
	}
	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}
	public int getBalls() {
		return balls;
	}
	public void setBalls(int balls) {
		this.balls = balls;
	}
	public int getFours() {
		return fours;
	}
	public void setFours(int fours) {
		this.fours = fours;
	}
	public int getSxies() {
		return sxies;
	}
	public void setSxies(int sxies) {
		this.sxies = sxies;
	}
	public double getStrikeRate() {
		return strikeRate;
	}
	public void setStrikeRate(double strikeRate) {
		this.strikeRate = strikeRate;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(cricketerId, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cricketer other = (Cricketer) obj;
		return cricketerId == other.cricketerId && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Cricketer [cricketerId=" + cricketerId + ", name=" + name + ", runsScored=" + runsScored + ", balls="
				+ balls + ", fours=" + fours + ", sxies=" + sxies + ", strikeRate=" + strikeRate + "]";
	}
	
	
	

}
