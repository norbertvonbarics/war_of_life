package model;

import java.awt.*;
import java.util.ArrayList;

public class Player extends GameObject {
  ArrayList<GameObject> fields;


  public Player(int x, int y, ArrayList<GameObject> fields){
    super(x,y);
    this.color = new Color((int)(Math.random() * 0x1000000));
    this.fields = fields;
  }

  public  void moveUp() {
    GameObject field = new GameObject(x,y-1);
    for(GameObject temp : fields){
      if(field.isTheSamePlace(temp)){
        y--;
        break;
      }
    }
  }

  public  void moveDown() {
    GameObject field = new GameObject(x,y+1);
    for(GameObject temp : fields){
      if(field.isTheSamePlace(temp)) {
        y++;
        break;
      }
    }
  }

  public  void moveLeft() {
    GameObject field = new GameObject(x-1,y);
    for(GameObject temp : fields){
      if(field.isTheSamePlace(temp)) {
        x--;
        break;
      }
    }
  }

  public  void moveRight() {
    GameObject field = new GameObject(x+1,y);
    for(GameObject temp : fields){
      if(field.isTheSamePlace(temp)) {
        x++;
        break;
      }
    }
  }
}
