package com.example.LIFTR;

import java.io.Serializable;

public class Food implements Serializable {

    private String name;
    private int cal;
    private double protein;
    private double carbs;
    private double fat;
    private String servingType;
    private int servingSize;

    public Food(String name, int cal, double protein,
                double carbs, double fat, String servingType, int servingSize) {
        this.name = name;
        this.cal = cal;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.servingType = servingType;
        this.servingSize = servingSize;
    }

    public Food() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCal() {
        return cal;
    }

    public void setCal(int cal) {
        this.cal = cal;
    }

    public double getProtein() {
        return protein;
    }
    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public String getServingType() {
        return servingType;
    }

    public void setServingType(String servingType) {
        this.servingType = servingType;
    }

    public int getServingSize() {
        return servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }
}
