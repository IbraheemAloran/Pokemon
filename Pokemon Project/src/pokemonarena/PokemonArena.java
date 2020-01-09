package pokemonarena;

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

public class PokemonArena extends Application {

    Pokemon[] party = new Pokemon[6];
    Pokemon activeClose;
    Pokemon activeFar;

    Button[] moveButtons = new Button[4];
    Button[] switchButtons = new Button[6];

    Image background;
    ImageView imageViewActiveClose;
    ImageView imageViewActiveFar;
    ImageView imageViewBackground;

    ProgressBar pbClose;
    ProgressBar pbFar;

    Label closeNameLabel;
    Label farNameLabel;
    Label movesLabel;
    Label switchLabel;

    Group battleGraphics;

    MenuBar menuBar;

    TextArea battleInfo;

    Separator sep;

    HBox movesLayout;
    HBox switchLayout;

    VBox layout;

    @Override
    public void start(Stage window) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("pokemonarena.fxml"));
        window.setTitle("Pokemon Arena");
        loadMenuBar();
        loadBattleGraphics();
        loadBattleText();
        loadMoveButtons();
        loadSwitchButtons();
        loadSeparator();

        layout = new VBox();
        layout.setAlignment(Pos.TOP_CENTER);

        layout.getChildren().add(menuBar);
        layout.getChildren().add(battleGraphics);
        layout.getChildren().add(movesLabel);
        layout.getChildren().add(movesLayout);
        layout.getChildren().add(sep);
        layout.getChildren().add(switchLabel);
        layout.getChildren().add(switchLayout);

        Scene scene = new Scene(layout, 800, 780);
        scene.getStylesheets().add("Dark.css");
        window.setScene(scene);
        window.show();
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

        menuBar.getMenus().addAll(gameMenu, aboutMenu, helpMenu);
    }

    public void loadActivePokemon() throws Exception{
        activeClose = new Pokemon("Blastoise", 100, new String[]{"Hydro pump", "Waterfall", "Water Pulse", "Water Dance"});
        activeFar = new Pokemon("Arceus", 100,  new String[]{"Water dance", "Surf", "Water Pulse", "Hydro pump"});
        party[0] = activeClose;
        party[1] =  new Pokemon("Gyarados", 100,  new String[]{"Water dance", "Surf", "Water Pulse", "Hydro pump"});
        party[2] =  new Pokemon("Ho-oh", 100,  new String[]{"rain dance", "Surf", "Water Pulse", "Hydro pump"});
        party[3] =  new Pokemon("Rhyperior", 100,  new String[]{"Water dance", "Surf", "Water Pulse", "Hydro pump"});
        party[4] =  new Pokemon("Arceus", 100,  new String[]{"Water dance", "Surf", "Water Pulse", "Hydro pump"});
        party[5] =  new Pokemon("blastoise", 100,  new String[]{"Water dance", "Surf", "Water Pulse", "Hydro pump"});

        imageViewActiveClose = new ImageView(activeClose.getBack());
        imageViewActiveFar = new ImageView(activeFar.getFront());

        battleGraphics.getChildren().add(imageViewActiveClose);
        battleGraphics.getChildren().add(imageViewActiveFar);

        closeNameLabel = new Label(activeClose.name+" lvl."+activeClose.level);

        pbClose = new ProgressBar(activeClose.getCurrentHP()/activeClose.getMaxHP());

        farNameLabel = new Label(activeFar.name+" lvl."+activeFar.level);

        pbFar = new ProgressBar(activeFar.currentHP/activeFar.maxHP);
    }

    public void updateActivePokemon(){
        //-----------------close---------------------------------------
        //setting the image view of active pokemon in play
        imageViewActiveClose.setImage(activeClose.back);

        //setting the fit height and width of the image view
        imageViewActiveClose.setScaleX(2);
        imageViewActiveClose.setScaleY(2);
        //150, 150

        //Setting the position of the image
        imageViewActiveClose.setX(100);
        imageViewActiveClose.setY(300);

        //name
        closeNameLabel.setText(activeClose.name+" lvl."+activeClose.level);
        closeNameLabel.setLayoutX(90);
        closeNameLabel.setLayoutY(200);

        //HPbar
        pbClose.setProgress(activeClose.getCurrentHP()/activeClose.getMaxHP());
        pbClose.setMinWidth(180);
        pbClose.setMinHeight(10);
        pbClose.setLayoutX(80);
        pbClose.setLayoutY(220);

        //---------------------far-----------------------------------------
        imageViewActiveFar.setImage(activeFar.front);

        //setting the fit height and width of the image view
        imageViewActiveFar.setScaleX(2);
        imageViewActiveFar.setScaleY(2);

        //Setting the position of the image
        imageViewActiveFar.setX(550);
        imageViewActiveFar.setY(100);

        //label
        farNameLabel.setText(activeFar.name+" lvl."+activeFar.level);
        farNameLabel.setLayoutX(550);
        farNameLabel.setLayoutY(16);
        //Hpbar
        pbFar.setProgress(activeFar.currentHP/activeFar.maxHP);
        pbFar.setLayoutX(530);
        pbFar.setLayoutY(40);
        pbFar.setMinWidth(140);
        //ProgressIndicator pi = new ProgressIndicator(0.6);
    }

    public void loadBattleText(){
        //textarea
        battleInfo = new TextArea();
        battleInfo.setText("Battle started");
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

    public void loadMoveButtons(){
        //Label
        movesLabel = new Label("Moves");
        movesLabel.setMinSize(100, 50);
        movesLabel.setAlignment(Pos.CENTER);
        movesLabel.setLineSpacing(100);


        //Creating buttons for moves
        movesLayout = new HBox();
        movesLayout.setMinWidth(800);
        movesLayout.setAlignment(Pos.CENTER);
        for(int i=0; i<activeClose.moves.length; i++){
            moveButtons[i] = new Button(activeClose.moves[i]+"\nPP: 25/25");
            String message = "\nUsed "+activeClose.moves[i];
            moveButtons[i].setOnAction(e -> attack(message));
            Tooltip t = new Tooltip("PP: 25/25\nType: Water\nCategory: Special\nPower: 150\n Effect: Does tons of damage");
            Tooltip.install(moveButtons[i], t);
            //move.setPadding(new Insets(30, 30, 30, 30));
            //move.setAlignment(Pos.CENTER);
            moveButtons[i].setMinHeight(50);
            moveButtons[i].setMinWidth(100);
            //move.setLayoutX(300);
            movesLayout.getChildren().add(moveButtons[i]);
        }
        movesLayout.setSpacing(30);
    }

    public void loadSeparator(){
        sep = new Separator();
        sep.setOrientation(Orientation.HORIZONTAL);
        sep.setPadding(new Insets(30, 30, 0, 30));
    }

    public void loadSwitchButtons(){
        //Label
        switchLabel = new Label("Pokemon");
        switchLabel.setMinSize(100, 50);
        switchLabel.setAlignment(Pos.CENTER);
        switchLabel.setLineSpacing(100);

        //creating buttons for switching
        switchLayout = new HBox();
        switchLayout.setMinWidth(800);
        switchLayout.setAlignment(Pos.CENTER);
        for(int i=0; i<party.length; i++){
            ImageView buttonImage = new ImageView(party[i].front);
            buttonImage.setFitHeight(25);
            buttonImage.setFitWidth(25);
            switchButtons[i] = new Button(party[i].name, buttonImage);
            switchButtons[i].setMinHeight(50);
            switchButtons[i].setMinWidth(100);
            String message1 = "\nSwitched to "+party[i].name;
            Pokemon newPokemon = party[i];
            int pos = i;
            switchButtons[i].setOnAction(e -> switchPokemon(message1, newPokemon, pos));
            switchLayout.getChildren().add( switchButtons[i]);
        }
        switchButtons[0].setDisable(true);
        switchLayout.setSpacing(20);
    }

    public void attack(String message){
        Pokemon defending = activeFar;
        Pokemon attacking = activeClose;
        battleInfo.appendText(message);
        defending.currentHP = defending.currentHP-10;
        try {
            //loadBackground();
            updateActivePokemon();
            //loadBattleText();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void switchPokemon(String message, Pokemon newP, int pos){
        battleInfo.appendText(message);
        activeClose = newP;
        for(int i=0; i<switchButtons.length; i++){
            switchButtons[i].setDisable(false);
        }
        switchButtons[pos].setDisable(true);
        /*try{
            loadBackground();
        }
       catch(Exception e){
            System.out.println(e);
       }*/
        updateActivePokemon();
        loadMoveButtons();
        //loadBattleText();
    }
}


/*Timer is used to schedule tasks.. So where do you write those tasks?? Well you have to write those tasks in a TimerTask class...

Confused ? Let me break it down,

Timer timer = new Timer();
Now you have created a object of Timer class .. Now you have to do some task right? So to do that create an object of TimerTask.

TimerTask task = new TimerTask()
{
        public void run()
        {
            //The task you want to do
        }

};
Now you have created a task where you should be defining the tasks you want to do inside the run method..

Why have I written a TimerTask class itself?? Thats because TimerTask is a abstract class with three methods.. So you need to define whichever method you want to use..

Now scheduling the task

timer.schedule(task,5000l);*/