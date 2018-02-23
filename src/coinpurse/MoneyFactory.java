package coinpurse;

/**
 * MoneyFactory is a abstract class for creating Valuable items.
 * 
 * @author Pittayut Sothanakul
 *
 */
public abstract class MoneyFactory {

	private static MoneyFactory factory = new ThaiMoneyFactory();
	protected long nextSerialNumber = 1000000;

	/**
	 * Constructor for MoneyFactory.
	 */
	protected MoneyFactory() {
	}

	/**
	 * Get an instance of MoneyFactory. This method returns an object of a
	 * subclass (such as ThaiMoneyFactor). The instance is a Singleton -- it
	 * always returns the same object.
	 * 
	 * @return object of a subclass
	 */
	public static MoneyFactory getInstance() {
		// if (FACTORY == null) {
		// FACTORY = new ReadFile().Rad();
		// }
		return factory;
	}

	/**
	 * create new money object in the local currency. If the value is not a
	 * valid currency amount, then throw IllegalArgumentException
	 * 
	 * @param value
	 *            of money
	 * @return money
	 */
	public abstract Valuable createMoney(double value);

	/**
	 * Accepts money value as a String, e.g. createMoney("10"). This method is
	 * for convenience of the U.I. If value is not a valid number, then throw
	 * IllegalArgumentException.
	 * 
	 * @param value
	 *            of money
	 * @return money
	 */
	public Valuable createMoney(String value) {
		try {
			double doubleValue = Double.parseDouble(value);
			return this.createMoney(doubleValue);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(value + "cann't parse to double", e);
		}
	}

	/**
	 * Set type of money (What country).
	 * 
	 * @param factory
	 *            type of money
	 */
	public static void setMoneyFactory(MoneyFactory mFactory) {
		factory = mFactory;

	}

}
