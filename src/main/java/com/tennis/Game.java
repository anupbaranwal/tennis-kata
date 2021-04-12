package com.tennis;

public class Game {

  private Player playerOne;
  private Player playerTwo;
  private ScoreBoard scoreBoard;

  public Game(Player playerOne, Player playerTwo) {
    this.playerOne = playerOne;
    this.playerTwo = playerTwo;
    this.scoreBoard = new Point(Score.LOVE, Score.LOVE);
  }

  public Game(ScoreBoard score) {
    this.scoreBoard = score;
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
