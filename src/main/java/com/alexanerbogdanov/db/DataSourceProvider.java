package com.alexanerbogdanov.db;

//public class DataSourceProvider {


  // вызов приватного конструктора
//  public static final DataSourceProvider INSTANCE = new DataSourceProvider();

//  private DataSourceProvider() {
//  }


  // иначе
//  private static DataSourceProvider INSTANCE;
//  private DataSourceProvider() {
//  }
//
//  public static DataSourceProvider getInstance() {
//    if (INSTANCE == null) {
//      INSTANCE = new DataSourceProvider();
//    }
//    return INSTANCE; // добавили ленивую инициализацию
//  }
//}


// вообще иначе

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

// singleton
public enum DataSourceProvider {
    INSTANCE;

    private PGSimpleDataSource ds;

    public DataSource getDataSource() {
      if (ds == null) {
        ds = new PGSimpleDataSource();
        ds.setServerNames(new String[] {"localhost"});
        ds.setPortNumbers(new int[] {5432});
        ds.setDatabaseName("coin_keeper");
        ds.setUser("postgres");
        ds.setPassword("secret");
      }
      return ds;
    }
}

