package model;

import java.awt.*;

public class Cell extends GameObject {

  private boolean isAlive;
  private boolean nextCycleWillAlive;

  public boolean isNextCycleWillAlive() {
    return nextCycleWillAlive;
  }

  public void setNextCycleWillAlive(boolean nextCycleWillAlive) {
    this.nextCycleWillAlive = nextCycleWillAlive;
  }

  public Cell(int x, int y, boolean isAlive) {
    super(x, y);
    this.isAlive = isAlive;
    this.color = Color.black;
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
