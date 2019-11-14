package com.github.diegopacheco.xunit.testing.bank.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.github.diegopacheco.xunit.testing.bank.model.Account;

public class AccountService {

  public void deposit(Account account, BigDecimal value) {
    if (account == null) {
      throw new RuntimeException("a conta não existe");
    }
    if (value.compareTo(BigDecimal.ZERO) <= 0) {
      throw new RuntimeException("você precisa depositar um valor positivo, idiota");
    }

    BigDecimal balance = account.getBalance();
    balance = balance.add(value);

    account.setBalance(balance);
  }
}
