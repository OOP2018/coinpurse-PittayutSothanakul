package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.MoneyUtil;
import coinpurse.Valuable;

/**
 * Withdraw by recursive.
 * 
 * @author Pittayut Sothanakul
 *
 */
public class RecursiveWithdrawStategy implements WithdrawStrategy {
	/**
	 * Find and return items from a collection whose total value equals the
	 * requested amount.
	 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {

		MoneyUtil.filterByCurrency(money, amount.getCurrency());
		return withdrawHelper(amount.getValue(), money);
	}

	/**
	 * Help withdraw recursive to find amount can withdraw in purse.
	 * 
	 * @param amount
	 * @param money
	 * @return amount can withdraw.
	 */
	public List<Valuable> withdrawHelper(double amount, List<Valuable> money) {
		if (amount == 0)
			return new ArrayList<Valuable>();

		if (money.isEmpty())
			return null;

		if (amount == 0)
			return new ArrayList<Valuable>();
		Valuable first = money.get(0);
		List<Valuable> left = withdrawHelper(amount - first.getValue(), money.subList(1, money.size()));
		List<Valuable> right = withdrawHelper(amount, money.subList(1, money.size()));

		if (left != null) {
			left.add(first);
			return left;
		}
		return right;
	}

}
