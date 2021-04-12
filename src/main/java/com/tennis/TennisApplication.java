package com.tennis;

public class TennisApplication {

  public static void main(String[] args) {
    Player player1 = new Player(1, "player1");
    Player player2 = new Player(2, "player2");
    TennisGame game = new TennisGame(player1, player2, player1);
    ScoreBoard scoreBoard;
    game.playerOneGetAPoint();
    game.playerOneGetAPoint();
    game.playerTwoGetAPoint();
    game.playerTwoGetAPoint();
    game.playerTwoGetAPoint();
    game.playerOneGetAPoint();
    game.playerTwoGetAPoint();
    scoreBoard = game.playerTwoGetAPoint();
    System.out.println(scoreBoard);
  }
}
