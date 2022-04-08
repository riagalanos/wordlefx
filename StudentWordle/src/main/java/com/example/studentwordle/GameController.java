package com.example.studentwordle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Represents the GameController that responds to user interactions, makes decisions, and updates
 * the model.
 */
public class GameController {
  /**
   * Represents the GameController that responds to user interactions, makes decisions, and updates
   * the model.
   */
  private GridModel gridModel;
  private DataModel dataModel;
  private int currentCol;
  private int currentRow;
  private String wordOfDay;
  private StringProperty announcement;
  private String wordGuessed;
  private boolean gameOver;
  /**
   * Represents the GameController that responds to user interactions, makes decisions, and updates
   * the model.
   */
  public GameController(GridModel gmod, DataModel dmod) {
    dataModel = dmod;
    gridModel = gmod;
    currentCol = 0;
    currentRow = 0;
    wordOfDay = dmod.getWordOfDay();
    announcement = new SimpleStringProperty("GUESS WORD TO BEGIN GAME");
    gameOver = false;
    wordGuessed = "";
  }
  /**
   * Calls the appropriate method for when the key is equal to "DELETE", "ENTER", or a letter key.
   */
  public void handleKeyPressed (String key) {
    // TODO
  }
  /**
   * If the game is not over, clears the current tile.  Update the model.
   */
  public void clearTile() {
    // TODO
  }
  /**
   * Processes the current letter:
   * If the game is not over and the current column is less than 5, send the model the location,
   * letter, and status for that tile. When they type in all five letters, remind them to press
   * enter to check the word.
   */
  public void processCurrentLetter(String letterPlayed) {
    // TODO
  }
  /**
   * Processes the guessed word:
   * If the game is not over, the guessed word is five letters, and the guessed word is valid,
   * flip the letters according to the rules. If all letters are correct, declare a winner.
   * Otherwise, if they are not on the last row, tell them to Keep Going. If they are on the last
   * row, declare a loss. Let the user know when they hit enter without having typed in 5 letters
   * and whether a guessed word is invalid.
   */
  public void processGuessedWord() {
    if (!gameOver) {
      if (wordGuessed.length() == 5) {
        if (checkIsValid(wordGuessed)) {
          flipLetters();
          if (wordGuessed.equals(dataModel.getWordOfDay())) {
            declareWinner();
          } else {
            if (currentRow < 5) {
              setAnnouncement("KEEP GOING");
              currentRow++;
              currentCol = 0;
              wordGuessed = "";
            } else
              declareLoss();
          }
        } else {
          setAnnouncement("NOT ON WORD LIST");
        }
      } else {
        setAnnouncement("NOT ENOUGH LETTERS");
      }
    }
  }
  /**
   * Flips the letters in the current row:
   *    1. If the guessed letter is equal to a correct letter in the word of the day in that spot,
   *    set the letter's status to be correct.
   *    2. If the guessed letter is present but not in the correct spot, set the letter's status
   *    to be present.
   *    3. If the guessed letter is not present in the word of the day, set the letter's status
   *    to be wrong.
   */
  public void flipLetters() {
    // TODO
  }
  /**
   * Checks if the given word is in either the word bank or the valid guess list.
   * @param guess the last played word
   * @return true if the word appears on one of the two lists
   */
  public boolean checkIsValid(String guess){
    // TODO return appropriate expression
    return false;
  }
  /**
   * If the player guesses the word of the day within 6 tries, finishes the game and
   * announces that the player won.
   */
  public void declareWinner() {
    // TODO: set gameOver and the announcement message accordingly
  }
  /**
   * If the player does not guess the word of the day within 6 tries, finishes the game and
   * announcees that the game is indeed over.
   */
  public void declareLoss(){
    gameOver = true;
    setAnnouncement("YOU LOST ON " + dataModel.getWordOfDay());
  }
  /**
   * Sets a new message for the announcement.
   * @param newMessage
   */
  public void setAnnouncement(String newMessage){
    announcement.setValue(newMessage);
  }
  /**
   * Gets the string with the announcement.
   * @return the annnouncement
   */
  public String getAnnouncement(){
    return announcement.get();
  }
  /**
   * Gets the StringProperty for the announcement. This is an observable value that
   * will be watched elsewhere using a listener.
   * @return the StringProperty of the announcement
   */
  public StringProperty announcementProperty() {
    return announcement;
  }
  /**
   * Get the GridModel.
   * @return a GridModel.
   */
  public GridModel getModel(){
    return gridModel;
  }
}





