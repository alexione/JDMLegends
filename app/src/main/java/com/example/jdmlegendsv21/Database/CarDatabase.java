package com.example.jdmlegendsv21.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.jdmlegendsv21.Model.Car;

@Database(entities = {Car.class}, version = 6, exportSchema = false)
public abstract class CarDatabase extends RoomDatabase {

    private static CarDatabase instance;

    public abstract AppDatabase appDatabase();

    public static synchronized CarDatabase getInstance(Context context)
    {
        if (instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CarDatabase.class, "LocalDB")
                    .fallbackToDestructiveMigration().build();

        }
        return instance;
    }
}

