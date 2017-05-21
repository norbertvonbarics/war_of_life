package model;

/**
 * Created by gy0p4k on 5/20/2017.
 */
public class Cell {
  private int x;
  private int y;
  private boolean isAlive;
  private boolean nextCycleWillAlive;

  public boolean isNextCycleWillAlive() {
    return nextCycleWillAlive;
  }

  public void setNextCycleWillAlive(boolean nextCycleWillAlive) {
    this.nextCycleWillAlive = nextCycleWillAlive;
  }

  public Cell(int x, int y, boolean isAlive) {
    this.x = x;
    this.y = y;
    this.isAlive = isAlive;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public boolean isAlive() {
    return isAlive;
  }

  public void setAlive(boolean alive) {
    isAlive = alive;
  }

  public String toString() {
    return isAlive ? "X" : " ";
  }

}
