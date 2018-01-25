package coinpurse;

/**
 * A coin with a monetary value and currency.
 * 
 * @author Pittayut Sothanakul
 */

public class Coin implements Comparable<Coin> {
	private double value;
	private String currency;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Return the value of the coin.
	 * 
	 * @return the value.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Return the currency of the coin.
	 * 
	 * @return the currency.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Compare two coins by value and currency.
	 * 
	 * @param arg
	 *            is another Object to compare to this one.
	 * @return true if the value and currncy is same , false if not same.
	 */
	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		Coin other = (Coin) arg;
		if (this.value == other.getValue() && this.currency == other.getCurrency())
			return true;

		return false;
	}

	/**
	 * Return a string representation of this Coin.
	 * 
	 * @return string that describes the coin.
	 * 
	 */
	public String toString() {
		return String.format("%.0f-%s", this.value, this.currency);

	}

	/**
	 * Order Coins by value so that the smaller value comes first.
	 * 
	 * @param coin
	 *            is object of Coin that you want to compare with other coin.
	 * @return 1 if this coin has greater value 0 if both have same value -1 if
	 *         this coin has lesser value.
	 */

	@Override
	public int compareTo(Coin coin) {
		if (coin == null) {
			return -1;
		}

		return (int) Math.signum(this.value - coin.getValue());
	}
}
