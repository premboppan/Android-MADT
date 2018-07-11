package com.example.macstudent.myapplication.Vehicle;

import android.graphics.Color;

import java.io.Serializable;

public class Motorcycle extends Vehicle implements Serializable{

    float Color;
    float MaxSpeed;

    public Motorcycle()
    {
        super();
    }

    public Motorcycle(String company, String plate, String colour, int year, float enginePower, float topSpeed) {
        super(company, plate, colour, year);
        this.Color = Color;
        this.MaxSpeed = MaxSpeed;
    }

    public float getColor() { return Color;

    public void setColor(float Color) {
        this.Color = Color;
    }

    public float MaxSpeed() {
        return MaxSpeed;
    }

    public void setMaxSpeed(float MaxSpeed) {
        this.MaxSpeed = MaxSpeed;
    }

    public void Vehicle()
    {}

    @Override
    public void printMyData()
    {
        System.out.println("Employee has a MotorCycle ");
        System.out.println("\tBrand:            " + getCompany());
        System.out.println("\tVehicle Number:   " + getPlate());
        System.out.println("\tColour:           " + getColour());
        System.out.println("\tManufactured Year:" + getYear());
        System.out.println("\tEngine Power:     " + getColor()+"CC");
        System.out.println("\tTop Speed:        " + getMaxSpeed());
    }
}

