package ammunition.shields;


public class SmallShield extends Shield {

	public SmallShield() {
	};

	final static private int PRICE = 200;
	final static private int WEIGHT = 5;

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
		System.out.println("Used small shiled to protect yourself");
	}

}
