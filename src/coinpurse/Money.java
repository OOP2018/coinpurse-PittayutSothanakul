package coinpurse;

/**
 * Money class is a superclass of BankNote and Coin classes.
 * 
 * @author Pittayut Sothanakul
 *
 */
public class Money implements Valuable {

	protected double value;
	protected String currency;
	/**
	 * Create money that have value and currency of money.
	 * 
	 * @param value of money
	 * @param currency of money
	 */
	public Money(double value, String currncey) {
		this.value = value;
		this.currency = currncey;
	}

	/**
	 * Return the value of the money.
	 * 
	 * @return the value.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Return the currency of the money.
	 * 
	 * @return the currency.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Compare two money by value and currency.
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
		Valuable other = (Valuable) arg;
		if (this.value == other.getValue() && this.currency.equals(other.getCurrency()))
			return true;

		return false;
	}
	/**
	 * Compare value of money.
	 * 
	 */
	public int compareTo(Valuable other) {
		if (other == null) {
			return -1;
		}
		return (int) Math.signum(this.value - other.getValue());
	}

}