package com.alexschacher.dietapp.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "food_table")
public class Food {

    public Food(String name, int calories, float portionSize, String portionType)
    {
        this.name = name;
        this.calories = calories;
        this.portionSize = portionSize;
        this.portionType = portionType;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "calories")
    private int calories;

    @ColumnInfo(name = "portion_size")
    private float portionSize;

    @ColumnInfo(name = "portion_type")
    private String portionType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public float getPortionSize() {
        return portionSize;
    }

    public void setPortionSize(float portionSize) {
        this.portionSize = portionSize;
    }

    public String getPortionType() {
        return portionType;
    }

    public void setPortionType(String portionType) {
        this.portionType = portionType;
    }
}
