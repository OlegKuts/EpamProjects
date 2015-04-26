package shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ammunition.KnightAmmunition;
import ammunition.armors.Armor;
import ammunition.armors.HeavyArmor;
import ammunition.armors.LightArmor;
import ammunition.armors.MediumArmor;
import ammunition.shields.HeavyShield;
import ammunition.shields.Shield;
import ammunition.shields.SmallShield;
import ammunition.shields.TowerShield;
import ammunition.weapons.IronSword;
import ammunition.weapons.SteelMace;
import ammunition.weapons.Weapon;
import ammunition.weapons.WoodenAxe;

public class AmmunitionShop {
	/*
	 * list with all knight ammunition added with double braces
	 */
	@SuppressWarnings("serial")
	static private List<KnightAmmunition> list = new ArrayList<KnightAmmunition>() {
		@Override
		public String toString() {

			return showCollection(this);
		}

		{
			add(new LightArmor());
			add(new MediumArmor());
			add(new HeavyArmor());
			add(new SmallShield());
			add(new HeavyShield());
			add(new TowerShield());
			add(new WoodenAxe());
			add(new IronSword());
			add(new SteelMace());
		}
	};

	/*
	 * Method to help Override my toString method in collections
	 */
	private static String showCollection(List<KnightAmmunition> list) {
		StringBuilder st = new StringBuilder();
		for (KnightAmmunition o : list) {
			st.append(o.getClass().getSimpleName() + " weight: "
					+ o.getWeight() + ", price: " + o.getPrice() + "\n");

		}
		return st.toString();

	};

	/*
	 * Return list of ammunition
	 */
	public static List<KnightAmmunition> ammunitionList() {
		return list;
	}

	/*
	 * Return list of ammunition sorted dependenly on weight
	 */
	public static List<KnightAmmunition> sortAmmunitionByWeight() {
		@SuppressWarnings("serial")
		List<KnightAmmunition> sortedList = new ArrayList<KnightAmmunition>(
				list) {

			@Override
			public String toString() {

				return showCollection(this);
			}
		};
		Collections.sort(sortedList, new Comparator<KnightAmmunition>() {

			@Override
			public int compare(KnightAmmunition arg0, KnightAmmunition arg1) {
				// TODO Auto-generated method stub
				return arg0.getWeight() - arg1.getWeight();
			}

		});
		return sortedList;
	}

	/*
	 * Return list of ammunition in range of price
	 */
	@SuppressWarnings("serial")
	public static List<KnightAmmunition> sortAmmunitionByPrice(int from, int to) {
		List<KnightAmmunition> sortedList = new ArrayList<KnightAmmunition>() {
			@Override
			public String toString() {

				return showCollection(this);
			}
		};
		for (KnightAmmunition o : list) {
			if (o.getPrice() >= from && o.getPrice() <= to) {
				sortedList.add(o);
			}
		}
		return sortedList;
	}

	/*
	 * Return armor object depending on string value passed Default: return null
	 */
	public static Armor getArmor(String armor) {
		String str = armor.toLowerCase();
		switch (str) {
		case "light armor":
			return new LightArmor();
		case "medium armor":
			return new MediumArmor();
		case "heavy armor":
			return new HeavyArmor();
		default:
			return null;
		}
	}

	/*
	 * Return weapon object depending on string value passed Default: throw
	 * NoSuchAmmunitionException
	 */
	public static Weapon getWeapon(String weapon)
			throws NoSuchAmmunitionException {
		String str = weapon.toLowerCase();
		switch (str) {
		case "wooden axe":
			return new WoodenAxe();
		case "iron sword":
			return new IronSword();
		case "steel mace":
			return new SteelMace();
		default:
			throw new NoSuchAmmunitionException();
		}
	}

	/*
	 * Return shield object depending on string value passed Default: throw
	 * NoSuchAmmunitionException
	 */
	public static Shield getShield(String shield)
			throws NoSuchAmmunitionException {
		String str = shield.toLowerCase();
		switch (str) {
		case "small shield":
			return new SmallShield();
		case "heavy shield":
			return new HeavyShield();
		case "tower shield":
			return new TowerShield();
		default:
			throw new NoSuchAmmunitionException();

		}
	}
}
