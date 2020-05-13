package com.pokemonarena.player;

import com.pokemonarena.Global;
import com.pokemonarena.Pokemon;

import java.util.*;

public abstract class Player implements Global
{
	protected String name;
	protected Pokemon[] party;
	private boolean whiteout;
	protected Pokemon activePok;
	protected Scanner sc;

	public Player(String name)
	{
		this.name = name;
		party = new Pokemon[6];
		for (int i = 0; i < 6; i++)
		{
			party[i] = new Pokemon();
		}
		whiteout = false;
		sc = new Scanner(System.in);
	}

	public void setRandomParty(ArrayList<Pokemon> pokedex)
	{
		Random rand = new Random();
		for (int i = 0; i < 6; i++)
		{
			int num = rand.nextInt(pokedex.size());
			party[i] = pokedex.get(num);
			//pokemon[i].setStats(poks.get(num));
			//pokedex.remove(num); //Don't remove it; need to implement this
		}
		activePok = party[0];
	}

	public void displayPokemon()
	{
		for (int i = 0; i < 6; i++)
		{
			if (!party[i].isFainted()) System.out.println((i + 1) + ". " + party[i]);
		}
	}

	public Pokemon getActivePok()
	{
		return activePok;
	}

	public Pokemon[] getParty(){
		return party;
	}

	public void setActivePok(Pokemon newActive){
		activePok = newActive;
	}

	public void setWhiteOut()
	{
		int count = 0;
		for (int i = 0; i < 6; i++)
		{
			if (!party[i].isFainted()) count++;
		}

		if (count == 6) whiteout = true;
	}

	public boolean isOut()
	{
		return whiteout;
	}

	//public abstract void play();
	//public abstract void attack();
	public abstract void switchPokemon();
}
