package com.tennis;

public class Point extends ScoreBoard {

  public Point(Score playerOneScore, Score playerTwoScore) {
    super(playerOneScore, playerTwoScore);
  }

  public ScoreBoard addPointTo(Player player) {
    ScoreBoard scoreBoard = null;
    int playerOneScore = getPlayerOneScore();
    int playerTwoScore = getPlayerTwoScore();
    int difference = Math.abs(playerOneScore - playerTwoScore);
    if (Math.max(playerTwoScore, playerOneScore) < 3) {
      if (player.getId() == 1) {
        scoreBoard = new Point(Score.values()[playerOneScore + 1], Score.values()[playerTwoScore]);
      } else {
        scoreBoard = new Point(Score.values()[playerOneScore], Score.values()[playerTwoScore + 1]);
      }
    }
    return scoreBoard;
  }
}
