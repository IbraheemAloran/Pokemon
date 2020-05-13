package com.pokemonarena.move;

import java.util.*;

public class Effect
{
	private int prob;
	private int fx;

	public Effect(){}

	public Effect(String data){
		String[] info = data.split(" ");
		//info[0] = prob;
		//info[1] = fx;
		prob = Integer.parseInt(info[0]);
		fx = Integer.parseInt(info[1]);
	}

	public boolean hit()
	{
		Random rand = new Random();
		int choice = rand.nextInt(100);
		if (choice <= prob) return true;
		return false; 
	}

	public int getProb() {
		return prob;
	}

	public void setProb(int prob) {
		this.prob = prob;
	}

	public int getFx() {
		return fx;
	}

	public void setFx(int fx) {
		this.fx = fx;
	}

	@Override
	public String toString() {
		if(fx==0){
			return "";
		}
		else{
			return "Effect{" +
					"prob=" + prob +
					", fx=" + fx +
					'}';
		}
	}
}