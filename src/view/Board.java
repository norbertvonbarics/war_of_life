package view;

import model.Map;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent implements KeyListener {

  public JFrame frame;
  Map map;
  int border = 50;
  Player player;

  public Board(Map map, Player player) {
    this.player = player;
    setPreferredSize(new Dimension(1400, 1400));
    setVisible(true);
    this.map = map;
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    graphics.setColor(Color.black);
    for (int i = 0; i < map.getCol(); i++) {
      for (int j = 0; j < map.getRow(); j++) {
        graphics.drawRect(j * 50+border, i * 50+border, 50, 50);
        if (map.isAlive(j, i)) graphics.fillRect(j * 50+border, i * 50+border, 50, 50);
      }
    }
    graphics.setColor(Color.blue);
    graphics.fillRect(player.getX()*50 + border, player.getY()*50 + border, 50, 50);
  }

  public void frameInit() {
    frame = new JFrame("War of Life");
    frame.add(this);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.pack();
  }


  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    if(e.getKeyChar() == 's') player.setY(player.getY() + 1);
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}