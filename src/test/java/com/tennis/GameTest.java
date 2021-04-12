package com.tennis;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GameTest {
  private Game game;

  @Before
  public void setUp() {
    game = new Game(new Player(1, "player1"), new Player(2, "player2"));
  }

  @Test
  public void shouldStartTheGameWithLoveLove() {
    Assertions.assertThat(game.getScoreBoard())
        .isEqualToComparingFieldByField(new Point(Score.LOVE, Score.LOVE));
  }

  @Test
  public void shouldIncrementThePlayerOneScoreIfPlayerOneWins() {
    Assertions.assertThat(game.playerOneGetAPoint()).isEqualToComparingFieldByField(new Point(Score.FIFTEEN, Score.LOVE));
  }

  @Test
  public void shouldIncrementThePlayerTwoScoreIfPlayerTwoWins() {
    Assertions.assertThat(game.playerTwoGetAPoint()).isEqualToComparingFieldByField(new Point(Score.LOVE, Score.FIFTEEN));
  }

  @Test
  public void shouldIncrementThePlayerOneScoreAndPlayerTwoScoreIfPlayerOneAndTwoWinsOneGameEach() {
    Assertions.assertThat(game.playerOneGetAPoint()).isEqualToComparingFieldByField(new Point(Score.FIFTEEN, Score.LOVE));
    Assertions.assertThat(game.playerTwoGetAPoint()).isEqualToComparingFieldByField(new Point(Score.FIFTEEN, Score.FIFTEEN));
  }
}
