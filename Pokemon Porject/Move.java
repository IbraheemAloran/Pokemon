import java.util.*;

public class Move implements Global{
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
			if(cat!=8){
				int STAB = 1;
				if (type == attacking.type) STAB = 1.5;
				int damage = calculateDamage(STAB, attacking, defending);
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
			damage *= (attacking.getAttack() / defending.getDefense());
		}
		else if (cat == 7){
			damage *= (attacking.getSpecialAttack() / defending.getSpecialDefense());
		}
		damage /= 50;
		damage += 2;
		damage *= STAB;
		int multiplier = typeChart[type - 9].get(defending.getType());
		damage *= multiplier;
		return damage;
		
	}
	private boolean hit(){
		Random rand = new Random();
		int choice = rand.nextInt(100);
		if (choice <= acc) return true;
		return false; 
	}
}
