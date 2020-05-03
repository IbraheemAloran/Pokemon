package com.pokemonarena;

import com.pokemonarena.move.Move;
import javafx.scene.image.Image;

import java.io.FileInputStream;

public class Pokemon implements Global
{
    private String name;
    private int type;
    private boolean fainted;
    private int status;
    private int level;
    private int[] stats;
    private Image front;
    private Image back;
    private Move[] moves;
    private String[] oldMoves;
    private int maxHP;

    public Pokemon(){}

    public Pokemon(String[] data){
        stats = new int[6];
        moves = new Move[4];
        //Pikachu,11,100,6 stuff after
        String[] info = data[0].split(",");
        name = info[0];
        type = Integer.parseInt(info[1]);
        status = 37;
        //level = Integer.parseInt(info[1]);
        level = 100;
        maxHP = Integer.parseInt(info[2]);
        stats[0] = Integer.parseInt(info[2]);
        stats[1] = Integer.parseInt(info[3]);
        stats[2] = Integer.parseInt(info[4]);
        stats[3] = Integer.parseInt(info[5]);
        stats[4] = Integer.parseInt(info[6]);
        stats[5] = Integer.parseInt(info[7]);
        fainted = false;

        moves = new Move[4];
        moves[0] = new Move(data[1]);
        moves[1] = new Move(data[2]);
        moves[2] = new Move(data[3]);
        moves[3] = new Move(data[4]);
    }

    public Pokemon(String name, int level, String[] moves) throws Exception{ //old constructor
        oldMoves = new String[4];
        stats = new int[6];
        this.name = name;
        this.level = level;
        this.oldMoves = moves;
        maxHP = 100;
        stats[HP] = maxHP;
        fainted = false;


        front = new Image("https://img.pokemondb.net/sprites/black-white/anim/normal/"+name+".gif", true);
        back = new Image("https://img.pokemondb.net/sprites/black-white/anim/back-normal/"+name+".gif", true);



        front = new Image(new FileInputStream("images/pokemon sprites/"+name.toLowerCase()+".gif"));


        //back = new Image("https://img.pokemondb.net/sprites/black-white/anim/back-normal/"+name+".gif");

        back = new Image(new FileInputStream("images/pokemon sprites/"+name.toLowerCase()+" (1).gif"));

        //System.out.println("Could not load online sprites, will use offline sprites if available.");
    }


    public boolean attack(int choice, Pokemon defending){
        return moves[choice].useMove(this, defending);
    }

    public void changeHP(int change){
        stats[HP] += change;
    }

	/*public void setStats(Pokemon pok)
	{
		this.name = pok.getName();
		this.type = pok.getType();
		this.fainted = pok.isFainted();
		this.status = pok.getStatus();
		this.level = pok.getLevel();
		for (int i = 0; i < 6; i++)
		{
			this.stats[i] = pok.getStats(i);
		}

		this.front = pok.getFront();
		this.back = pok.getBack();
		for (int i = 0; i < 4; i++)
		{
			this.moves[i] = pok.getMoves(i);
		}
	}

	public void displayMoves()
	{
		for (int i = 0; i < 4; i++)
		{
			System.out.println((i + 1) + ". " + moves[i]);
		}
	}*/

    public String getName()
    {
        return name;
    }

    public int getType()
    {
        return type;
    }

    public boolean isFainted()
    {
        return fainted;
    }

    public int getStatus()
    {
        return status;
    }

    public int getLevel()
    {
        return level;
    }

    public int getStats(int i)
    {
        return stats[i];
    }

    public Image getFront()
    {
        return front;
    }

    public Image getBack()
    {
        return back;
    }

    public Move getMoves(int i)
    {
        return moves[i];
    }

    public int getMaxHP(){
        return maxHP;
    }

    public void setFainted(){
        fainted = true;
    }

    public void setStats(int i, int value){
        stats[i] = value;
    }
}

/*public class Pokemon {

    public String name;
    public int level;
    public Image front;
    public Image back;
    public double maxHP;
    public double currentHP;
    public String[] moves;

    public boolean fainted;
    public Pokemon(){ }

    public Pokemon(String name, int level, String[] moves) throws Exception{
        this.name = name;
        this.level = level;
        this.moves = moves;
        maxHP = 100;
        currentHP = maxHP;
        fainted = false;


        front = new Image("https://img.pokemondb.net/sprites/black-white/anim/normal/"+name+".gif", true);
        back = new Image("https://img.pokemondb.net/sprites/black-white/anim/back-normal/"+name+".gif", true);



                front = new Image(new FileInputStream("images/pokemon sprites/"+name.toLowerCase()+".gif"));


            //back = new Image("https://img.pokemondb.net/sprites/black-white/anim/back-normal/"+name+".gif");

                back = new Image(new FileInputStream("images/pokemon sprites/"+name.toLowerCase()+" (1).gif"));

            //System.out.println("Could not load online sprites, will use offline sprites if available.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Image getFront() {
        return front;
    }

    public void setFront(Image front) {
        this.front = front;
    }

    public Image getBack() {
        return back;
    }

    public void setBack(Image back) {
        this.back = back;
    }

    public double getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }

    public double getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(double currentHP) {
        this.currentHP = currentHP;
    }

    public String[] getMoves() {
        return moves;
    }

    public void setMoves(String[] moves) {
        this.moves = moves;
    }

    public boolean isFainted() {
        return fainted;
    }

    public void setFainted(boolean fainted) {
        this.fainted = fainted;
    }

}*/


