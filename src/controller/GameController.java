package controller;

import model.GameObject;
import model.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by gy0p4k on 5/21/2017.
 */
public class GameController implements KeyListener {

  Player player;
  int up;
  int down;
  int left;
  int right;
  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;
  boolean bombPressed = false;

  public GameController(Player player, int upKey, int downKey, int leftKey, int rightKey) {
    this.player = player;
    up = upKey;
    down = downKey;
    left = leftKey;
    right = rightKey;

    startTimer();
  }

  private void startTimer() {
    new Timer(100, e -> {
      if(upPressed)
        player.move(0, -1);
      if(downPressed)
        player.move(0, 1);
      if(leftPressed)
        player.move(-1, 0);
      if(rightPressed)
        player.move(1, 0);
      if(bombPressed)
        player.plantBomb();
    }).start();
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if(key == up)
      upPressed = true;
    if(key == down)
      downPressed = true;
    if(key == left)
      leftPressed = true;
    if(key == right)
      rightPressed = true;
    if(key == KeyEvent.VK_E)
      bombPressed = true;
  }

  @Override
  public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();
    if(key == up)
      upPressed = false;
    if(key == down)
      downPressed = false;
    if(key == left)
      leftPressed = false;
    if(key == right)
      rightPressed = false;
    if(key == KeyEvent.VK_E)
      bombPressed = false;
  }
}
