package com.company;

import java.util.ArrayList;

public class Buyer {
    private String name;
    private int money;
    private ArrayList<Fruit> fruitsWantBuy;
    private Boolean hasBuyed;

    public Buyer() {
    }

    public Buyer(String name, Boolean hasBuyed) {
        this.name = name;
        this.hasBuyed = hasBuyed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void buyFruit(int money) {
        this.money -= money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public ArrayList<Fruit> getFruitsWantBuy() {
        return fruitsWantBuy;
    }

    public void setFruitsWantBuy(ArrayList<Fruit> fruitsWantBuy) {
        this.fruitsWantBuy = fruitsWantBuy;
    }
    public void addFruit(Fruit fruit){
        if(fruitsWantBuy == null)
        {
            fruitsWantBuy= new ArrayList<>();
            fruitsWantBuy.add(fruit);
        }
        else
        {
            fruitsWantBuy.add(fruit);
        }
    }

    public Boolean getHasBuyed() {
        return hasBuyed;
    }

    public void setHasBuyed(Boolean hasBuyed) {
        this.hasBuyed = hasBuyed;
    }
}
