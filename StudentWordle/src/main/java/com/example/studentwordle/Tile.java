package com.example.studentwordle;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Represents the Tile object that is used to display the letter and status at each played position.
 */
public class Tile {
  /**
   * The StringProperty and ObjectProperty data types allow for these values
   * to be observed elsewhere using a listener without having to pass them around. That's pretty
   * cool!
   */
  private StringProperty letter;
  private ObjectProperty<LetterStatus> status;

  /**
   * Creates a new Tile object with default values for its letter and status (color).
   */
  public Tile() {
    letter = new SimpleStringProperty(" ");
    status = new SimpleObjectProperty<LetterStatus>(LetterStatus.EMPTY);
  }
  /**
   * Gets the letter of the Tile.
   * @return the Tile's letter
   */
  public String getLetter() {
    return letter.get();
  }
  /**
   * Sets a new letter to the Tile.
   * @param newLetter
   */
  public void setLetter(String newLetter) {
    letter.setValue(newLetter);
  }
  /**
   * Gets the StringProperty for the Tile's letter. This is an observable value that
   * will be watched elsewhere using a listener.
   * @return the StringProperty of the Tile's letter
   */
  public StringProperty letterProperty() {
    return letter;
  }
  /**
   * Gets the status of the Tile.
   * @return the Tile's status (color)
   */
  public LetterStatus getStatus() {
    return status.get();
  }
  /**
   * Sets a new status to the Tile (changes the tile's color).
   * @param newStatus
   */
  public void setStatus(LetterStatus newStatus) {
    status.setValue(newStatus);
  }
  /**
   * Gets the ObjectProperty for the Tile's status. This is an observable value that
   * will be watched elsewhere.
   * @return the ObjectProperty of the Tile's status
   */
  public ObjectProperty statusProperty() {
    return status;
  }
}

