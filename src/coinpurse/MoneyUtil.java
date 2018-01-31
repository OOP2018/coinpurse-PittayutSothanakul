package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Methods that check the value that have same currency and sort a list of
 * value.
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
	public static List<Valuable> filterByCurrency(List<Valuable> coins, String currency) {
		List<Valuable> list = new ArrayList<>();
		for (Valuable coinlist : coins) {
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
	public static void sortCoins(List<Valuable> coins) {
		Collections.sort(coins, new Comparator<Valuable>() {

			@Override
			public int compare(Valuable o1, Valuable o2) {
				if (o1.getValue() < o2.getValue())
					return -1;
				
				else if (o1.getValue() > o2.getValue())
					return 1;

				return 0;
			}
		});
	}

	/**
	 * Method main to test Ex5 MoneyUtil.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Purse purse = new Purse(3);
		System.out.println(purse.getBalance());
		System.out.println(purse.count());
		System.out.println(purse.isFull());
		System.out.println(purse.insert(new Coin(5, "Bath")));
		System.out.println(purse.insert(new Coin(10, "Dollar")));
		System.out.println(purse.insert(new Coin(0, "Bath")));
		System.out.println(purse.insert(new Coin(1, "Bath")));
		System.out.println(purse.insert(new Coin(5, "Bath")));
		System.out.println(purse.count());
		System.out.println(purse.isFull());
		System.out.println(purse.getBalance());
		System.out.println(purse.toString());
		System.out.println(purse.withdraw(12));
		System.out.println(Arrays.toString(purse.withdraw(15)));
	}
}
