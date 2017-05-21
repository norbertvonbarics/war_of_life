package model;

/**
 * Created by gy0p4k on 5/21/2017.
 */
public class Player {
  private int x;
  private int y;
  private static int id = 0;

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Player(int x, int y){
    this.x = x;
    this.y = y;
    id++;
  }

}
