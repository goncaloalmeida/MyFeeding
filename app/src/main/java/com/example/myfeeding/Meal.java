package com.example.myfeeding;

public class Meal {
    private int year;
    private int month;
    private int day;
    private String name;
    private int caloires;

    public Meal(int year, int month, int day, String name, int caloires) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.name = name;
        this.caloires = caloires;
    }

    public Meal(String name, int caloires) {
        this.name = name;
        this.caloires = caloires;
    }

    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month+1;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCaloires() {
        return caloires;
    }

    public void setCaloires(int caloires) {
        this.caloires = caloires;
    }
}
