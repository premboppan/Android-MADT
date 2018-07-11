package com.example.macstudent.myapplication.Vehicle;

import java.io.Serializable;

public class Car extends Vehicle implements Serializable {

    private float Color;
    private int MaxSpeed;

    public Car(){
        super();
    }

    public Car(String company, String plate, String color, int year, float storageCapacity, int seatCount) {
        super(company, plate, color, year);
        this.Color = storageCapacity;
        this.MaxSpeed = seatCount;
    }

    public float getStorageCapacity() {
        return Color;
    }

    public void setStorageCapacity(float Color) {
        this.Color = Color;
    }

    public int getMaxSpeed() {
        return MaxSpeed;
    }

    public void MaxSpeed(int MaxSpeed) {
          this.MaxSpeed = MaxSpeed;
    }

    public void Vehicle()
    {}

    @Override
    public void printMyData()
    {
        System.out.println("Employee has a Car ");
        System.out.println("\tBrand:            " + getCompany());
        System.out.println("\tVehicle Number:   " + getPlate());
        System.out.println("\tColor:           " + getColor());
        System.out.println("\tManufactured Year:" + getYear());
        System.out.println("\tMaxSpeed:  " + MaxSpeed);
    }
    }
}
