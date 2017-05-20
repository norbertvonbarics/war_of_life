package model;

/**
 * Created by gy0p4k on 5/20/2017.
 */
public class Cell {
  private int x;
  private int y;
  private boolean isAlive;

  public Cell(int x, int y){
    this.x = x;
    this.y = y;
    this.isAlive = false;
  }

  public Cell(int x, int y, boolean isAlive) {
    this.x = x;
    this.y = y;
    this.isAlive = isAlive;
  }

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

  public boolean isAlive() {
    return isAlive;
  }

  public void setAlive(boolean alive) {
    isAlive = alive;
  }

  public String toString(){
    return isAlive ? "X" : " ";
  }

}
