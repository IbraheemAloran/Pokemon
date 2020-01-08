import java.util.HashMap.*;

public interface Global
{
	int HP = 0;
	int ATTACK = 1;
	int SATTACK = 2;
	int DEFENSE = 3;
	int SDEFENSE = 4;
	int SPEED = 5;
	int SPECIAL = 6;
	int PHYSICAL = 7;
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

//EEFECTIVENESS
	HashMap[] typeChart = new HashMap[8];
	typeChart[0] = new HashMap<Integer,Integer>();
}