package com.tennis;

public class Point extends ScoreBoard {
  private Player playerWhoStarts;

  public Point(Score playerOneScore, Score playerTwoScore, Player playerWhoStarts) {
    super(playerOneScore, playerTwoScore);
    this.playerWhoStarts = playerWhoStarts;
  }

  public ScoreBoard addPointTo(Player player) {
    ScoreBoard scoreBoard = null;
    int playerOneScore = getPlayerOneScore();
    int playerTwoScore = getPlayerTwoScore();
    int difference = Math.abs(playerOneScore - playerTwoScore);
    if (Math.max(playerTwoScore, playerOneScore) < 3) {
      if (player.getId() == 1) {
        scoreBoard = new Point(Score.values()[playerOneScore + 1], Score.values()[playerTwoScore], playerWhoStarts);
      } else {
        scoreBoard = new Point(Score.values()[playerOneScore], Score.values()[playerTwoScore + 1], playerWhoStarts);
      }
    } else {
      if(difference == 0) {
        scoreBoard = new Advantage(Score.values()[playerOneScore], Score.ADVANTAGE, player);
      } else {
        if((playerOneScore > playerTwoScore)) {
          scoreBoard = getDeuceOrNewGame(player, 1);
        } else {
          scoreBoard = getDeuceOrNewGame(player, 2);
        }
      }
    }
    return scoreBoard;
  }

  private ScoreBoard getDeuceOrNewGame(Player player, int playerId) {
    ScoreBoard scoreBoard;
    if(player.getId() == playerId) {
      scoreBoard = new Point(Score.LOVE, Score.LOVE, player);
    } else {
      scoreBoard = new Deuce(Score.FORTY, Score.FORTY);
    }
    return scoreBoard;
  }
}
