package ammunition.weapons;


public class IronSword extends Weapon {

	public IronSword() {
	};

	final static private int PRICE = 750;
	final static private int WEIGHT = 12;

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
		System.out.println("Damage with an iron sword");
	}

}
