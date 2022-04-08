package com.example.studentwordle;

import org.kordamp.ikonli.javafx.FontIcon;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Represents the keyboard which the user will use to enter their guess.
 */
public class Keyboard extends VBox{
  /**
   * The GameController consumed by the Keyboard.
   */
  private GameController controller;
  /**
   * Creates a new Keyboard that is a VBox which has a connection to the specified
   * GameController. Creates the rows and styles the keyboard.
   */
  public Keyboard(GameController control){
    controller = control;
    createRows();
    // TODO Call the method that will add the style to the keyboard
  }
  /**
   * Creates three rows of pressable keys.
   */
  public void createRows(){
    String topRowLetters = "QWERTYUIOP";
    String middleRowLetters = ""; // TODO Add the missing letters for this row
    String bottomRowLetters = "ZXCVBNM";
    this.getChildren().addAll(createKeyRow(topRowLetters, 0, false, false),
      createKeyRow(middleRowLetters, 20.0, false, false),
      createKeyRow(bottomRowLetters, 0.0, true, true));
  }
  /**
   * Creates a single row of pressable keys with the specified letters and padding.
   * @param rowLetters A string of letters for that row
   * @param leftPadding The spacing in between keys
   * @param includeBackspace Whether the row should have a backspace key
   * @param includeEnter Whether the row should have an enter key
   * @return the Hbox that contains the row of keys
   */
  public HBox createKeyRow(String rowLetters, double leftPadding, boolean includeBackspace,
                           boolean includeEnter){
    HBox hbox = new HBox(6.0);
    if (includeEnter == true)
      hbox.getChildren().add(createKey("ENTER"));
    for (int i =0; i< rowLetters.length(); i++)
      hbox.getChildren().add(createKey(rowLetters.substring(i, i+1)));
    if (includeBackspace == true)
      hbox.getChildren().add(createKey("DELETE"));
    hbox.setPadding(new Insets(0,0,0,leftPadding));
    hbox.setFillHeight(false);
    return hbox;
  }
  /**
   * Creates a single keyboard key (button) to represent the letter for that key.
   * @param keyText The string for the key's letter
   */
  public Button createKey(String keyText){
    Button button = new Button(); // TODO Change so that the button displays the argument
    button.setMinSize(44.0, 58.0);
    button.getStyleClass().add("key-button");
    // This EventHandler is attached to the button and calls on the Controller to perform an
    // action when pressed
    button.setOnMouseClicked(new EventHandler<Event>() {
      @Override
      public void handle(Event event) {
        controller.handleKeyPressed(keyText);
      }
    });
    if (keyText.equals("DELETE")){
      button.setText("@");  //TODO Change this to a space
      button.setMinWidth(64.0);
      button.setGraphic(new FontIcon("typ-backspace-outline"));
    }
    return button;
  }
  /** Styles the VBox by setting the space between elements to be 8, aligns it in the center,
   * applies the main-screen css element for its style, and settings the padding for internal
   * elements.
   */
  public void styleKeyboard(){
    setSpacing(8);
    setAlignment(Pos.CENTER);
    getStyleClass().add("main-screen");
    setPadding(new Insets(10.0, 40.0, 10.0, 40.0));
  }
}
