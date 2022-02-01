package com.company;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String name = nameBuyer();
        Buyer firstBuyer = newBuyer(name);
        int money = howMuchMoney();
        firstBuyer.setMoney(money);

        ArrayList<Fruit> fruits;
        Boolean floatPermision = false;
        do {
            String nameFruit = addFruit();
            int costFruit = addFruitCost(nameFruit);
            fruits = new ArrayList<>();
            fruits.add(showFruit(nameFruit, costFruit));
        }
        while (wantAddMoreFruits());


        int op;
        do {
            System.out.println("1-Choose Fruit");
            System.out.println("2-Buy Fruit");
            System.out.println("3-Show money of the buyer");
            System.out.println("4-Exit program");

            op = whatBuy();
            switch (op) {
                case 1 -> firstBuyer = chooseFruit(firstBuyer, fruits.listIterator());
                case 2 -> buyingFruit(firstBuyer);
                case 3 -> showMoney(firstBuyer);
                case 4 -> System.out.println("Exiting program...");
            }
        }
        while (op != 5);
    }

    private static Buyer chooseFruit(Buyer firstBuyer, ListIterator<Fruit> fruits) {
        System.out.println("Choose the fruit you want");
        while (fruits.hasNext()) {
            Fruit fruitChoose = fruits.next();
            System.out.println("Do you want the fruit: "+fruitChoose.getName()+" with cost: "+fruitChoose.getMoney());
            if (wantAddMoreFruits()) {
                firstBuyer.addFruit(fruitChoose);
                firstBuyer.setHasBuyed(true);
            }
        }
        return firstBuyer;
    }

    private static boolean wantAddMoreFruits() {
        System.out.println("Do you want to add more fruits?");
        Scanner scan = new Scanner(System.in);
        String confirm = scan.nextLine();
        return confirm.equalsIgnoreCase("S");
    }


    private static String addFruit() {
        System.out.println("Which fruit we are adding in our shop?");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    private static int addFruitCost(String nameFruit) {
        System.out.println("Add the cost of " + nameFruit);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    private static Fruit showFruit(String nameFruit, int costFruit) {
        return new Fruit(nameFruit, costFruit);
    }

    private static void showMoney(Buyer firstBuyer) {
        System.out.println("The money of the buyer is: " + firstBuyer.getMoney());
    }

    private static String nameBuyer() {
        System.out.println("Who is the new buyer: ");
        return new Scanner(System.in).nextLine();
    }


    private static Buyer newBuyer(String name) {
        Boolean hasBuy = false;
        return new Buyer(name,hasBuy);
    }

    private static void buyingFruit(Buyer buyer) {


        if (buyer.getHasBuyed()) {
            for (Fruit fruitBuy : buyer.getFruitsWantBuy()) {

                if (buyer.getMoney() >= fruitBuy.getMoney()) {
                    buyer.buyFruit(fruitBuy.getMoney());
                    System.out.println("You have: " + buyer.getMoney());
                } else {
                    System.out.println("You don't have money");

                }
            }
        } else {
            System.out.println("You need to choose a fruit");
        }
    }


    private static int whatBuy() {
        return new Scanner(System.in).nextInt();
    }

    private static int howMuchMoney() {
        System.out.println("How much money have the buyer");
        return new Scanner(System.in).nextInt();
    }
}
