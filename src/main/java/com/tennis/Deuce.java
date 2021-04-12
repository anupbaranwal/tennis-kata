package com.tennis;

public class Deuce extends ScoreBoard {

  public Deuce(Score playerOneScore, Score playerTwoScore) {
    super(playerOneScore, playerTwoScore);
  }

  @Override
  public ScoreBoard addPointTo(Player player) {
    if (player.getId() == 1) {
      return new Advantage(Score.ADVANTAGE, Score.FORTY, player);
    } else {
      return new Advantage(Score.FORTY, Score.ADVANTAGE, player);
    }
  }
}
