package com.tennis;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TennisGameTest {
  private TennisGame tennisGame;
  Player player1 = new Player(1, "player1");
  Player player2 = new Player(2, "player2");

  @Before
  public void setUp() {
    tennisGame = new TennisGame(player1, player2, player1);
  }

  @Test
  public void shouldStartTheGameWithLoveLove() {
    Assertions.assertThat(tennisGame.getScoreBoard())
        .isEqualToComparingFieldByField(new Point(Score.LOVE, Score.LOVE, player1));
  }

  @Test
  public void shouldIncrementThePlayerOneScoreIfPlayerOneWins() {
    Assertions.assertThat(tennisGame.playerOneGetAPoint()).isEqualToComparingFieldByField(new Point(Score.FIFTEEN, Score.LOVE, player1));
  }

  @Test
  public void shouldIncrementThePlayerTwoScoreIfPlayerTwoWins() {
    Assertions.assertThat(tennisGame.playerTwoGetAPoint()).isEqualToComparingFieldByField(new Point(Score.LOVE, Score.FIFTEEN, player1));
  }

  @Test
  public void shouldIncrementThePlayerOneScoreAndPlayerTwoScoreIfPlayerOneAndTwoWinsOneGameEach() {
    Assertions.assertThat(tennisGame.playerOneGetAPoint()).isEqualToComparingFieldByField(new Point(Score.FIFTEEN, Score.LOVE, player1));
    Assertions.assertThat(tennisGame.playerTwoGetAPoint()).isEqualToComparingFieldByField(new Point(Score.FIFTEEN, Score.FIFTEEN, player1));
  }

  @Test
  public void shouldGetADeuseIfPlayerOneScoresFortyAndPlayerTwoAlsoScoresForty() {
    tennisGame.playerOneGetAPoint();
    tennisGame.playerTwoGetAPoint();
    tennisGame.playerOneGetAPoint();
    tennisGame.playerTwoGetAPoint();
    tennisGame.playerOneGetAPoint();
    Assertions.assertThat(tennisGame.playerTwoGetAPoint()).isEqualToComparingFieldByField(new Deuce(Score.FORTY, Score.FORTY));
  }

  @Test
  public void playerOneShouldGetAnAdvantageIfThereIsAlreadyADuceAndPlayerOneScores() {
    //Given - Deuce
    tennisGame.playerOneGetAPoint();
    tennisGame.playerTwoGetAPoint();
    tennisGame.playerOneGetAPoint();
    tennisGame.playerTwoGetAPoint();
    tennisGame.playerOneGetAPoint();
    tennisGame.playerTwoGetAPoint();
    //When -then
    Assertions.assertThat(tennisGame.playerOneGetAPoint()).isEqualToComparingFieldByField(new Advantage(Score.ADVANTAGE, Score.FORTY, player1));
  }

  @Test
  public void shouldGetDeuceIfPlayerOneIsInAdvantageAndPlayerTwoScores() {
    //Given - player1 in Advantage
    tennisGame.playerOneGetAPoint();
    tennisGame.playerTwoGetAPoint();
    tennisGame.playerOneGetAPoint();
    tennisGame.playerTwoGetAPoint();
    tennisGame.playerOneGetAPoint();
    tennisGame.playerTwoGetAPoint();
    tennisGame.playerOneGetAPoint();
    //When -then
    Assertions.assertThat(tennisGame.playerTwoGetAPoint()).isEqualToComparingFieldByField(new Deuce(Score.FORTY, Score.FORTY));
  }

  @Test
  public void playerOneShouldWinTheGameAndNewGameShouldStartIfPlayerOneIsInAdvantageAndHeScoresAgain() {
    //Given - player1 in Advantage
    tennisGame.playerOneGetAPoint();
    tennisGame.playerTwoGetAPoint();
    tennisGame.playerOneGetAPoint();
    tennisGame.playerTwoGetAPoint();
    tennisGame.playerOneGetAPoint();
    tennisGame.playerTwoGetAPoint();
    tennisGame.playerOneGetAPoint();
    //When -then
    Assertions.assertThat(tennisGame.playerOneGetAPoint()).isEqualToComparingFieldByField(new Point(Score.LOVE, Score.LOVE, player1));
  }
}
