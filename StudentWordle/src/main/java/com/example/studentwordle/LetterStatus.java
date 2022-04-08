package com.example.studentwordle;

//TODO: Learn what enums are used for

/**
 *  Represents the statuses that can be used to represent the state of the Tiles on the TileBoard
 *  when the current guess is checked.
 */
public enum LetterStatus {

  /**
   * Hasn't yet been played
   * Gray, no letter, no border
   */
  EMPTY,

  /**
   * Played and waiting to be processed
   * White, has a letter, black border
   */
  UNLOCKED,

  /**
   * Played and the letter is not in the target word
   * Gray, has a letter
   */
  WRONG,

  /**
   * Played and is present in guess but in a different location
   * Yellow, has a letter
   */
  PRESENT,

  /**
   * Played and it is correct and in the right location.
   * Green, has a letter
   */
  CORRECT;
}
