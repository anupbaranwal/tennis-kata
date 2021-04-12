package com.tennis;

public class Game extends ScoreBoard {

  private Player winnerPlayer;

  public Game(Score playerOneScore, Score playerTwoScore, Player winnerPlayer) {
    super(playerOneScore, playerTwoScore);
    this.winnerPlayer = winnerPlayer;
  }

  @Override
  public ScoreBoard addPointTo(Player player) {
    return new Advantage(Score.ADVANTAGE, Score.FORTY, player);
  }
}
