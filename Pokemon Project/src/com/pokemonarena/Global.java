package com.pokemonarena;

import java.util.HashMap;
import java.util.HashMap.*;

public interface Global
{
	int HP = 0;
	int ATTACK = 1;
	int DEFENSE = 2;
	int SATTACK = 3;
	int SDEFENSE = 4;
	int SPEED = 5;
	int SPECIAL = 7;
	int PHYSICAL = 6;
	int STATUS = 8;

//TYPES
	int FIRE = 9;
	int WATER = 10;
	int ELECTRIC = 11;
	int GRASS = 12;
	int NORMAL = 13;
	int DARK = 14;
	int PSYCHIC = 15;
	int GHOST = 16;

//STATUS EFFECT
	int BURN = 30;
	int SLEEP = 31;
	int PARALYSIS = 32;
	int TOXIC = 33;
	int FREEZE = 34;
	int FLINCH = 35;
	int CONFUSION = 36;
	int NONE = 37;

//PLAYERS
	int P1 = 38;
	int P2 = 39;

//EEFECTIVENESS
	/*HashMap[] typeChart = new HashMap[8];
	c = new HashMap<Integer,Integer>();
	typeChart[0] = new HashMap<Integer,Integer>();
	typeChart[1] = new HashMap<Integer,Integer>();
	typeChart[2] = new HashMap<Integer,Integer>();
	typeChart[3] = new HashMap<Integer,Integer>();
	typeChart[4] = new HashMap<Integer,Integer>();
	typeChart[5] = new HashMap<Integer,Integer>();
	typeChart[6] = new HashMap<Integer,Integer>();
	typeChart[7] = new HashMap<Integer,Integer>();
	
	
//0 RERESENTS FIRE
	typeChart[0].put(FIRE, 0.5); 
	typeChart[0].put(WATER, 0.5); 
	typeChart[0].put(ELECTRIC, 1);
	typeChart[0].put(GRASS, 2);	
	typeChart[0].put(NORMAL, 1);
	typeChart[0].put(DARK, 1);
	typeChart[0].put(PSYCHIC, 1);
	typeChart[0].put(GHOST, 1);
	
//1 REPRESENTS ELECTRIC
	typeChart[1].put(ELECTRIC, 0.5);
	typeChart[1].put(FIRE, 1); 
	typeChart[1].put(WATER, 2);
	typeChart[1].put(GRASS, 0.5);	
	typeChart[1].put(NORMAL, 1);
	typeChart[1].put(DARK, 1);
	typeChart[1].put(PSYCHIC, 1);
	typeChart[1].put(GHOST, 1);
	
//WATER
	typeChart[2].put(WATER, 0.5);
	typeChart[2].put(FIRE, 2);
	typeChart[2].put(ELECTRIC, 1);	
	typeChart[2].put(GRASS, 0.5);	
	typeChart[2].put(NORMAL, 1);
	typeChart[2].put(DARK, 1);
	typeChart[2].put(PSYCHIC, 1);
	typeChart[2].put(GHOST, 1);
	
//GRASS
	typeChart[3].put(GRASS, 0.5);
	typeChart[3].put(FIRE, 0.5);
	typeChart[3].put(ELECTRIC, 1);	
	typeChart[3].put(WATER, 2);	
	typeChart[3].put(NORMAL, 1);
	typeChart[3].put(DARK, 1);
	typeChart[3].put(PSYCHIC, 1);
	typeChart[3].put(GHOST, 1);

//NORMAL
	typeChart[4].put(NORMAL, 1);
	typeChart[4].put(FIRE, 1);
	typeChart[4].put(ELECTRIC, 1);	
	typeChart[4].put(GRASS, 1);	
	typeChart[4].put(WATER, 1);
	typeChart[4].put(DARK, 1);
	typeChart[4].put(PSYCHIC, 1);
	typeChart[4].put(GHOST, 0);
	
	typeChart[5].put(DARK, 0.5);//DARK
	typeChart[5].put(FIRE, 1);
	typeChart[5].put(ELECTRIC, 1);	
	typeChart[5].put(GRASS, 1);	
	typeChart[5].put(WATER, 1);
	typeChart[5].put(NORMAL, 1);
	typeChart[5].put(PSYCHIC, 2);
	typeChart[5].put(GHOST, 2);
	
	typeChart[6].put(PSYCHIC, 0.5);//PSYCHIC
	typeChart[6].put(FIRE, 1);
	typeChart[6].put(ELECTRIC, 1);	
	typeChart[6].put(GRASS, 1);	
	typeChart[6].put(WATER, 1);
	typeChart[6].put(NORMAL, 1);
	typeChart[6].put(DARK, 0);
	typeChart[6].put(GHOST, 1);

	typeChart[7].put(GHOST, 2);//GHOST
	typeChart[7].put(FIRE, 1);
	typeChart[7].put(ELECTRIC, 1);	
	typeChart[7].put(GRASS, 1);	
	typeChart[7].put(WATER, 1);
	typeChart[7].put(NORMAL, 0);
	typeChart[7].put(PSYCHIC, 2);
	typeChart[7].put(DARK, 0.5);*/
}
