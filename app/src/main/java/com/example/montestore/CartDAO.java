package com.example.montestore;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CartDAO {
    @Insert
    void insertItem(CartEntity item);

    @Update
    void updateItem(CartEntity item);

    @Delete
    void deleteItem(CartEntity item);

    @Query("SELECT * FROM cart")
    LiveData<List<CartEntity>> getAllItems();
}
