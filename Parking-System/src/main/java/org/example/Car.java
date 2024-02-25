package org.example;

import java.util.ArrayList;
import java.util.List;

class Car {
    private String licenseplate;

    public Car(String licenseplate) {
        this.licenseplate = licenseplate;
    }

    public String getLicenseplate() {
        return licenseplate;
    }
}

class ParkingSport
{
    private int spotNumber;
    private boolean available;

    private Car car;

    public ParkingSport(int spotNumber) {
        this.spotNumber = spotNumber;
        this.available =true;
        this.car = null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public Car getCar() {
        return car;
    }

    public void occupy(Car car)
    {
        this.car=car;
        this.available=false;
    }

    public void vacate()
    {
        this.car=null;
        this.available=true;
    }
}

class ParkingLot
{
    private List<ParkingSport> sports;

    public ParkingLot(int capacity) {
        this.sports=new ArrayList<>();
        for(int i=0;i<capacity;i++)
        {
            sports.add(new ParkingSport(i));
        }
    }

    public boolean parkCar(Car car)
    {
        for(ParkingSport spot:sports)
        {
            if(spot.isAvailable())
            {
                spot.occupy(car);
                System.out.println("Car with number : "+car.getLicenseplate() + " parked at spot number :"+spot.getSpotNumber());
                return true;
            }
        }
        System.out.println("Sorry parking is full");
        return false;
    }

    public boolean revomeCar(String licensePlate)
    {
        for (ParkingSport spot:sports)
        {
            if(!spot.isAvailable() && spot.getCar().getLicenseplate().equalsIgnoreCase(licensePlate))
            {
                spot.vacate();
                System.out.println("Car with number :"+licensePlate+" removed from parking and spot num "+spot.getSpotNumber());
                return true;
            }

        }
        System.out.println("Car with number "+licensePlate+" Not found");
        return false;
    }



}

class Test{
    public static void main(String[] args) {
        ParkingLot parkingLot=new ParkingLot(5);
        Car car1=new Car("UP807673");
        Car car2=new Car("DL837273");
        Car car3=new Car("MP841732");
        Car car4=new Car("MP8414732");
        Car car5=new Car("MP841882");
        Car car6=new Car("MP8415442");

        parkingLot.parkCar(car1);
        parkingLot.parkCar(car2);
        parkingLot.parkCar(car3);
        parkingLot.parkCar(car4);
        parkingLot.parkCar(car5);


       parkingLot.revomeCar("UP807673");

        parkingLot.parkCar(car6);
    }
}