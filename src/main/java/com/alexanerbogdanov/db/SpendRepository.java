package com.alexanerbogdanov.db;

import com.alexanerbogdanov.entity.SpendEntity;

import java.util.List;

public interface SpendRepository {
  List<SpendEntity> getAll();
}
