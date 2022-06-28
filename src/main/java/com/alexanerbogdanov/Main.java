package com.alexanerbogdanov;

import com.alexanerbogdanov.db.AccountRepository;
import com.alexanerbogdanov.db.impl.PostgresAccountRepository;
import com.alexanerbogdanov.entity.AccountEntity;

import javax.swing.*;

public class Main {
  static AccountRepository accountRepository = new PostgresAccountRepository();

  public static void main(String[] args) {
    String accountName = JOptionPane.showInputDialog("Please enter your name");

    AccountEntity workAccount = accountRepository.getByName(accountName);
    if (workAccount == null) {
      int balance = Integer.parseInt(JOptionPane.showInputDialog("enter yo balance"));

      AccountEntity account = new AccountEntity()
              .setName(accountName)
              .setValue(balance);

      accountRepository.addAccount(account);
    }

  }

}