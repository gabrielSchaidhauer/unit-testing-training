package com.github.diegopacheco.xunit.testing.bank.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class AccountTest {

  @Test
  void shouldHaveBalanceGreaterThanZeroWithNegativeInput() {
    Account account = new Account();
    account.setBalance(new BigDecimal(-10));
    assertTrue(account.getBalance().doubleValue() >= 0);
  }
  
  @Test
  void shouldHaveBalanceGreaterThanZeroWithPositiveInput() {
    Account account = new Account();
    account.setBalance(new BigDecimal(10));
    assertTrue(account.getBalance().doubleValue()>=0);
  }
  
  @Test
  void shouldHaveBalanceGreaterThanZeroWithzeroInput() {
    Account account = new Account();
    account.setBalance(new BigDecimal(0));
    assertTrue(account.getBalance().doubleValue()>=0);
  }
  
  @Test
  void shouldHaveBalanceWithCorrectValue() {
	 
    Account account = new Account();
    account.setBalance(new BigDecimal(1000000.10));
    assertEquals(account.getBalance(),new BigDecimal(1000000.10));
  }
  
  @Test
  void shouldHaveBalanceWithBigValue() {
	 
    Account account = new Account();
    account.setBalance(new BigDecimal(9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999.00));
    assertEquals(account.getBalance(),new BigDecimal(9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999.00));
  }
}

