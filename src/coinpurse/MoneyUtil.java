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

	public static <E extends Valuable> List filterByCurrency(List<E> coins, String currency) {
		List<E> list = new ArrayList<>();
		for (E coinlist : coins) {
			if (coinlist.getCurrency().equals(currency)) {
				list.add(coinlist);
			}
		}
		return list;

	}

	/**
	 * Return the larger argument, based on sort order, using the objects' own
	 * compareTo method for comparing.
	 * 
	 * @param args
	 *            one or more Comparable objects to compare.
	 * @return the argument that would be last if sorted the elements.
	 * @throws IllegalArgumentException
	 *             if no arguments given.
	 */
	public static <E extends Comparable<? super E>> E max(E... args) throws IllegalArgumentException {

		E result = args[0];
		for (int i = 1; i < args.length; i++) {
			if (args[i].compareTo(result) > 0) {
				result = args[i];
			}
		}
		return result;
	}

	/**
	 * Method to sort a list of value.
	 * 
	 * @param value
	 *            is a List of Coin to sort.
	 * 
	 */
	public static void sortMoney(List<? extends Valuable> money) {

		Collections.sort(money, new ValueComparater());

	}

	/**
	 * Method main to test Ex5 MoneyUtil.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Purse p = new Purse(6);
		// p.insert(new Coin(10, "Bath"));
		// p.insert(new Coin(5, "Dollar"));
		// p.insert(new Coin(2, "Bath"));
		// p.insert(new Coin(5, "Bath"));
		// p.insert(new BankNote(20, "Bath"));
		// p.insert(new BankNote(1, "Bath"));
		// System.out.println(p.toString());
		// System.out.println(filterByCurrency(p.getMoney(),
		// "Bath").toString());
		// System.out.println(filterByCurrency(p.getMoney(),
		// "Dollar").toString());
		// sortCoins(p.getMoney());
		// System.out.println(filterByCurrency(p.getMoney(),
		// "Bath").toString());
		String maxWord = MoneyUtil.max("dog", "zebra", "cat");
		Money m1 = new BankNote(100, "Baht");
		Money m2 = new BankNote(500, "Baht");
		Money m3 = new Coin(20, "Baht");
		Money max = MoneyUtil.max(m1, m2, m3);
		System.out.println(max);
		System.out.println(maxWord);

		List<BankNote> list = new ArrayList<BankNote>();
		list.add(new BankNote(10.0, "USD"));
		list.add(new BankNote(500.0, "Baht"));
		MoneyUtil.sortMoney(list);
		System.out.println(list);

		List<Coin> coins = Arrays.asList(new Coin(5, "Baht"), new Coin(0.1, "Ringgit"), new Coin(5, "Cent"));
		List<Coin> result = MoneyUtil.filterByCurrency(coins, "Baht");

		System.out.println(result);
	}
}
