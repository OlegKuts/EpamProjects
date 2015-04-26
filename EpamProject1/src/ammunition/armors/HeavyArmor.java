package ammunition.armors;


public class HeavyArmor extends Armor {

	public HeavyArmor() {
	};

	final static private int PRICE = 7500;
	final static private int WEIGHT = 45;

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
}
