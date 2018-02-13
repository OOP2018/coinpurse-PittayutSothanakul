package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author Pittayut Sothanakul
 */
public class Purse {
	/** Collection of objects in the purse. */

	private ArrayList<Valuable> money = new ArrayList<Valuable>();
	private Comparator<Valuable> comparator = new ValueComparater();
	public static final String DEFAULT_CURRENCY = "Baht";

	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;
	private double balance;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		balance = 0;
		for (int i = 0; i < money.size(); i++) {
			balance += money.get(i).getValue();
		}
		return balance;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */

	public int getCapacity() {
		return capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		return money.size() == this.capacity;
	}

	/**
	 * Insert a value into the purse. The value is only inserted if the purse has
	 * space for it and the value has positive value. No worthless coins!
	 * 
	 * @param valuable
	 *            is a Valuable object to insert into purse.
	 * @return true if valuable inserted, false if can't insert.
	 */
	public boolean insert(Valuable valuable) {
		// if the purse is already full then can't insert anything.

		if (isFull() || valuable.getValue() <= 0) {
			return false;
		}
		money.add(valuable);

		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of money
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Money objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */

	public Valuable[] withdraw(double amount) {

		Money money = new Money(amount, DEFAULT_CURRENCY);
		return withdraw(money);
	}

	/**
	 * Withdraw the amount,that have the same currency as the amount
	 * 
	 * 
	 * 
	 * @param amount
	 *            is the amount to withdraw with same currency.
	 * @return array of Money objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(Valuable amount) {

		double amountNeededToWithdraw = amount.getValue();
		ArrayList<Valuable> temptlist = new ArrayList<>();
		Collections.sort(money, comparator);
		if (amountNeededToWithdraw > getBalance()) {
			return null;
		}

		if (amountNeededToWithdraw != 0) {
			for (int i = money.size() - 1; i >= 0; i--) {
				if (money.get(i).getValue() <= amountNeededToWithdraw) {
					temptlist.add(money.get(i));
					amountNeededToWithdraw -= money.get(i).getValue();
				}
			}
		}

		if (amountNeededToWithdraw == 0) {
			for (Valuable coinNeedToWithdraw : temptlist) {
				money.remove(coinNeedToWithdraw);
			}
		}

		if (amountNeededToWithdraw > 0) {
			return null;
		}

		Valuable[] array = new Valuable[temptlist.size()];
		return temptlist.toArray(array);
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {

		return money.size() + " coins with value " + this.getBalance();
	}

	public List<Valuable> getMoney() {

		return this.money;
	}

}
