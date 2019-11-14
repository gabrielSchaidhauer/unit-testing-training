package com.github.diegopacheco.xunit.testing.bank.service;

import com.github.diegopacheco.xunit.testing.bank.model.Account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

public class AccountServiceTest {

  @Test()
  void shouldThowErrorWithNullAccount() {
    AccountService service = new AccountService();
    Account account = new Account();

    assertThrows(
        RuntimeException.class,
        () -> {
          service.deposit(null, new BigDecimal(2500));
        });
  }

  @Test()
  void shouldHaveDepositInAccount() {
    AccountService service = new AccountService();
    Account account = new Account();
    account.setBalance(new BigDecimal(20.01));

    service.deposit(account, new BigDecimal(2500.00));
    assertEquals (new BigDecimal(2520.01).setScale(2, RoundingMode.HALF_EVEN), account.getBalance().setScale(2, RoundingMode.HALF_EVEN));
  }
  
  @Test()
  void shouldThrowErrorWitNegativeValue() {
    AccountService service = new AccountService();
    Account account = new Account();

    assertThrows(
        RuntimeException.class,
        () -> {
          service.deposit(account, new BigDecimal(-2500));
        });
  }
  
  @Test()
  void shouldThrowErrorWitZeroValue() {
    AccountService service = new AccountService();
    Account account = new Account();

    assertThrows(
        RuntimeException.class,
        () -> {
          service.deposit(account, new BigDecimal(0));
        });
  }
  
  @Test()
  void shouldHaveDepositBIgNumberInAccount() {
  
    AccountService service = new AccountService();
    Account account = new Account();
    account.setBalance(new BigDecimal("29999999999999999999999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000009.01"));

    service.deposit(account, new BigDecimal(0.50));
    assertEquals (new BigDecimal("29999999999999999999999999999999999999999999999999999999990000000000000000000000000000000000000000000000000000000000000000009.51").setScale(2, RoundingMode.FLOOR), account.getBalance().setScale(2, RoundingMode.FLOOR));

  }
}
