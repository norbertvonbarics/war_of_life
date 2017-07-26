
import model.GameObject;
import model.Map;
import model.Player;
import model.SafeZone;
import view.Board;
import java.util.ArrayList;
public class GameEngine  {

  public void start(int x, int y,double prob) throws InterruptedException {
    ArrayList<GameObject> gameObjects = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();

    Map map = new Map(x,y, prob);
    gameObjects.addAll(map.getCells());

    SafeZone safeZoneUp = new SafeZone(12,26);
    gameObjects.addAll(safeZoneUp.getFields());

    SafeZone safeZoneDown = new SafeZone(12,-2);
    gameObjects.addAll(safeZoneDown.getFields());
    Player p1 = new Player(12,26, gameObjects);
    Player p2 = new Player(12,-2, gameObjects);
    players.add(p1);
    players.add(p2);
    gameObjects.addAll(players);

    Board board = new Board(gameObjects);

    board.frameInit();
    //board.run();
    while(true){
      map.nextLifeCycle();
      Thread.sleep(500);
      board.frame.repaint();
    }
  }

}
