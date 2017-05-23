package controller;

import model.GameObject;
import model.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by gy0p4k on 5/21/2017.
 */
public class GameController implements KeyListener {

  Player player;
  int playerId;
  int up;
  int down;
  int left;
  int right;

  public GameController(Player player, int playerId){
    this.player = player;
    if(playerId == 0){
      up = KeyEvent.VK_W;
      down = KeyEvent.VK_S;
      left = KeyEvent.VK_A;
      right = KeyEvent.VK_D;
    }else{
      up = KeyEvent.VK_I;
      down = KeyEvent.VK_K;
      left = KeyEvent.VK_J;
      right = KeyEvent.VK_L;
    }

  }

  @Override
  public void keyTyped(KeyEvent e) {


  }

  @Override
  public void keyPressed(KeyEvent e) {
    if(e.getKeyCode()== up)
      player.move(0, -1);
    else if(e.getKeyCode()== down)
      player.move(0, 1);
    else if(e.getKeyCode()== left)
      player.move(-1, 0);
    else if(e.getKeyCode()== right)
      player.move(1, 0);
    else if(e.getKeyCode()== KeyEvent.VK_E)
      player.plantBomb();


  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}
