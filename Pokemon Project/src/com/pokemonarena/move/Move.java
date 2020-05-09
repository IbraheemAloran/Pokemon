package com.pokemonarena.move;

import com.pokemonarena.Global;
import com.pokemonarena.Pokemon;

import java.util.*;

public class Move implements Global {
	private String name;
	private int pp;
	private int type;
	private int power;
	private Effect effect;
	private int acc;
	private int cat;

	public Move(String data){
	//example: fire punch,15,8,75,100,7,10 21
			 //name,powerpoints,power,accuracy,category,effect
			 //first number in effect is percentage the effect will happen, second is the effect number
		String[] info = data.split(",");
		name = info[0];
		pp = Integer.parseInt(info[1]);
		type = Integer.parseInt(info[2]);
		power = Integer.parseInt(info[3]);
		acc = Integer.parseInt(info[4]);
		cat = Integer.parseInt(info[5]);
		if(info.length == 7){ //if a effect is in the string
			effect = new Effect(info[6]);
		}
	}

	public boolean useMove(Pokemon attacking, Pokemon defending){
		if (hit()){
			if(cat!=8){
				double STAB = 1;
				if (type == attacking.getType()) STAB = 1.5;
				int damage = calculateDamage((int) STAB, attacking, defending);
				defending.changeHP(damage * -1);
			}
			return true;	
		}
		return false;
	}

	private int calculateDamage(int STAB, Pokemon attacking, Pokemon defending){
		int damage = ((2 * attacking.getLevel()) / 5) + 2;
		damage *= power;
		if (cat == 6){
			damage *= (attacking.getStats(ATTACK) / defending.getStats(DEFENSE));
		}
		else if (cat == 7){
			damage *= (attacking.getStats(SATTACK) / defending.getStats(SDEFENSE));
		}
		damage /= 50;
		damage += 2;
		damage *= STAB;
		//int multiplier = typeChart[type - 9].get(defending.getType());
		int multiplier = 1; //placeholder until typechart bug is fixed
		damage *= multiplier;
		return damage;
		
	}
	private boolean hit(){
		Random rand = new Random();
		int choice = rand.nextInt(100);
		return choice <= acc;
	}

	public String getName(){
		return name;
	}
}
