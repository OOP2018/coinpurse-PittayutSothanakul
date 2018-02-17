package coinpurse;

/**
 * ThaiMoneyFactory is money of Thailand.
 * 
 * @author PittayutSothanakul
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	private static String CURRENCY = "baht";

	/**
	 * Create new money value in Thailand currency.
	 */
	@Override
	public Valuable createMoney(double value) {
		
		Valuable valuable;
	

		if ( value == 0.25 ||value == 0.5 ||value == 1 || value == 2 || value == 5 || value == 10) {
			valuable = new Coin(value, CURRENCY);
		} else if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) {
			valuable = new BankNote(value, CURRENCY);
		}else {
			throw new IllegalArgumentException();
		}
		return valuable;
	}

//	public static void main(String[] arg) {
//		
//		MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
//		MoneyFactory factory = MoneyFactory.getInstance();
//		Valuable m = factory.createMoney(5);
//		System.out.println(m.toString());
//		Valuable m2 = factory.createMoney("1000.0");
//		System.out.println(m2.toString());
//		Valuable m3 = factory.createMoney(500);
//		System.out.println(m3.toString());
//		Valuable m4 = factory.createMoney(20);
//		System.out.println(m4.toString());
//		Valuable m5 = factory.createMoney(0.25);
//		System.out.println(m5.toString());
//		Valuable m6 = factory.createMoney(0.5);
//		System.out.println(m6.toString());
//	}
}
