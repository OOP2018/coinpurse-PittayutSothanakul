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
	 * Create banknote for collect money with serial number.
	 * 
	 * @param value
	 * @param currency
	 * @param serialNumber
	 */
	public BankNote(double value, String currency) {
		super(value, currency);
		this.serialNumber = nextSerialNumber++;
	}

	/**
	 * to return the serial number of banknote.
	 * 
	 * @return the serial number.
	 */
	public long getSerial() {
		return serialNumber;
	}

	/**
	 * Return a string representation of this BankNote.
	 * 
	 * @return string that describes the BankNote.
	 * 
	 */
	public String toString() {
		return String.format("%.02f-%s note[%d]",getValue() , getCurrency() , serialNumber );

	}
}
