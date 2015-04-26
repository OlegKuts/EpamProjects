package ammunition.shields;


public class HeavyShield extends Shield {

	public HeavyShield() {
	};

	final static private int PRICE = 1000;
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
	public void protect() {
		System.out.println("Used heavy shiled to protect yourself");
	}

}
