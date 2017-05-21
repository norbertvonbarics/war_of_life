import model.Map;
import view.Board;

import javax.swing.*;

/**
 * Created by gy0p4k on 5/21/2017.
 */
public class GameEngine  {

  public void start(int x, int y,double prob) throws InterruptedException {
    Map map = new Map(x,y, prob);
    Board board = new Board(map);
    board.frameInit();
    //board.run();
    while(true){
      map.nextLifeCycle();
      //Thread.sleep(10);
      board.frame.repaint();
    }
  }

}
