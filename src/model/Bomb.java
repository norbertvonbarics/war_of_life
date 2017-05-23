package model;

import java.util.ArrayList;

/**
 * Created by gy0p4k on 5/22/2017.
 */
public class Bomb {

  Map map;

  public Bomb(Map map){
    this.map = map;
  }

  public void  plantBomb(int x,int y) {
    for (int i = x - 1; i < x + 2; i++) {
      for (int j = y - 1; j < y + 2; j++) {
        try {
          if (!(i == x && j == y)) map.getCell(i, j).setAlive(true);
        } catch (IndexOutOfBoundsException e) {
        }
      }
    }

  }
}
