package ammunition.weapons;


public class WoodenAxe extends Weapon {

	public WoodenAxe() {
	};

	final static private int PRICE = 150;
	final static private int WEIGHT = 7;

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return PRICE;
	}

	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
		return WEIGHT;
	}

	@Override
	public void damage() {
		System.out.println("Damage with a wooden axe");
	}

}
