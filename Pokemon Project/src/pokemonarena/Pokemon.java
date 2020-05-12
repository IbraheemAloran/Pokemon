package pokemonarena;

import javafx.scene.image.Image;

import java.io.FileInputStream;

public class Pokemon {

    public String name;
    public int level;
    public Image front;
    public Image back;
    public double maxHP;
    public double currentHP;
    public String[] moves;

    public Pokemon(){ }

    public Pokemon(String name, int level, String[] moves) throws Exception{
        this.name = name;
        this.level = level;
        this.moves = moves;
        maxHP = 100;
        currentHP = maxHP;

            //front = new Image("https://img.pokemondb.net/sprites/black-white/anim/normal/"+name+".gif");
            //back = new Image("https://img.pokemondb.net/sprites/black-white/anim/back-normal/"+name+".gif");

            //System.out.println("Could not load online sprites, will use offline sprites if available.");
            front = new Image(new FileInputStream("images/pokemon sprites/"+name.toLowerCase()+".gif"));
            back = new Image(new FileInputStream("images/pokemon sprites/"+name.toLowerCase()+" (1).gif"));
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

}
