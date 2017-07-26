
import model.GameObject;
import model.Map;
import model.Player;
import model.SafeZone;
import view.Board;
import javax.swing.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class GameEngine {

  ArrayList<GameObject> gameObjects;
  Map map;
  int x;
  int y;
  double prob;
  ArrayList<Player> players = new ArrayList<>();
  Board board;
  SafeZone safeZoneUp;
  SafeZone safeZoneDown;
  String gametype;
  Player p1;
  Player p2;
  int nextCycleCounter = 0;

  public GameEngine(int x, int y, double prob) throws InterruptedException {
    gameObjects = new ArrayList<>();
    this.x = x;
    this.y = y;
    this.prob = prob;
    map = new Map(x, y, prob);
    gameObjects.addAll(map.getCells());
    gametype = "occupy";

    safeZoneDown = new SafeZone(12, 26);
    safeZoneUp = new SafeZone(12, -2);
    gameObjects.addAll(safeZoneUp.getFields());
    gameObjects.addAll(safeZoneDown.getFields());

    p1 = new Player(12, 26, gameObjects, "p1", map);
    p2 = new Player(12, -2, gameObjects, "p2", map);
    players.add(p1);
    players.add(p2);
    gameObjects.addAll(players);

    board = new Board(gameObjects);
    board.frameInit();
  }


  public void start() throws InterruptedException {
    Timer timer = new Timer(100, null);
    timer.addActionListener(e -> {
          if (nextCycleCounter > 9) {
            map.nextLifeCycle();
            nextCycleCounter = 0;
          } else {
            nextCycleCounter++;
          }
          board.frame.repaint();
          checkDead();
          winchecker(gametype);
          if (p1.getHp() <= 0 || p2.getHp() <= 0) {
            timer.stop();
            board.frame.dispatchEvent(new WindowEvent(board.frame, WindowEvent.WINDOW_CLOSING));
          }
        }
    );
    timer.start();
  }

  public void checkDead() {
    for (Player temp : players) {
      if (temp.isSamePlaceThanAnyCell()) {
        temp.setHp(temp.getHp() - 1);
        playerReturner();
        map.randomize();
      }
    }
  }

  public void playerReturner() {
    for (Player temp : players) {
      temp.starterPosition();
      System.out.println(temp);
    }
  }

  public void winchecker(String gametype) {
    switch (gametype) {
      case "occupy":
        occupyChecker(p1, safeZoneUp);
        occupyChecker(p2, safeZoneDown);
        break;

      case "":
        break;

      default:
        throw new IllegalArgumentException("Invalid gametype: " + gametype);
    }
  }


  public void occupyChecker(Player p, SafeZone safeZone) {
    for (GameObject temp : safeZone.getFields()) {
      if (temp.isTheSamePlace(p)) {
        p.setScore(p.getScore() + 1);
        playerReturner();
        map.randomize();
      }
    }
  }
}

