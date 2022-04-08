package com.example.studentwordle;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.css.PseudoClass;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * Represents the graphical display of the 2D grid of tiles represented by the model.
 */
public class TileBoard extends GridPane {
  /**
   * The GameController consumed by the TileBoard.
   */
  private GameController controller;
  /**
   * Creates a new TileBoard with a connection to the specified GameController.
   * A TileBoard is a GridPane that is centered in the middle of its parent container. The
   * initial state of the TileBoard is a board filled with empty tiles.
   * The horizontal and vertical gaps between each of its nodes should be 5.
   * @param control Creates a TileBoard with access to the GameController.
   */
  public TileBoard(GameController control) {
    //TODO: Initializer controller.
    //TODO: Set the Hgap and Vgap of this object to 5
    //TODO: Create the initial board of empty tiles
    //TODO: Center the TilePane.
    StackPane testPane = new StackPane(new Label(":)")); // remove after completing steps above
    this.getChildren().add(testPane);// remove after completing the constructor
  }
  /**
   * Creates the initial 5 column, 6 row TileBoard filed with Tile objects styled as empty.
   */
  public void createEmptyBoard() {
    Tile[][] gameGrid = controller.getModel().getGrid();
    for (int row = 0; row < gameGrid.length; row++) {
      for (int col = 0; col < gameGrid[col].length; col++) {

        getStylesheets().add(getClass().getResource("/css/wordle.css").toExternalForm());
        Label label = new Label("");
        label.getStyleClass().add("tile-letter");
        StackPane tilePane = new StackPane();
        tilePane.getStyleClass().add("tile-box");

        // Creates a change listener to watch for changes of the letter on the tile
        StringProperty letterProperty = controller.getModel().getTile(row, col).letterProperty();
        letterProperty.addListener(new ChangeListener<String>() {
          @Override
          public void changed(ObservableValue<? extends String> observable, String oldValue,
                              String newValue) {
            label.setText(newValue);
          }
        });

        // Creates a change listener to watch for changes of the status (color) of the tile
        ObjectProperty statusProperty = controller.getModel().getTile(row, col).statusProperty();
        statusProperty.addListener(new ChangeListener<LetterStatus>() {
          @Override
          public void changed(ObservableValue<? extends LetterStatus> observable,
                              LetterStatus oldValue,
                              LetterStatus newValue) {
            if (newValue.equals(LetterStatus.EMPTY)) {
              tilePane.pseudoClassStateChanged(PseudoClass.getPseudoClass("empty"), true);
            } else if (newValue.equals(LetterStatus.UNLOCKED)) {
              tilePane.pseudoClassStateChanged(PseudoClass.getPseudoClass("unlocked"), true);
            } else if (newValue.equals(LetterStatus.WRONG)) {
              tilePane.pseudoClassStateChanged(PseudoClass.getPseudoClass("wrong"), true);
            } else if (newValue.equals(LetterStatus.PRESENT)) {
              tilePane.pseudoClassStateChanged(PseudoClass.getPseudoClass("present"), true);
            } else if (newValue.equals(LetterStatus.CORRECT)) {
              tilePane.pseudoClassStateChanged(PseudoClass.getPseudoClass("correct"), true);
            } else
              tilePane.getStyleClass().add("tile-box");
          }
        });
        //TODO: Add the label to the tilePane
        //TODO: Center the tilePane
        //TODO: Add the tilePane to the grid at position col, row
      }
    }
  }
}
