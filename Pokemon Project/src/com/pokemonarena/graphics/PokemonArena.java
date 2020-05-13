package com.pokemonarena.graphics;

import com.pokemonarena.Global;
import com.pokemonarena.Pokemon;
import com.pokemonarena.move.Move;
import com.pokemonarena.player.HumanPlayer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PokemonArena extends Application implements Global {

    private HumanPlayer p1, p2;
    private int turn;    //P1 or P2
    private ArrayList<Pokemon> pokedex;        //LIST OF ALL POKEMON
    private Scanner kb;

    //private Pokemon[] p1.getParty() = new Pokemon[6];
    //private Pokemon activeClose, activeFar;

    private Button[] moveButtons = new Button[4];
    private Button[] switchButtons = new Button[6];

    private Image background;
    private ImageView imageViewActiveClose, imageViewActiveFar, imageViewBackground;

    private ProgressBar pbClose, pbFar;

    private Label closeNameLabel, farNameLabel, movesLabel, switchLabel;

    private Group battleGraphics;

    private MenuBar menuBar;

    private TextArea battleInfo;

    private Separator sep;

    private HBox movesLayout, switchLayout;

    private VBox layout;

    @Override
    public void start(Stage window) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("pokemonarena.fxml"));
        loadPokemon();
        kb = new Scanner(System.in); //for getting input

        System.out.println("Please Enter the name for Player 1:");
        p1 = new HumanPlayer(kb.nextLine());
        System.out.println("Please Enter the name for Player 2:");
        p2 = new HumanPlayer(kb.nextLine());

        p1.setRandomParty(pokedex);
        p2.setRandomParty(pokedex);
        turn = coinToss();

        window.setTitle("Pokemon Arena");
        loadGraphics();
        loadLayout();
        //moveButtons[0].setId("water-button");

        Scene scene = new Scene(layout, 800, 790);
        scene.getStylesheets().add("com/pokemonarena/graphics/Dark.css"); //load custom theme
        window.setScene(scene);
        window.show();
    }

    public void loadGraphics() throws Exception {
        loadMenuBar();
        loadBattleGraphics();
        loadMoveButtons();
        updateMoveButtons();
        loadSwitchButtons();
        updateSwitchButtons();
        loadSeparator();
    }

    public void loadLayout() {
        layout = new VBox();
        layout.setAlignment(Pos.TOP_CENTER);

        layout.getChildren().add(menuBar);
        layout.getChildren().add(battleGraphics);
        layout.getChildren().add(movesLabel);
        layout.getChildren().add(movesLayout);
        layout.getChildren().add(sep);
        layout.getChildren().add(switchLabel);
        layout.getChildren().add(switchLayout);
    }

    //THIS FUNCTION DECIDES WHO STARTS THE MATCH
    public int coinToss() {
        //CHECK IF P1 HAS A FASTER POKEMON
        if (p1.getActivePok().getStats(SPEED) > p2.getActivePok().getStats(SPEED)) {
            return P1;
        }
        //CHECK IF P2 HAS A FATSER POKEMON
        if (p1.getActivePok().getStats(SPEED) < p2.getActivePok().getStats(SPEED)) {
            return P2;
        }
        //OTHERWISE DECIDES RANDOMLY
        else {
            Random rand = new Random();
            if(rand.nextBoolean()){
                return P1;
            }
            else{
                return P2;
            }
        }
    }

    //THIS FUNCTION LOADS ALL THE POKEMON FROM THE TEXT FILE
    private void loadPokemon() {
        Scanner inputStream = null;
        pokedex = new ArrayList<>();
        try {
            inputStream = new Scanner(new FileInputStream("pokemon-data.txt"));
            while (inputStream.hasNextLine()) {
                String[] data = new String[5];
                for (int i = 0; i < 5; i++) {
                    data[i] = inputStream.nextLine();
                }
                pokedex.add(new Pokemon(data));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        inputStream.close();
    }

    public void loadBackground() throws FileNotFoundException {
        background = new Image(new FileInputStream("images/background/staduim.jpg"));
        //Setting the image view of background
        imageViewBackground = new ImageView(background);
        battleGraphics.getChildren().add(imageViewBackground);

        //Setting the position of the background
        imageViewBackground.setX(0);
        imageViewBackground.setY(0);

    }

    public void loadMenuBar(){
        //menuBar
        menuBar = new MenuBar();

        Menu gameMenu = new Menu("Game");
        gameMenu.getItems().addAll(new MenuItem("Restart"), new MenuItem("Exit"));
        Menu aboutMenu = new Menu("About");
        aboutMenu.getItems().addAll(new MenuItem("Info..."), new MenuItem("Credits..."));
        Menu helpMenu = new Menu("Help");
        aboutMenu.getItems().addAll(new MenuItem("Tutorial"), new MenuItem("Submit a Bug..."));

        Label version = new Label("v1.0");
        menuBar.getMenus().addAll(gameMenu, aboutMenu, helpMenu);
    }

    public void loadActivePokemon() throws Exception{
        /*activeClose = new Pokemon("Blastoise", 100, new String[]{"Hydro pump", "Waterfall", "Water Pulse", "Water Dance"});
        activeFar = new Pokemon("Arceus", 100,  new String[]{"Water dance", "Surf", "Water Pulse", "Hydro pump"});
        party[0] = activeClose;
        p1.getParty()[1] =  new Pokemon("Gyarados", 100,  new String[]{"Water dance", "Surf", "Water Pulse", "Hydro pump"});
        p1.getParty()[2] =  new Pokemon("Ho-oh", 100,  new String[]{"rain dance", "Surf", "Water Pulse", "Hydro pump"});
        p1.getParty()[3] =  new Pokemon("Rhyperior", 100,  new String[]{"earthquake", "Surf", "Water Pulse", "Hydro pump"});
        p1.getParty()[4] =  new Pokemon("Arceus", 100,  new String[]{"Water dance", "Surf", "Water Pulse", "Hydro pump"});
        p1.getParty()[5] =  new Pokemon("blastoise", 100,  new String[]{"Water dance", "Surf", "Water Pulse", "Hydro pump"});
        p1.getParty()[5].setFainted();*/


        imageViewActiveClose = new ImageView(p1.getActivePok().getBack());
        imageViewActiveFar = new ImageView(p2.getActivePok().getFront());

        battleGraphics.getChildren().add(imageViewActiveClose);
        battleGraphics.getChildren().add(imageViewActiveFar);

        closeNameLabel = new Label(p1.getActivePok().getName()+" lvl."+p1.getActivePok().getLevel());

        pbClose = new ProgressBar(p1.getActivePok().getStats(HP)/p1.getActivePok().getMaxHP());

        farNameLabel = new Label(p2.getActivePok().getName()+" lvl."+p2.getActivePok());

        pbFar = new ProgressBar(p2.getActivePok().getStats(HP)/p2.getActivePok().getMaxHP());
    }

    public void updateActivePokemon(){
        //-----------------close---------------------------------------
        //setting the image view of active pokemon in play
        imageViewActiveClose.setImage(p1.getActivePok().getBack());

        //setting the fit height and width of the image view
        imageViewActiveClose.setScaleX(2);
        imageViewActiveClose.setScaleY(2);
        //150, 150

        //Setting the position of the image
        imageViewActiveClose.setX(100);
        imageViewActiveClose.setY(300);

        //getName()
        closeNameLabel.setText(p1.getActivePok().getName()+" lvl."+p1.getActivePok().getLevel());
        closeNameLabel.setLayoutX(90);
        closeNameLabel.setLayoutY(196);

        //HPbar
        pbClose.setProgress(p1.getActivePok().getStats(HP)/p1.getActivePok().getMaxHP());
        pbClose.setMinWidth(180);
        //pbClose.setMinHeight(10);
        pbClose.setLayoutX(80);
        pbClose.setLayoutY(220);

        //---------------------far-----------------------------------------
        imageViewActiveFar.setImage(p2.getActivePok().getFront());

        //setting the fit height and width of the image view
        imageViewActiveFar.setScaleX(2);
        imageViewActiveFar.setScaleY(2);

        //Setting the position of the image
        imageViewActiveFar.setX(550);
        imageViewActiveFar.setY(100);

        //label
        farNameLabel.setText(p2.getActivePok().getName()+" lvl."+p2.getActivePok().getLevel());
        farNameLabel.setLayoutX(550);
        farNameLabel.setLayoutY(16);
        //Hpbar
        pbFar.setProgress(p2.getActivePok().getStats(HP)/p2.getActivePok().getMaxHP());
        pbFar.setLayoutX(530);
        pbFar.setLayoutY(40);
        pbFar.setMinWidth(180);
        //ProgressIndicator pi = new ProgressIndicator(0.6);
    }

    public void loadBattleText(){
        //textarea
        battleInfo = new TextArea();
        battleInfo.setEditable(false);
        battleInfo.appendText("Battle started");
        battleInfo.setMaxHeight(120);
        battleInfo.setLayoutY(360);
        battleInfo.setMinWidth(800);
        // Font f = Font.loadFont(new FileInputStream("fonts/ClassicGame.fon"), 12);
        try{
            Font f = Font.loadFont("file:fonts/pokemon-ds-font.ttf", 22);
            battleInfo.setFont(f);
        }
        catch(Exception e){
            System.out.println("Font not found.");
        }
        battleGraphics.getChildren().add(battleInfo);
    }

    public void loadBattleGraphics() throws Exception{
        //create group, holds all battle graphic components
        battleGraphics = new Group();

        loadBackground();
        loadActivePokemon();
        updateActivePokemon();
        loadBattleText();

        battleGraphics.getChildren().add(closeNameLabel);
        battleGraphics.getChildren().add(pbClose);

        battleGraphics.getChildren().add(farNameLabel);
        battleGraphics.getChildren().add(pbFar);
    }

    //updates the moves the move buttons hold
    public void updateMoveButtons(){ //must implement with new moves
        for(int i=0; i<4; i++){
            Move currentMove = p1.getActivePok().getMoves(i);
            moveButtons[i].setText(currentMove.getName()+"\nPP: "+currentMove.getPp()+"/"+currentMove.getMaxPP());
            String message = "\n"+p1.getActivePok().getName()+" Used "+currentMove.getName()+"!";
            moveButtons[i].setOnAction(e -> attack(message));
            Tooltip t = new Tooltip(""+currentMove);
            Tooltip.install(moveButtons[i], t);
        }
    }

    public void loadMoveButtons(){
        //moves Label
        movesLabel = new Label("Moves");
        movesLabel.setMinSize(100, 50);
        movesLabel.setAlignment(Pos.CENTER);
        movesLabel.setLineSpacing(100);


        //Creating horizontal layout to hold moves
        movesLayout = new HBox();
        movesLayout.setMinWidth(800);
        movesLayout.setAlignment(Pos.CENTER);
        movesLayout.setSpacing(30);

        //intialize buttons
        for(int i=0; i<4; i++){
            moveButtons[i] = new Button();
            moveButtons[i].setMinHeight(50);
            moveButtons[i].setMinWidth(100);
            movesLayout.getChildren().add(moveButtons[i]);
        }
    }

    public void loadSeparator(){
        sep = new Separator();
        sep.setOrientation(Orientation.HORIZONTAL);
        sep.setPadding(new Insets(30, 30, 0, 30));
    }

    public void loadSwitchButtons(){
        //switch pokemon heading
        switchLabel = new Label("Pokemon");
        switchLabel.setMinSize(100, 50);
        switchLabel.setAlignment(Pos.CENTER);
        switchLabel.setLineSpacing(100);

        //creating horizontal layout to hold switch buttons
        switchLayout = new HBox();
        switchLayout.setMinWidth(800);
        switchLayout.setAlignment(Pos.CENTER);

        for(int i=0; i<p1.getParty().length; i++){
            ImageView buttonImage = new ImageView(p1.getParty()[i].getFront());
            buttonImage.setFitHeight(25);
            buttonImage.setFitWidth(25);
            switchButtons[i] = new Button(p1.getParty()[i].getName(), buttonImage);
            switchButtons[i].setMinHeight(50);
            switchButtons[i].setMinWidth(100);
            Tooltip t = new Tooltip(""+p1.getParty()[i]);
            Tooltip.install(switchButtons[i], t);

            String message = "\nSwitched to "+p1.getParty()[i].getName();
            Pokemon newPokemon = p1.getParty()[i];
            switchButtons[i].setOnAction(e -> {
                if(p1.getActivePok() == newPokemon){
                    battleInfo.appendText("\n"+newPokemon.getName()+" is already active!");
                }
                else{
                    switchPokemon(message, newPokemon);
                }
            });
            switchLayout.getChildren().add( switchButtons[i]);
        }
        //switchButtons[0].setDisable(true);
        switchLayout.setSpacing(20);
    }

    /**makes sure the the active Pokemons button has a blue border and makes sure all fainted pokemons buttons are disabled.*/
    public void updateSwitchButtons(){
        for(int i=0; i<p1.getParty().length; i++){
            if(p1.getParty()[i] == p1.getActivePok()){
                switchButtons[i].setId("active-button");
            }
            else{
                switchButtons[i].setId("button");
                if(p1.getParty()[i].isFainted()){
                    switchButtons[i].setDisable(true);
                }
                else{
                    switchButtons[i].setDisable(false);
                }
            }
        }
    }
    

    public void attack(String message){
        Pokemon defending = p2.getActivePok();
        Pokemon attacking = p1.getActivePok();
        battleInfo.appendText(message);
        defending.setStats(HP, defending.getStats(HP) - 10);
        try {
            //loadBackground();
            updateActivePokemon();
            updateSwitchButtons();
            //loadBattleText();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void switchPokemon(String message, Pokemon newP){
        battleInfo.appendText(message);
         p1.setActivePok(newP);

        try{
            updateActivePokemon();
            updateMoveButtons();
            updateSwitchButtons();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}