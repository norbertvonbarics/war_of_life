package model;

import java.util.ArrayList;

public class Map {
  private ArrayList<ArrayList<Cell>> cells;
  private int row;
  private int col;

  public ArrayList<Cell> getCells() {
    ArrayList<Cell> cellList = new ArrayList<>();
    for(ArrayList<Cell> tempList : cells){
      for(Cell tempCell : tempList){
        cellList.add(tempCell);
      }
    }
    return cellList;
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  public Map(int row, int col, double probability) {
    this.row = row;
    this.col = col;
    cells = new ArrayList<ArrayList<Cell>>();
    ArrayList<Cell> temp;
    for (int i = 0; i < col; i++) {
      temp = new ArrayList<>();
      for (int j = 0; j < row; j++) {
        temp.add(new Cell(j, i, Math.random() < probability));
      }
      cells.add(temp);
    }

  }

  public boolean isAlive(int x, int y) {
    return cells.get(y).get(x).isAlive();
  }

  public int neighbourAliveCount(int x, int y) {
    int counter = 0;
    for (int i = x - 1; i < x + 2; i++) {
      for (int j = y - 1; j < y + 2; j++) {
        try {
          if (!(i == x && j == y) && isAlive(i, j)) counter++;
        } catch (IndexOutOfBoundsException e) {
        }
      }

    }
    return counter;
  }

  public void nextLifeCycle() {
    for (ArrayList<Cell> tempList : cells) {
      for (Cell tempCell : tempList) {
        int a = neighbourAliveCount(tempCell.getX(), tempCell.getY());
        if (a > 3 || a < 2) {
          tempCell.setNextCycleWillAlive(false);
        } else if (a == 3) {
          tempCell.setNextCycleWillAlive(true);
        } else {
          tempCell.setNextCycleWillAlive(tempCell.isAlive());
        }
      }
    }

    for (ArrayList<Cell> tempList : cells) {
      for (Cell tempCell : tempList) {
        tempCell.setAlive(tempCell.isNextCycleWillAlive());
      }
    }
  }
}


