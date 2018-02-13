package coinpurse;

/**
 * Interface for objects have a value and currency.
 * 
 * @author Pittayut Sothanakul
 *
 */
public interface Valuable extends Comparable<Valuable>{
	/**
	 * Get the value of this object.
	 * 
	 * @return the value of this object
	 */

	public double getValue();

	/**
	 * Get currency of this object.
	 * 
	 * @return the currency of this object.
	 */
	public String getCurrency();
}