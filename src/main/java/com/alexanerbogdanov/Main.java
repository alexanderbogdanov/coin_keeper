package com.alexanerbogdanov;

import com.alexanerbogdanov.db.DataSourceProvider;
import com.alexanerbogdanov.entity.AccountEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    JdbcTemplate template =
            new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());

    String accountName = JOptionPane.showInputDialog("enter yo name");
    int balance = Integer.parseInt(JOptionPane.showInputDialog("enter yo balance"));

    AccountEntity account = new AccountEntity()
            .setName(accountName)
            .setValue(balance);

    template.update("INSERT INTO account (name, value) VALUES (?, ?)", account.getName(), account.getValue());
  }
}
