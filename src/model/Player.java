package model;

import java.awt.*;
import java.util.ArrayList;

public class Player extends GameObject {

  ArrayList<GameObject> fields;
  int score = 0;
  int hp;
  int originalX;
  int originalY;
  String name;
  Bomb bomb;


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

  public Player(int x, int y, ArrayList<GameObject> fields, String name, Map map) {
    super(x, y);
    hp = 10;
    bomb = new Bomb(map);
    this.name = name;
    originalX = x;
    originalY = y;
    this.color = new Color((int) (Math.random() * 0x1000000));
    this.fields = fields;


  }

  public void move(int dirX, int dirY) {
    GameObject field = new GameObject(x + dirX, y + dirY);
    for (GameObject temp : fields) {
      if (field.isTheSamePlace(temp)) {
        x += dirX;
        y += dirY;
        break;
      }
    }
  }

  public void plantBomb() {

    bomb.plantBomb(x, y);
  }

  public boolean isSamePlaceThanAnyCell() {
    for (GameObject temp : fields) {
      if (this.isTheSamePlace(temp) && temp instanceof Cell && ((Cell) temp).isAlive()) {
        return true;
      }
    }
    return false;
  }

  public void starterPosition() {
    x = originalX;
    y = originalY;
  }

  public String toString() {
    return name + " " + score + " / " + hp;
  }
}
