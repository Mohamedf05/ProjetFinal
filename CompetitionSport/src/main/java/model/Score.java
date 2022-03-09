package model;

import java.util.List;

import javax.persistence.Entity;
public class Score {
	private int score;
	private List<Athlete> athletes;
	
	public Score() {}
	
	public Score(int score, List<Athlete> athletes) {
		this.score = score;
		this.athletes = athletes;
	}

	public int getScore() {
		return score;
	}

	public List<Athlete> getAthletes() {
		return athletes;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setAthletes(List<Athlete> athletes) {
		this.athletes = athletes;
	}

	@Override
	public String toString() {
		return "Score [score=" + score + ", athletes=" + athletes + "]";
	}
	
	

}
