package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {
    Pokemon[] party = new Pokemon[6];
    Pokemon activeClose;
    Pokemon activeFar;
    ImageView imageViewActiveClose;
    ImageView imageViewActiveFar;
    Button[] switchButtons = new Button[6];
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Pokemon Simulator");

        //https://img.pokemondb.net/sprites/black-white/anim/normal/ivysaur.gif
        //Creating an image
        Image background = new Image(new FileInputStream("images/background/staduim.jpg"));

        //Image back = new Image(new FileInputStream("images/blastoise/blastoise-back.gif"));
        //Image front = new Image(new FileInputStream("images/blastoise/blastoise-front.gif"));

        activeClose = new Pokemon("Blastoise", 100, new String[]{"Hydro pump", "Waterfall", "Water Pulse", "Water Dance"});
        activeFar = new Pokemon("Arceus", 100,  new String[]{"Water dance", "Surf", "Water Pulse", "Hydro pump"});
        party[0] = activeClose;
        party[1] =  new Pokemon("Gyarados", 100,  new String[]{"Water dance", "Surf", "Water Pulse", "Hydro pump"});
        party[2] =  new Pokemon("Ho-oh", 100,  new String[]{"Water dance", "Surf", "Water Pulse", "Hydro pump"});
        party[3] =  new Pokemon("Rhyperior", 100,  new String[]{"Water dance", "Surf", "Water Pulse", "Hydro pump"});
        party[4] =  new Pokemon("Arceus", 100,  new String[]{"Water dance", "Surf", "Water Pulse", "Hydro pump"});
        party[5] =  new Pokemon("blastoise", 100,  new String[]{"Water dance", "Surf", "Water Pulse", "Hydro pump"});

        Group battleGraphics = new Group();
        //Setting the image view
        ImageView imageViewBackground = new ImageView(background);
        battleGraphics.getChildren().add(imageViewBackground);

        imageViewActiveClose = new ImageView(activeClose.back);
        imageViewActiveFar = new ImageView(activeFar.front);
        battleGraphics.getChildren().addAll(imageViewActiveClose, imageViewActiveFar);

        //Setting the position of the image
        imageViewBackground.setX(0);
        imageViewBackground.setY(0);

        //100, 300

        //setting the fit height and width of the image view
        imageViewActiveClose.setScaleX(2);
        imageViewActiveClose.setScaleY(2);
        //150, 150

        //Setting the position of the image
        imageViewActiveClose.setX(100);
        imageViewActiveClose.setY(300);

        //imageViewActiveClose.setOpacity(1);

        //setting the fit height and width of the image view
        imageViewActiveFar.setScaleX(2);
        imageViewActiveFar.setScaleY(2);

        //Setting the position of the image
        imageViewActiveFar.setX(550);
        imageViewActiveFar.setY(100);

        //Setting the preserve ratio of the image view
        imageViewBackground.setPreserveRatio(true);
        imageViewActiveFar.setPreserveRatio(true);
        imageViewActiveClose.setPreserveRatio(true);

        //name
        Label closeNameLabel = new Label(activeClose.name+" lvl."+activeClose.level);
        closeNameLabel.setLayoutX(90);
        closeNameLabel.setLayoutY(200);
        battleGraphics.getChildren().add(closeNameLabel);
        //HPbar
        ProgressBar pb = new ProgressBar(activeFar.maxHP);
        pb.setMinWidth(180);
        pb.setMinHeight(10);
        pb.setLayoutX(80);
        pb.setLayoutY(220);
        battleGraphics.getChildren().add(pb);

        //label
        Label farNameLabel = new Label(activeFar.name+" lvl."+activeFar.level);
        farNameLabel.setLayoutX(550);
        farNameLabel.setLayoutY(16);
        battleGraphics.getChildren().add(farNameLabel);
        //Hpbar
        ProgressBar pb1 = new ProgressBar(activeFar.currentHP/activeFar.maxHP);
        pb1.setLayoutX(530);
        pb1.setLayoutY(40);
        pb1.setMinWidth(140);
        battleGraphics.getChildren().add(pb1);
        //ProgressIndicator pi = new ProgressIndicator(0.6);

        //textarea
        TextArea battleInfo = new TextArea();
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

        //menuBar
        MenuBar menuBar = new MenuBar();

        Menu gameMenu = new Menu("Game");
        gameMenu.getItems().addAll(new MenuItem("Restart"), new MenuItem("Exit"));
        Menu aboutMenu = new Menu("About");
        aboutMenu.getItems().addAll(new MenuItem("Info..."), new MenuItem("Credits.."));
        Menu helpMenu = new Menu("Help");
        aboutMenu.getItems().addAll(new MenuItem("Tutorial"), new MenuItem("Submit a Bug.."));

        menuBar.getMenus().addAll(gameMenu, aboutMenu, helpMenu);

        VBox layout = new VBox();
        layout.getChildren().add(menuBar);
        layout.getChildren().add(battleGraphics);
        //layout.setMinWidth(800);
        layout.setAlignment(Pos.TOP_CENTER);

        //Label
        Label movesLabel = new Label("Moves");
        movesLabel.setMinSize(100, 50);
        movesLabel.setAlignment(Pos.CENTER);
        movesLabel.setLineSpacing(100);
        layout.getChildren().add(movesLabel);

        //Creating buttons for moves
        HBox movesLayout = new HBox();
        movesLayout.setMinWidth(800);
        movesLayout.setAlignment(Pos.CENTER);
        for(int i=0; i<activeClose.moves.length; i++){
            Button move = new Button(activeClose.moves[i]);
            String message = "\nUsed "+activeClose.moves[i];
            move.setOnAction(e -> attack(message, battleInfo, pb1));
            Tooltip t = new Tooltip("PP: 25/25\nType: Water\nCategory: Special\nPower: 150\n Effect: Does tons of damage");
            Tooltip.install(move, t);
            //move.setPadding(new Insets(30, 30, 30, 30));
            //move.setAlignment(Pos.CENTER);
            move.setMinHeight(50);
            move.setMinWidth(100);
            //move.setLayoutX(300);
            movesLayout.getChildren().add(move);
        }
        movesLayout.setSpacing(30);
        layout.getChildren().add(movesLayout);

        Separator sep = new Separator();
        sep.setOrientation(Orientation.HORIZONTAL);
        sep.setPadding(new Insets(30, 30, 0, 30));
        layout.getChildren().add(sep);

        //Label
        Label switchLabel = new Label("Pokemon");
        switchLabel.setMinSize(100, 50);
        switchLabel.setAlignment(Pos.CENTER);
        switchLabel.setLineSpacing(100);
        layout.getChildren().add(switchLabel);

        //creating buttons for switching
        HBox switchLayout = new HBox();
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
            switchButtons[i].setOnAction(e -> switchPokemon(message1, battleInfo, newPokemon, pb, closeNameLabel, pos));
            switchLayout.getChildren().add( switchButtons[i]);
        }
        switchButtons[0].setDisable(true);
        switchLayout.setSpacing(20);
        layout.getChildren().add(switchLayout);
        Scene scene = new Scene(layout, 800, 750);
        scene.getStylesheets().add("Dark.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void attack(String message, TextArea text, ProgressBar bar){
        Pokemon defending = activeFar;
        Pokemon attacking = activeClose;
        text.appendText(message);
        defending.currentHP = defending.currentHP-10;
        bar.setProgress(defending.currentHP/defending.maxHP);
    }

    public void switchPokemon(String message, TextArea text, Pokemon newP, ProgressBar pb, Label label, int pos){
        text.appendText(message);
        activeClose = newP;
        for(int i=0; i<switchButtons.length; i++){
            switchButtons[i].setDisable(false);
        }
        switchButtons[pos].setDisable(true);
        imageViewActiveClose.setImage(activeClose.back);
        pb.setProgress(activeClose.currentHP/activeClose.maxHP);
        label.setText(activeClose.name+" lvl."+activeClose.level);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
