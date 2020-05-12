package com.pokemonarena.graphics; /********BATTLE ARENA CLASS*********/

import com.pokemonarena.Global;
import com.pokemonarena.Pokemon;
import com.pokemonarena.player.HumanPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Arena implements Global {
	private HumanPlayer p1,p2;
	private boolean turn;	//TRUE= p1 TURN, FALSE = p2 TURN
	ArrayList<Pokemon> pokedex;		//LIST OF ALL POKEMON
	Scanner kb = new Scanner(System.in);
	//private Image;
	
	//CONSTRUCTOR
	public Arena() {
		pokedex = new ArrayList<Pokemon>();
		System.out.println("Please Enter the name for Player 1:");
		p1 = new HumanPlayer(kb.nextLine());
		System.out.println("Please Enter the name for Player 2:");
		p2 = new HumanPlayer(kb.nextLine());
		turn = coinToss();
	}
	
	//THIS FUNCTION DECIDES WHO STARTS THE MATCH
	private boolean coinToss() {
		//CHECK IF P1 HAS A FASTER POKEMON
		if(p1.getActivePok().getStats(SPEED) > p2.getActivePok().getStats(SPEED)) {
			return true;
		}
		//CHECK IF P2 HAS A FATSER POKEMON
		if(p1.getActivePok().getStats(SPEED) < p2.getActivePok().getStats(SPEED)) {
			return false;
		}
		//OTHERWISE DECIDES RANDOMLY
		else {
			Random rand = new Random();
			return rand.nextBoolean();
		}
	}
	
	//THIS FUNCTION LOADS ALL THE POKEMON FROM THE TEXT FILE
	private void loadPokemon() {
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream(""));
			while(inputStream.hasNextLine()) {
				String[] data = new String[5];
				for(int i=0;i<5;i++) {
					data[i] = inputStream.nextLine();
				}
				pokedex.add(new Pokemon(data));
			}
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
		inputStream.close();
	}
	
	/*THIS FUNCTION SIMULATES THE POKEMON BATTLE AND RETURNS A PLAYER OBJECT OF THE WINNER
	 RETURNS 0 IF P2 WINS, 1 IF P1 WINS*/
	public int battle() {
		while(true) {
			if(p1.isOut()) {	//IF P1 WHITES OUT THEN P2 WINS
				return 0;
			}
			else if(p1.isOut()) {
				return 1;
			}
			else {
				if(turn) {	//IF TURN = TRUE THEN IT IS P1'S MOVE
					
					//p1.play();
				}
				else {
					//p2.play();
				}
				turn = !turn;
			}
		}
	}
	
	//THIS FUNCTION STARTS THE BATTLE SIMULATION
	public void start() {
		p1.setRandomParty(pokedex);
		p2.setRandomParty(pokedex);
		battle();
	}
	
}























