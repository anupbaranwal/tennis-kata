package com.tennis;

public abstract class ScoreBoard {

  private Score playerOneScore;
  private Score playerTwoScore;

  public int getPlayerOneScore() {
    return playerOneScore.getScore();
  }

  public int getPlayerTwoScore() {
    return playerTwoScore.getScore();
  }

  public ScoreBoard(Score playerOneScore, Score playerTwoScore) {
    this.playerOneScore = playerOneScore;
    this.playerTwoScore = playerTwoScore;
  }

  @Override
  public String toString() {
    return "ScoreBoard{" +
        "playerOneScore=" + playerOneScore +
        ", playerTwoScore=" + playerTwoScore +
        '}';
  }

  public abstract ScoreBoard addPointTo(final Player player);
}
