/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryDesignPattern;
/**
 *
 * @author adameinstein
 */
public class Bakery {
    /**
     * @param type
     * @return the cake based on its type 
     */
    private Cake createCake(String type) {
        switch (type) {
            case "carrot cake":
                return new CarrotCake();
            case "black forest cake":
                return new BlackForestCake();
            case "birthday cake":
                return new BirthdayCake();
            default:
                return new Cake() {};
        }
    }
    /**
     * @param type calls createCake to
     * @return cake
     */
    public Cake orderCake(String type) {
       Cake cake = createCake(type);
       cake.createCake();
       System.out.printf("Price: $%.2f",cake.getPrice());
       return cake;
    }
}

   