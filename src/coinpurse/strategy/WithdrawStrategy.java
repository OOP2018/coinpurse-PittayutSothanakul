package coinpurse.strategy;

import java.util.List;

import coinpurse.Valuable;

/**
 * Interface of withdraw that can choose your strategy.
 * 
 * @author Pittayut Sothanakul
 *
 */
public interface WithdrawStrategy {
	/**
	 * Find and return items from a collection whose total value equals the
	 * requested amount.
	 * 
	 * @param amount
	 *            is the amount of money to withdraw, with currency
	 * @param items
	 *            the contents that are available for possible withdraw. Must
	 *            not be null, but may be an empty list. This list is not
	 *            modified.
	 * @return if a solution is found, return a List containing references from
	 *         the items parameter (List) whose sum equals the amount. if a
	 *         solution is not found, return null.
	 */
	public List<Valuable> withdraw(Valuable amount, List<Valuable> valuables);

}
