package com.tennis;

public class TennisGame {

  private Player playerOne;
  private Player playerTwo;
  private Player playerWhoStarts;
  private ScoreBoard scoreBoard;

  public TennisGame(Player playerOne, Player playerTwo, Player playerWhoStarts) {
    this.playerOne = playerOne;
    this.playerTwo = playerTwo;
    this.playerWhoStarts = playerWhoStarts;
    this.scoreBoard = new Point(Score.LOVE, Score.LOVE, playerWhoStarts);
  }

  public ScoreBoard playerOneGetAPoint() {
    scoreBoard = scoreBoard.addPointTo(playerOne);
    return scoreBoard;
  }

  public ScoreBoard playerTwoGetAPoint() {
    scoreBoard = scoreBoard.addPointTo(playerTwo);
    return scoreBoard;
  }

  public ScoreBoard getScoreBoard() {
    return scoreBoard;
  }
}
