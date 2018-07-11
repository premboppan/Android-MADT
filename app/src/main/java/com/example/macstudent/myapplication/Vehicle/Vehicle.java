package com.example.macstudent.myapplication.Vehicle;
import java.io.Serializable;

public abstract class Vehicle implements Serializable {

    private String company;
    private String plate;
    private String color;
    private int year;

    public Vehicle()
    {

    }

    public Vehicle(String company, String plate, String colour, int year) {
        this.company = company;
        this.plate = plate;
        this.color = color;
        this.year = year;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColour() {
        return color;
    }

    public void setColour(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {

        this.year = year;
    }

    public abstract void Vehicle();

    public void printMyData()
    {

    }

}
