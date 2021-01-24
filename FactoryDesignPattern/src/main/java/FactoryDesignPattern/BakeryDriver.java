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
public class BakeryDriver {

	public void runBakery() {
		Bakery bakery = new Bakery();
		
		Cake carrotCake = bakery.orderCake("carrot cake");
		System.out.println("\n-----------------------------------\n");
		
		Cake blackForestCake = bakery.orderCake("black forest cake");
		System.out.println("\n-----------------------------------\n");
		
		Cake birthdayCake = bakery.orderCake("birthday cake");
		System.out.println("\n-----------------------------------\n");
	}
	public static void main(String[] args) {
		BakeryDriver driver = new BakeryDriver();
		driver.runBakery();
	}

}
