package knight;


import shop.AmmunitionShop;
import shop.NoSuchAmmunitionException;
import ammunition.armors.Armor;
import ammunition.shields.Shield;
import ammunition.weapons.Weapon;

public class Knight {
	private String name;
	private Armor armor;
	private Weapon weapon;
	private Shield shield;
	
	

	public Knight(String name, String armor, String weapon, String shield) throws NoSuchAmmunitionException {
		super();
		this.name = name;
		this.armor = AmmunitionShop.getArmor(armor);
		this.weapon = AmmunitionShop.getWeapon(weapon);
		this.shield = AmmunitionShop.getShield(shield);
	}

	public String getName() {
		return name;
	}

	public int getAmmunitionWeight() {
		return armor.getWeight() + shield.getWeight() + weapon.getWeight();
	}

	public int getAmmunitionCosts() {
		return armor.getPrice() + shield.getPrice() + weapon.getPrice();
	}

	public void attack(){
		weapon.damage();
	}
	
	public void protect(){
		shield.protect();
	}
}
