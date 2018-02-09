package coinpurse;

/**
 * BankNote will use when money insert more than or equal 20.
 * 
 * @author Pittayut Sothanakul
 *
 */
public class BankNote extends Money {

	private static long nextSerialNumber = 1000000;

	private long serialNumber;

	/**
	 * Create banknote for collect money.
	 * 
	 * @param value
	 * @param currency
	 */
	public BankNote(double value, String currency) {
		super(value, currency);
	}

	/**
	 * Create banknote for collect money with serial number.
	 * 
	 * @param value
	 * @param currency
	 * @param serialNumber
	 */
	public BankNote(double value, String currency, long serialNumber) {
		super(value, currency);
		this.serialNumber = nextSerialNumber++;
	}
	/**
	 * Return a string representation of this BankNote.
	 * 
	 * @return string that describes the BankNote.
	 * 
	 */
	public String toString() {
		return getValue() + "-" + getCurrency() + "seriaNumber " + serialNumber;
	}
}
