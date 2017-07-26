package view;

import controller.GameController;
import model.Cell;
import model.GameObject;
import model.Map;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Board extends JComponent {

  public JFrame frame;
  Map map;
  int border = 150;
  ArrayList<Player> playerList;
  ArrayList<GameObject> gameObjects;
  int size = 20;
  JLabel player1;
  JLabel player2;
  GameController cont1;
  GameController cont2;


  public Board(ArrayList<GameObject> gameObjects) {
    playerList = new ArrayList<>();
    this.gameObjects = gameObjects;
    for (GameObject gameObject : gameObjects) {
      if (gameObject instanceof Player) {
        playerList.add((Player) gameObject);
      }
    }

    setFocusable(true);
    requestFocusInWindow();
    player1 = new JLabel("test");
    player1.setAlignmentX(1200);
    player1.setAlignmentY(1200);

    cont1 = new GameController(playerList.get(0), KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_E);
    cont2 = new GameController(playerList.get(1), KeyEvent.VK_I, KeyEvent.VK_K, KeyEvent.VK_J, KeyEvent.VK_L, KeyEvent.VK_O);
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

    for (GameObject gameObject : gameObjects) {
      player1.setText("asd");
      graphics.setColor(gameObject.getColor());
      if (gameObject instanceof Cell) {
        if (((Cell) gameObject).isAlive()) {
          graphics.fillRect(gameObject.getX() * size + border, gameObject.getY() * size + border, size, size);
        } else if(((Cell) gameObject).isNextCycleWillAlive()) {
//          graphics.setColor(Color.GRAY);
//          graphics.fillRect(gameObject.getX() * size + border, gameObject.getY() * size + border, size, size);
        }else{
//          graphics.setColor(Color.BLACK);
//          graphics.drawRect(gameObject.getX() * size + border, gameObject.getY() * size + border, size, size);
        }
      } else if (gameObject instanceof Player) {
        graphics.fillRect(gameObject.getX() * size + border, gameObject.getY() * size + border, size, size);
      } else {
        graphics.drawRect(gameObject.getX() * size + border, gameObject.getY() * size + border, size, size);
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













