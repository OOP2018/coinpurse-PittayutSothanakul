package coinpurse;

/**
 * BankNote will use when money insert more than or equal 20.
 * 
 * @author Pittayut Sothanakul
 *
 */
public class BankNote implements Valuable {

	private static long nextSerialNumber = 1000000;

	private double value;
	private String currency;
	private long serialNumber;

	/**
	 * Create banknote for collect money.
	 * 
	 * @param value
	 * @param currency
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber++;
	}

	/**
	 * Return value of banknote.
	 */
	@Override
	public double getValue() {
		return value;
	}

	/**
	 * Return currency of banknote.
	 */
	@Override
	public String getCurrency() {
		return currency;
	}

	/**
	 * Check banknote that they are equal or not.
	 */
	@Override
	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		BankNote other = (BankNote) arg;
		if (this.value == other.getValue() && this.currency.equals(other.getCurrency()))
			return true;

		return false;
	}

	/**
	 * toString returns a string description of banknote.
	 */
	@Override
	public String toString() {
		return String.format("%.0f-%s", this.value, this.currency);

	}
}
