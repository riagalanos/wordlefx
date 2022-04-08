package com.example.studentwordle;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Represents the whole graphical user interface (GUI).
 */
public class GameView extends VBox {
  /**
   * The GameController consumed by the TileBoard and the four graphical elements that make up
   * the view: a StackPane, a Label, a GridPane, and a VBox.
   */
  private GameController controller;
  private StackPane title;
  private Label message=new Label("");
  private GridPane tileBoard;
  private VBox keyboard;
  /**
   * Creates a new GameView that is a VBox which has a connection to the specified
   * GameController. Sets the spacing between VBox elements to be 40. Builds the GameView.
   */
  public GameView(GameController control) {
    setSpacing(40);
    controller = control;
    getStylesheets().add(getClass().getResource("/css/wordle.css").toExternalForm());
    buildGameView();
  }
  /**
   * Creates the four graphical elements that make up the GameView and adds them to the VBox.
   */
  public void buildGameView(){
    title = createTitle();
    // TODO: initialize the message by calling the method that will create it.
    tileBoard = new TileBoard(controller);
    keyboard = new Keyboard(controller);
    getChildren().addAll(title, message, tileBoard, keyboard);
    getStyleClass().add("main-screen");
  }
  /**
   * Creates the StackPane that will hold the title.
   * @return a StackPane for the title
   */
  public StackPane createTitle() {
    Label title = new Label("AUWordleFX");
    title.getStyleClass().add("title");
    // TODO: align the title in the top center of its parent element
    StackPane pane = new StackPane();
    pane.getChildren().add(title);
    pane.getChildren().add(new Separator());
    pane.setAlignment(Pos.BOTTOM_CENTER);
    return pane;
  }
  /**
   * Creates the Label that will hold the message alerting users to their stage of the game.
   * @return a Label for the message
   */
  public Label createMessageBox(){
    StringProperty messageText = controller.announcementProperty();
    Label message = new Label(messageText.get());
    message.getStyleClass().add("message");
    // The ChangeListener listens to model for changes in the message and updates UI as needed
    messageText.addListener(new ChangeListener<String>(){
      @Override
      public void changed(ObservableValue<? extends String> observable, String oldValue,
                          String newValue){
        message.setText(newValue);
      }
    });
    return message;
  }
}
