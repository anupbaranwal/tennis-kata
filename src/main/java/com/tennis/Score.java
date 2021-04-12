package com.tennis;

public enum Score {
  LOVE(0),
  FIFTEEN(1),
  THIRTY(2),
  FORTY(3),
  ADVANTAGE(4);

  private final int score;

  Score(int score) {
    this.score = score;
  }

  public int getScore() {
    return score;
  }
}
