/********BATTLE ARENA CLASS*********/
import java.util.Random.*;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class Arena {
	private HumanPlayer p1,p2;
	private boolean turn;	//TRUE= p1 TURN, FALSE = p2 TURN
	ArrayList<Pokemon> pokedex;		//LIST OF ALL POKEMON
	//private Image;
	
	//CONSTRUCTOR
	public Arena() {
		pokedex = new ArrayList<Pokemon>();
		p1 = new HumanPlayer();
		p2 = new HumanPlayer();
		turn = coinToss();
	}
	
	//THIS FUNCTION DECIDES WHO STARTS THE MATCH
	private boolean coinToss() {
		//CHECK IF P1 HAS A FASTER POKEMON
		if(p1.getActivePok().getSpeed() > p2.getActivePok().getSpeed()) {
			return 1;
		}
		//CHECK IF P2 HAS A FATSER POKEMON
		if(p1.getActivePok().getSpeed() < p2.getActivePok().getSpeed()) {
			return 0;
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
				pokedex.add(new Pokemon(inputStream.nextLine()));
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
			if(p1.getWhiteOut()) {	//IF P1 WHITES OUT THEN P2 WINS
				return 0;
			}
			else if(p1.getWhiteOut()) {
				return 1;
			}
			else {
				if(turn) {	//IF TURN = TRUE THEN IT IS P1'S MOVE
					p1.play();
				}
				else {
					p2.play();
				}
				turn = !turn;
			}
		}
	}
	
	//THIS FUNCTION STARTS THE BATTLE SIMULATION
	public void start() {
		p1.addRandomPokemon(pokedex);
		p2.addRandomPokemon(pokedex);
		battle();
	}
}























