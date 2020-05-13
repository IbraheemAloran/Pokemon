package com.pokemonarena.move;

import java.util.*;

public class Effect
{
	private int prob;
	private int fx;

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
}