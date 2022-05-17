package com.example.jdmlegendsv21.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.jdmlegendsv21.Model.Car;

import java.util.List;

@Dao
public interface AppDatabase {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void setCars(Car car);

    @Insert
    void saveCar(Car car);


    @Query("SELECT * FROM car_table")
    List<Car> getCars();

    @Delete
    void removeCar(Car car);
}
