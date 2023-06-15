package org.example;

import java.util.ArrayList;

public class CarDealership {

    private ArrayList<Car> inventory = new ArrayList<>();
    private double moneyMade = 0;
    private double budget = 30000;
    private double dealerMarkUp = 1.2;

    public String addCar(Car car){
        if(this.budget > car.getPrice()){
            this.budget -= car.getPrice();
            this.inventory.add(car);
            return "The car has been added to the inventory";
        }

        return "Not enough money in the budget";
    }

    public void sellCar(Car car){
        this.moneyMade += car.getPrice() * dealerMarkUp;
        this.inventory.remove(car);
    }

    public int getInventoryCount(){
        return this.inventory.size();
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getMoneyMade() {
        return moneyMade;
    }

    public void setMoneyMade(double moneyMade) {
        this.moneyMade = moneyMade;
    }

    public ArrayList<Car> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Car> inventory) {
        this.inventory = inventory;
    }

    public double getDealerMarkUp() {
        return dealerMarkUp;
    }

    public void setDealerMarkUp(double dealerMarkUp) {
        this.dealerMarkUp = dealerMarkUp;
    }

    public static void main(String[] args) {
        CarDealership tonysCarSales = new CarDealership();

        Car car1 = new Car("toyota", "camry", 12000);
        Car car2 = new SUV("jeep", "cherokee", 15000, true);
        Car car3 = new Sedan("kia", "rio", 800, false);

        System.out.println("Purchase 3 vehicles: ");
        System.out.println(tonysCarSales.addCar(car1));
        System.out.println(tonysCarSales.addCar(car2));
        System.out.println(tonysCarSales.addCar(car3));

        System.out.println("Inventory: ");
        System.out.println(tonysCarSales.getInventoryCount());
        System.out.println("Budget left: ");
        System.out.println(tonysCarSales.budget);

        System.out.println("Sell all 3 vehicles");
        tonysCarSales.sellCar(car1);
        tonysCarSales.sellCar(car2);
        tonysCarSales.sellCar(car3);

        System.out.println("Inventory: ");
        System.out.println(tonysCarSales.getInventoryCount());
        System.out.println("Money made: ");
        System.out.println(tonysCarSales.moneyMade);

    }
}


