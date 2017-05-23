package view;

import controller.GameController;
import model.Cell;
import model.GameObject;
import model.Map;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Board extends JComponent {

  public JFrame frame;
  Map map;
  int border = 150;
  ArrayList<Player> playerList;
  ArrayList<GameObject> gameObjects;
  int size = 50;
  JLabel player1;
  JLabel player2;
  GameController cont1;
  GameController cont2;


  public Board(ArrayList<GameObject> gameObjects) {
    playerList = new ArrayList<>();
    this.gameObjects = gameObjects;
    for (GameObject temp : gameObjects) {
      if (temp instanceof Player) {
        playerList.add((Player) temp);
      }
    }

    setFocusable(true);
    requestFocusInWindow();
    player1 = new JLabel("test");
    player1.setAlignmentX(1200);
    player1.setAlignmentY(1200);

    cont1 = new GameController(playerList.get(0), 0);
    cont2 = new GameController(playerList.get(1), 1);
    addKeyListener(cont1);
    addKeyListener(cont2);
    setPreferredSize(new Dimension(1600, 1600));

    setVisible(true);
    this.map = map;
  }


  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    graphics.setColor(Color.black);

    for (GameObject temp : gameObjects) {
      player1.setText("asd");
      graphics.setColor(temp.getColor());
      if (temp instanceof Cell) {
        if (((Cell) temp).isAlive()) {
          graphics.fillRect(temp.getX() * size + border, temp.getY() * size + border, size, size);
        } else {
          graphics.drawRect(temp.getX() * size + border, temp.getY() * size + border, size, size);
        }
      } else if (temp instanceof Player) {
        graphics.fillRect(temp.getX() * size + border, temp.getY() * size + border, size, size);
      } else {
        graphics.drawRect(temp.getX() * size + border, temp.getY() * size + border, size, size);
      }
    }
  }

  public void frameInit() {
    frame = new JFrame("War of Life");
    frame.add(this);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.pack();
  }
}













