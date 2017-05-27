package model;

import java.util.ArrayList;


public class SafeZone {
  ArrayList<GameObject> fields;

  public ArrayList<GameObject> getFields() {
    return fields;
  }

  public SafeZone(int x, int y){
    fields = new ArrayList<>();
    fields.add(new GameObject(x-1, y-1));
    fields.add(new GameObject(x-1, y));
    fields.add(new GameObject(x-1, y+1));
    fields.add(new GameObject(x, y-1));
    fields.add(new GameObject(x, y));
    fields.add(new GameObject(x, y+1));
    fields.add(new GameObject(x+1, y-1));
    fields.add(new GameObject(x+1, y));
    fields.add(new GameObject(x+1, y+1));
  }
}
