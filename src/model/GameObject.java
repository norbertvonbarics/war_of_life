package model;

import java.awt.*;

/**
 * Created by gy0p4k on 5/21/2017.
 */
public class GameObject {

  int x;
  int y;
  private static int id = 0;
  Color color;

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

  public GameObject(int x, int y) {
    this.x = x;
    this.y = y;
    id++;
    color = Color.BLUE;
  }

  public boolean isTheSamePlace(GameObject that) {
    return this.x == that.x && this.y == that.y;
  }

  public Color getColor() {
    return color;
  }
}
