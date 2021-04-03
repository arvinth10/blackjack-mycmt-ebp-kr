package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

  // Player Ties = get Bet back
  // Player BJ = Bet + Bet + 50% Bet

  @Test
  public void playerWith5Bets5WhenWinsBalancesIs10() throws Exception {
    Player player = new Player();
    player.playerDeposits(5);
    player.playerBets(5);
    player.playerWins();
    assertThat(player.playerBalance()).isEqualTo(10);
  }


  @Test
  public void playerWith35Bets30WhenLosesBalanceIs5() throws Exception {
    Player player = new Player();
    player.playerDeposits(35);
    player.playerBets(30);
    player.playerLoses();
    assertThat(player.playerBalance()).isEqualTo(5);
  }

  @Test
  public void playerWith80Bets70WhenTiesBalanceIs80() throws Exception {
    Player player = new Player();
    player.playerDeposits(80);
    player.playerBets(70);
    player.playerTies();
    assertThat(player.playerBalance()).isEqualTo(80);
  }

  @Test
  public void playerWith40Bets15BalanceIs25() throws Exception {
    Player player = new Player();
    player.playerDeposits(40);
    player.playerBets(15);
    assertThat(player.playerBalance()).isEqualTo(25);
  }

  @Test
  public void playerDeposits18DollarsBalanceIs18Dollars() throws Exception {
    Player player = new Player();
    player.playerDeposits(18);
    assertThat(player.playerBalance()).isEqualTo(18);
  }

  @Test
  void playerBets10TwiceWinsTotalBetAmountIs20() {
    Player player = new Player();
    player.playerDeposits(10);
    player.playerBets(10);
    player.playerWins();
    player.playerBets(10);
    player.playerWins();
    assertThat(player.totalAmountBet()).isEqualTo(20);
  }

  @Test
  void playerBets20OnceTotalBetAmountIs20() {
    Player player = new Player();
    player.playerDeposits(100);
    player.playerBets(20);
    assertThat(player.totalAmountBet()).isEqualTo(20);
  }

  @Test
  void playerBets10TwiceLosesTotalBetAmountIs20() {
    Player player = new Player();
    player.playerDeposits(20);
    player.playerBets(10);
    player.playerLoses();
    player.playerBets(10);
    player.playerLoses();
    assertThat(player.totalAmountBet()).isEqualTo(20);
  }

  @Test
  void playerBet100Get10Bonus() {
    Player player = new Player();
    player.playerDeposits(100);
    player.playerBets(100);
    assertThat(player.totalAmountBet()).isEqualTo(110);
  }

  @Test
  void playerBet200Get10Bonus() {
    Player player = new Player();
    player.playerDeposits(200);
    player.playerBets(200);
    assertThat(player.totalAmountBet()).isEqualTo(210);
  }

  @Test
  void playerBet200Get10BonusAndWins() {
    Player player = new Player();
    player.playerDeposits(200);
    player.playerBets(200);
    player.playerWins();
    assertThat(player.playerBalance()).isEqualTo(420);
  }


}