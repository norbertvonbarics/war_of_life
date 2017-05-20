package model;

import java.util.ArrayList;

/**
 * Created by gy0p4k on 5/21/2017.
 */
public class Map {
  private ArrayList<ArrayList<Cell>> cells;

  public ArrayList<ArrayList<Cell>> getCells() {
    return cells;
  }

  public Map(int row, int col, double probability){
    cells = new ArrayList<ArrayList<Cell>>();
    ArrayList<Cell> temp;
    for (int i = 0; i < col ; i++) {
      temp = new ArrayList<>();
      for (int j = 0; j < row ; j++) {
        temp.add(new Cell(i, j, Math.random() < probability));
      }
      cells.add(temp);
    }
  }


}
