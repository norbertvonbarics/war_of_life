import model.Map;
import model.Player;
import view.Board;

import javax.swing.*;

/**
 * Created by gy0p4k on 5/21/2017.
 */
public class GameEngine  {

  public void start(int x, int y,double prob) throws InterruptedException {
    Map map = new Map(x,y, prob);
    Player player = new Player(1,0);
    Board board = new Board(map, player);

    board.frameInit();
    //board.run();
    while(true){
      map.nextLifeCycle();
      Thread.sleep(100);
      board.frame.repaint();
    }
  }

}
