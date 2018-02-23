package coinpurse;

/**
 * MalayMoneyFactory is money of Malaysia.
 * 
 * @author PittayutSothanakul
 *
 */
public class MalayMoneyFactory extends MoneyFactory {

	private static final String CURRENCY = "Ringgit";
	private static final String CURRENCYCOIN = "Sen";
	protected long nextSerialNumber = 1000000;

	/**
	 * Create new money value in Malaysia currency.
	 */
	@Override
	public Valuable createMoney(double value) {
		Valuable valuable;

		if (value == 0.05 || value == 0.10 || value == 0.50) {
			valuable = new Coin(value, CURRENCYCOIN);
		} else if (value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50
				|| value == 100) {
			valuable = new BankNote(value, CURRENCY, nextSerialNumber++);
		} else {
			throw new IllegalArgumentException("It isn't Malay money");
		}

		return valuable;
	}

	// public static void main(String[] arg) {
	// MoneyFactory.setMoneyFactory(new MalayMoneyFactory());
	// MoneyFactory factory = MoneyFactory.getInstance();
	// Valuable m = factory.createMoney(5);
	// System.out.println(m.toString());
	// Valuable m3 = factory.createMoney(0.05);
	// System.out.println(m3.toString());
	// Valuable m2 = factory.createMoney("100.0");
	// System.out.println(m2.toString());
	//
	// }
}
