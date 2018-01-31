package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author Pittayut Sothanakul
 */
public class Purse {
	/** Collection of objects in the purse. */

	private ArrayList<Valuable> money = new ArrayList<Valuable>();

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

		if (count() >= capacity)
			return true;

		return false;
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Valuable coin) {
		// if the purse is already full then can't insert anything.

		if (isFull() || coin.getValue() <= 0) {
			return false;
		}
		money.add(coin);


		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {

		if (amount < 0)
			return null;
		if (amount > this.getBalance())
			return null;

		ArrayList<Valuable> templist = new ArrayList<>();
		for (int i = money.size() - 1; i >= 0; i--) {
			if (money.get(i).getValue() <= amount) {
				templist.add(money.get(i));
				amount -= money.get(i).getValue();

			}
		}

		double amountNeededToWithdraw = amount;

		if (amountNeededToWithdraw != 0) {
			return null;
		}
		if (amountNeededToWithdraw == 0) {
			for (Valuable coinNeedToWithdraw : templist) {
				money.remove(coinNeedToWithdraw);
			}
		}

		Valuable[] array = new Valuable[templist.size()];

		return templist.toArray(array);
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
