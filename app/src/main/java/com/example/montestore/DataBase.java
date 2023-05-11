package com.example.montestore;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UEntity.class}, version =1)
public abstract class DataBase extends RoomDatabase {
    private static final String dbName="user";
    private static volatile DataBase instance;
    private static  DataBase dataBase;
    public static synchronized DataBase getDataBase(Context context){
        if(dataBase == null){
            dataBase = Room.databaseBuilder(context, DataBase.class, dbName)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return dataBase;
    }
    public abstract DAO userDao();
}
