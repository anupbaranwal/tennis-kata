package com.tennis;

import lombok.Data;

@Data
public class Player {

  private int id;
  private String name;
  private int score;

  public Player() {}

  public Player(int id, String name) {
    this.id = id;
    this.name = name;
  }
}
