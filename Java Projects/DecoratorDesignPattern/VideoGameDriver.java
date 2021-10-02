/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorDesignPattern;

/**
 *
 * @author adameinstein
 */
import java.text.NumberFormat;
import java.util.Locale;

public class VideoGameDriver {
	
	public VideoGameDriver() {}
	
	public void play() {
		Player mage = new Mage("Alex");
		mage = new Skill(mage);
		mage = new ArmorUpgrade(mage);
		
		Player warrior = new Warrior("Jenny");
		warrior = new WeaponUpgrade(warrior);
		warrior = new ArmorUpgrade(warrior);
		
		Player healer = new Healer("Ben");
		healer = new Skill(healer);
		
		System.out.println("***** Players ******\n");
		displayPlayer(mage);
		displayPlayer(warrior);
		displayPlayer(healer);
	}
	
	private void displayPlayer(Player player) {
		System.out.println(player);
		System.out.println("Power:  " + player.getPower());
		System.out.println();
	}

	public static void main(String[] args) {
		VideoGameDriver driver = new VideoGameDriver();
		driver.play();
	}
}
