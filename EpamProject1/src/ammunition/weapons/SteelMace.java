package ammunition.weapons;


public class SteelMace extends Weapon {

	public SteelMace() {
	};

	final static private int PRICE = 1200;
	final static private int WEIGHT = 17;

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
		System.out.println("Damage with a steel mace");
	}

}
