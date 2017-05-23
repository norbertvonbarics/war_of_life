package model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by gy0p4k on 5/21/2017.
 */
public class Player extends GameObject {
  ArrayList<GameObject> fields;
  int score = 0;
  int hp;
  int originalX;
  int originalY;
  String name;


  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public Player(int x, int y, ArrayList<GameObject> fields, String name) {
    super(x, y);
    hp = 10;
    this.name = name;
    originalX = x;
    originalY = y;
    this.color = new Color((int) (Math.random() * 0x1000000));
    this.fields = fields;
  }

  public void moveUp() {
    GameObject field = new GameObject(x, y - 1);
    for (GameObject temp : fields) {
      if (field.isTheSamePlace(temp)) {
        y--;
        break;
      }
    }
  }

  public void moveDown() {
    GameObject field = new GameObject(x, y + 1);
    for (GameObject temp : fields) {
      if (field.isTheSamePlace(temp)) {
        y++;
        break;
      }
    }
  }

  public void moveLeft() {
    GameObject field = new GameObject(x - 1, y);
    for (GameObject temp : fields) {
      if (field.isTheSamePlace(temp)) {
        x--;
        break;
      }
    }
  }

  public void moveRight() {
    GameObject field = new GameObject(x + 1, y);
    for (GameObject temp : fields) {
      if (field.isTheSamePlace(temp)) {
        x++;
        break;
      }
    }
  }

  public boolean isSamePlaceThanAnyCell() {
    for (GameObject temp : fields) {
      if (this.isTheSamePlace(temp) && temp instanceof Cell && ((Cell) temp).isAlive() ) return true;
    }
    return false;
  }

  public void starterPosition() {
    x = originalX;
    y = originalY;
  }
  public String toString(){
    return name + " " + score + " / " + hp;
  }

}
