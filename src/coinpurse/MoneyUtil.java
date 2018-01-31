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

		Purse p = new Purse(6);
		p.insert(new Coin(10, "Bath"));
		p.insert(new Coin(5, "Dollar"));
		p.insert(new Coin(2, "Bath"));
		p.insert(new Coin(5, "Bath"));
		p.insert(new BankNote(20, "Bath"));
		p.insert(new BankNote(1, "Bath"));
		System.out.println(p.toString());
		System.out.println(filterByCurrency(p.getMoney(), "Bath").toString());
		System.out.println(filterByCurrency(p.getMoney(), "Dollar").toString());
		sortCoins(p.getMoney());
		System.out.println(filterByCurrency(p.getMoney(), "Bath").toString());

	}
}
