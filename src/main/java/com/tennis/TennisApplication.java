package com.tennis;

public class TennisApplication {

  public static void main(String[] args) {
    Game game = new Game(new Player(1, "player1"), new Player(2, "player2"));
    ScoreBoard scoreBoard = game.playerOneGetAPoint();
    scoreBoard = game.playerOneGetAPoint();
    scoreBoard = game.playerTwoGetAPoint();
    System.out.println(scoreBoard);
  }
}
