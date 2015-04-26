package ammunition.armors;


public class MediumArmor extends Armor {

	public MediumArmor() {
	};

	final static private int PRICE = 2500;
	final static private int WEIGHT = 25;

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
