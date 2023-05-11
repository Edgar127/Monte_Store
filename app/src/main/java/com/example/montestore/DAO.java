package com.example.montestore;

import android.util.Log;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DAO {
    @Insert
    //userEntity
    void registerUser(UEntity userEntity);

    @Query("SELECT * FROM users WHERE userId = :userId")
    UEntity getUserById(String userId);

    @Query("SELECT * FROM users WHERE name = :name AND password = :password")
    UEntity getUserByCredentials(String name, String password);

    @Query("SELECT * FROM users")
    List<UEntity> getAllUsers();

    @Query("DELETE FROM users WHERE userId = :userId")
    void deleteUserById(String userId);
}
