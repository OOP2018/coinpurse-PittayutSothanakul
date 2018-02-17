package coinpurse;

/**
 * A coin with a monetary value and currency.
 * 
 * @author Pittayut Sothanakul
 */

public class Coin extends Money {
	public static final String DEFAULT_CURRENCY = "Baht";

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 * @param currency
	 */
	public Coin(double value) {
		super(value, DEFAULT_CURRENCY);
	}

	/**
	 * A coin with given value using the currency.
	 * 
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency) {
		super(value, currency);
	}

	/**
	 * Return a string representation of this Coin.
	 * 
	 * @return string that describes the coin.
	 * 
	 */
	public String toString() {
		if (getValue()<1 &&getCurrency().equalsIgnoreCase("Sen")) {
			return String.format("%.0f-%s", getValue()*100, getCurrency());
		}
		return String.format("%.0f-%s", getValue(), getCurrency());
		

	}

}
