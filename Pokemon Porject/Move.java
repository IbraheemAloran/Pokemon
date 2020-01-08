import java.util.*;

public class Move{
	private String name;
	private int pp;
	private int type;
	private int power;
	private Effect effect;
	private int acc;
	private int cat;

	public Move(String data){
	//fire punch,15,8,75,100,7,10 21
		String[] info = data.split(",");
		name = info[0];
		pp = Integer.parseInt(info[1]);
		type = Integer.parseInt(info[2]);
		power = Integer.parseInt(info[3]);
		acc = Integer.parseInt(info[4]);
		cat = Integer.parseInt(info[5]);
		effect = new Effect(info[6]);
	}

	public boolean useMove(Pokemon attacking, Pokemon defending){
		if (hit()){

			return true;
		}
		return false;
	}

	public boolean hit(){
		Random rand = new Random();
		int choice = rand.nextInt(100);
		if (choice <= acc) return true;
		return false; 
	}
}