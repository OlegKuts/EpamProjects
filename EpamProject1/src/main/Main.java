package main;

import shop.AmmunitionShop;
import shop.NoSuchAmmunitionException;
import knight.Knight;

public class Main {

	public static void main(String[] args) throws NoSuchAmmunitionException {
		Knight knight = new Knight("Oleg","medium armor","iron sword","tower shield");
		knight.attack();
		knight.protect();
		System.out.println(knight.getAmmunitionCosts());
		System.out.println(knight.getAmmunitionWeight());
		System.out.println(AmmunitionShop.ammunitionList());
		System.out.println(AmmunitionShop.sortAmmunitionByWeight());
		System.out.println(AmmunitionShop.sortAmmunitionByPrice(500, 1000));
		
	}

}
