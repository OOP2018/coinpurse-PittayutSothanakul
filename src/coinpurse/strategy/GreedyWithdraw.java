package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import coinpurse.Valuable;

/**
 * Withdraw by greedy algorithm.
 * 
 * @author Pittayut Sothanakul
 *
 */
public class GreedyWithdraw implements WithdrawStrategy {
	/**
	 * Find and return items from a collection whose total value equals the
	 * requested amount.s
	 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> items) {
		double amountNeededToWithdraw = amount.getValue();
		Collections.sort(items);
		List<Valuable> temptlist = new ArrayList<>();

		if (amountNeededToWithdraw > amount.getValue()) {
			return null;
		}
		for (Valuable value : items) {
			if (amountNeededToWithdraw >= value.getValue()
					&& value.getCurrency().equalsIgnoreCase(amount.getCurrency())) {
				amountNeededToWithdraw -= value.getValue();
				temptlist.add(value);

			}
		}
		if (amountNeededToWithdraw != 0) {
			return null;

		}
		return temptlist;
	}

}
