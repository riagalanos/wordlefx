package com.example.studentwordle;

/**
 * Represents the 2D grid of tiles.
 */
public class GridModel {
  /**
   * A 2D array of Tile objects is created using two constants representing the number of rows
   * and cols.
   */
  private Tile[][] gameGrid;
  private final int NUM_ROWS = 6;
  private final int NUM_COLS = 5;
  /**
   * Creates and fills the gameGrid.
   */
  public GridModel() {
    gameGrid = new Tile[NUM_ROWS][NUM_COLS];
    fillGameGrid();
  }
  /**
   * Fills each location of the gameGrid with a Tile object.
   */
  public void fillGameGrid() {
    //TODO: Fill the entire board with empty Tiles.
    gameGrid[2][3] = new Tile();
  }
  /**
   * Changes the Tile at the given row and col with the new letter and the new status.
   * @param row The row the tile is in.
   * @param col The col the tile is in.
   * @param newLetter The letter the tile should display.
   * @param newStatus The status (color) the tile should display.
   */
  public void setTile(int row, int col, String newLetter, LetterStatus newStatus) {
    gameGrid[row][col].setLetter(newLetter);
    gameGrid[row][col].setStatus(newStatus);
  }
  /**
   * Gets the Tile at the given location of the gameGrid.
   * @return a Tile object
   */
  public Tile getTile(int row, int col) {
    return gameGrid[row][col];
  }
  /**
   * Gets the entire gameGrid of Tile objects.
   * @return a 2D array of Tile objects.
   */
  public Tile[][] getGrid() {
    return gameGrid;
  }
}
