package com.pokemonarena.player;

import java.util.*;

public class HumanPlayer extends Player
{
	public HumanPlayer(String name)
	{
		super(name);
	}

	/*public void play(com.pokemonarena.player.Player otherPlayer)
	{
		System.out.print("Would you like to:\n1. Attack\n2. Switch");
		int choice = sc.nextInt();
		sc.nextLine();
		while (choice != 1 || choice != 2)
		{
			System.out.println("Incorrect choice!");
			System.out.print("Would you like to:\n1. Attack\n2. Switch");
			choice = sc.nextInt();
			sc.nextLine();
		}
		if (choice == 1) attack(otherPkayer);
		if (choice == 2) switchPokemon();
	}*/

	private void attack(Player otherPlayer)
	{
		System.out.println("Here are your available moves: ");
		//activePok.displayMoves();
		System.out.print("Which move would you like to make: ");
		int choice = sc.nextInt();
		sc.nextLine();
		while (choice < 1 || choice > 4)
		{
			System.out.println("Invalid choice!");
			System.out.print("Which move would you like to make: ");
			choice = sc.nextInt();
			sc.nextLine();
		}

		//activePok.attack(otherPlayer.getActivePok(), activePok.getMove(choice - 1));
	}

	public void switchPokemon()
	{
		System.out.println("Here are the Pokemon that you can choose from: ");
		super.displayPokemon();
		System.out.print("Type in the number beside the Pokemon that you'd like to choose: ");
		int choice = sc.nextInt();
		sc.nextLine();
		while (choice < 1 || choice > 6 || !party[choice].isFainted())
		{
			System.out.print("Type in the number beside the Pokemon that you'd like to choose: ");
			choice = sc.nextInt();
			sc.nextLine();	
		}

		activePok = party[choice];
	}
}