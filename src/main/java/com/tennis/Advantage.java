package com.tennis;

public class Advantage extends ScoreBoard {

  private Player playerWithAdvantage;

  public Advantage(Score playerOneScore, Score playerTwoScore, Player playerWithAdvantage) {
    super(playerOneScore, playerTwoScore);
    this.playerWithAdvantage = playerWithAdvantage;
  }

  @Override
  public ScoreBoard addPointTo(Player player) {
    ScoreBoard scoreBoard = null;
    if (player.getId() == this.playerWithAdvantage.getId()) {
      System.out.println(player.getName() + " Won the Game !!");
      scoreBoard = new Point(Score.LOVE, Score.LOVE, this.playerWithAdvantage);
    } else {
      System.out.println("Deuce...");
      scoreBoard = new Deuce(Score.FORTY, Score.FORTY);
    }
    return scoreBoard;
  }

}
