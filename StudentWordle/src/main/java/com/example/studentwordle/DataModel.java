package com.example.studentwordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the word bank, the list of allowable guesses, and the word of the day.
 */
public class DataModel {

  /**
   * Two ArrayLists of Strings are used to store the word bank and all the words that are valid
   * guesses. A String is used to store the word of the day.
   */
  private ArrayList<String> wordBank;
  private ArrayList<String> validGuesses;
  private String wordOfDay;
  /**
   * Creates a new DataModel by calling methods to read in words from two text files. Stores the
   * those words in wordBank and validGuesses. The wordOfDay should be randomly chosen from the
   * wordBank.
   */
  public DataModel(){
    wordBank = new ArrayList<String>();
    populateList(wordBank, "/data/ny-times-wordlist.txt");
    validGuesses = new ArrayList<String>();
    populateList(validGuesses, "/data/allowed-guesses.txt");
    //TODO: make wordOfDay call a method that will choose a word
    wordOfDay = "EAGLE";
  }
  /**
   * Reads in words from a given text file and stores those words in a given list.
   * @param fileName The name of the file to read from.
   * @param list     The list to store the words in.
   */
  public void populateList(ArrayList<String> list, String fileName){
    try {
      Scanner scan = new Scanner(new File(fileName));
      //TODO: Fill the selected list with all of the items from the file
      //TODO: Ensure that each item is in all uppercase.
      wordBank.add("EAGLE");
      validGuesses.add("HOUSE");
      scan.close();
    } catch (FileNotFoundException e) {
        //TODO: Alert the user that there is something wrong with their file.
    }
  }
  /**
   * Private method for DataModel only to use to select a random word from the wordBank.
   * @return the wordOfDay for the user to guess
   */
  private String selectWord(){
    //TODO: Choose a random word from the list
    return "HELLO";
  }
  /**
   * Gets the word of the day.
   * @return the wordOfDay for the user to guess
   */
  public String getWordOfDay() {
    return wordOfDay;
  }
  /**
   * Gets the word bank.
   * @return the list containing the word bank.
   */
  public ArrayList<String> getWordBank(){
    return wordBank;
  }
  /**
   * Gets the list of valid guesses.
   * @return the list containing valid guesses.
   */
  public ArrayList<String> getValidGuesses(){
    return validGuesses;
  }

////////// TODO ////////////////////////////////////////////////////////////////////////////////

  /**
   * Sorts the word bank using selection sort.
   */
  public void sortWordBankWithSelectionSort(){
  }
  /**
   * Sorts the word bank using insertion sort.
   */
  public void sortWordBankWithInsertionSort(){
  }
  /**
   * Sorts the word bank using the built-in sort.
   */
  public void sortWordBankWithBuiltInSort(){
  }
}

