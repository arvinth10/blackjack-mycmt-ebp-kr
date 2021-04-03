package com.jitterted.ebp.blackjack;

public class Player {

  private int playerBet;
  private int playerBalance;

  public Player() {
    playerBet = 0;
    playerBalance = 0;

  }

  public void playerBets(int betAmount) {
    playerBet = betAmount;
    playerBalance -= betAmount;
  }

  public void playerDeposits(int amount) {
    playerBalance += amount;
  }

  public int playerBalance() {
    return playerBalance;
  }

  public void playerWins() {
    playerBalance += playerBet * 2;
  }

  public void playerLoses() {
    playerBalance += playerBet * 0;
  }

  public void playerTies() {
    playerBalance += playerBet * 1;
  }
}
