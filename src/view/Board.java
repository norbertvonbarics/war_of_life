package view;

import model.Map;
import view.PositionedImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent {

  int testBoxX;
  int testBoxY;
  JFrame frame;
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

  public void frameInit(Board board) {
    frame = new JFrame("War of Life");
    frame.add(board);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.pack();
  }


}