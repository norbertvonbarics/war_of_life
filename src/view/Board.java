package view;

import model.Map;

import javax.swing.*;
import java.awt.*;

public class Board extends JComponent implements Runnable {

  int testBoxX;
  int testBoxY;
  public JFrame frame;
  Map map;

  public Board(Map map) {
    setPreferredSize(new Dimension(1400, 1400));
    setVisible(true);
    this.map = map;
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    for (int i = 0; i <map.getCol() ; i++) {
      for (int j = 0; j <map.getRow() ; j++) {
        if(map.isAlive(j,i)) graphics.fillRect(j*50, i*50, 50, 50);
      }
    }

  }

  public void paintEngine() throws InterruptedException {
    while(true) {
      frame.repaint();
      Thread.sleep((long) 100);
    }
  }

  public void frameInit() {
    frame = new JFrame("War of Life");
    frame.add(this);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.pack();
  }


  @Override
  public void run() {
    try {
      paintEngine();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}