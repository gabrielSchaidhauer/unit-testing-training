package com.github.diegopacheco.xunit.testing.bank.model;

import java.math.BigDecimal;

public class Account {

  private int number;
  private BigDecimal balance = new BigDecimal(0.00);
  private double trasnferenceFee;

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    if (balance.compareTo(BigDecimal.ZERO) > 0) {
    	this.balance = balance;
    }
  }

  public double getTrasnferenceFee() {
    return trasnferenceFee;
  }

  public void setTrasnferenceFee(double trasnferenceFee) {
    this.trasnferenceFee = trasnferenceFee;
  }
}
