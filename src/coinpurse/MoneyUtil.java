package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Methods that check the value that have same currency and sort a list of value.
 * 
 * @author Pittayut Sothanakul
 *
 */
public class MoneyUtil {
	/**
	 * Method that return value have same currency.
	 * 
	 * @param coins
	 * @param currency
	 * @return a new list contain request currency.
	 */
	public static List<Coin> filterByCurrency(List<Coin> coins, String currency) {
		List<Coin> list = new ArrayList<>();
		for (Coin coinlist : coins) {
			if (coinlist.getCurrency().equals(currency)) {
				list.add(coinlist);
			}
		}
		return list;

	}

	/**
	 * Method to sort a list of value.
	 * 
	 * @param value
	 *            is a List of Coin to sort.
	 * 
	 */
	public static void sortCoins(List<Coin> coins) {
		Collections.sort(coins);
	}
	/**
	 * Method main to test Ex5 MoneyUtil.
	 * @param args
	 */
	public static void main(String[] args) {
		Purse purse = new Purse(3);
		System.out.println(purse.getBalance());
		System.out.println(purse.count());
		System.out.println(purse.isFull());
		System.out.println(purse.insert(new Coin(5, "Bath")));
		System.out.println(purse.insert(new Coin(10, "Bath")));
		System.out.println(purse.insert(new Coin(0, "Bath")));
		System.out.println(purse.insert(new Coin(1, "Bath")));
		System.out.println(purse.insert(new Coin(5, "Bath")));
		System.out.println(purse.count());
		System.out.println(purse.isFull());
		System.out.println(purse.getBalance());
		System.out.println(purse.toString());
		System.out.println(purse.withdraw(12));
		System.out.println(Arrays.toString(purse.withdraw(11)));
	}
}
