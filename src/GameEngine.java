import controller.GameController;
import model.GameObject;
import model.Map;
import model.Player;
import model.SafeZone;
import view.Board;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by gy0p4k on 5/21/2017.
 */
public class GameEngine  {
  ArrayList<GameObject> gameObjects;
  Map map;
  int x;
  int y;
  double prob;
  ArrayList<Player> players= new ArrayList<>();
  Board board;
  SafeZone safeZoneUp;
  SafeZone safeZoneDown;



  public GameEngine(int x, int y,double prob) throws InterruptedException {
    gameObjects = new ArrayList<>();
    this.x = x;
    this.y = y;
    this.prob = prob;
    map = new Map(x,y, prob);
    gameObjects.addAll(map.getCells());

    safeZoneUp = new SafeZone(12,26);
    gameObjects.addAll(safeZoneUp.getFields());
    safeZoneDown = new SafeZone(12,-2);
    gameObjects.addAll(safeZoneDown.getFields());

    Player p1 = new Player(12,26, gameObjects, "p1");
    Player p2 = new Player(12,-2, gameObjects, "p2");
    players.add(p1);
    players.add(p2);
    gameObjects.addAll(players);

    board = new Board(gameObjects);
    board.frameInit();

  }



  public void start() throws InterruptedException {


    //board.run();
    while(true){
      map.nextLifeCycle();
      Thread.sleep(100);
      board.frame.repaint();
      checkDead();
      Thread.sleep(100);
    }
  }

  public void checkDead() throws InterruptedException {
    for(Player temp : players){
        if(temp.isSamePlaceThanAnyCell()){
          temp.setHp( temp.getHp() - 1);
          playerReturner();
          map.randomize();
        }
      }

  }

  public void playerReturner(){
    for(Player temp : players){

        temp.starterPosition();

    }
  }

}
