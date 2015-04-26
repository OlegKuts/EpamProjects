package ammunition.shields;


public class TowerShield extends Shield {

	public TowerShield() {
	};

	final static private int PRICE = 1800;
	final static private int WEIGHT = 20;

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
		System.out.println("Used tower shiled to protect yourself");
	}

}
