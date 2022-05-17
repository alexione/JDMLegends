package com.example.jdmlegendsv21.Model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "car_table")
public class Car {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String car_brand;
    private String car_model;
    private String car_body_type;
    private int car_year;

    public Car(int id, String car_brand, String car_model, String car_body_type, int car_year)
    {
        this.id = id;
        this.car_brand = car_brand;
        this.car_model = car_model;
        this.car_body_type = car_body_type;
        this.car_year = car_year;

    }

    @Ignore
    public Car(String car_brand, String car_model, String car_body_type, int car_year)
    {
        this.car_brand = car_brand;
        this.car_model = car_model;
        this.car_body_type = car_body_type;
        this.car_year = car_year;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public String getCar_model() {
        return car_model;
    }

    public String getCar_body_type() {
        return car_body_type;
    }

    public int getCar_year() {
        return car_year;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public void setCar_body_type(String car_body_type) {
        this.car_body_type = car_body_type;
    }

    public void setCar_year(int car_year) {
        this.car_year = car_year;
    }
}