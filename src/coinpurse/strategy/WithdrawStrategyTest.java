package coinpurse.strategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import coinpurse.Coin;
import coinpurse.MoneyFactory;
import coinpurse.ThaiMoneyFactory;
import coinpurse.Valuable;

/**
 * Test the WithdrawStrategy using JUnit.
 * 
 * @author Pittayur Sothanakul
 *
 */
public class WithdrawStrategyTest {

	private WithdrawStrategy strategy;
	private MoneyFactory thaiMoney;
	private static final double TOL = 1.0E-6;
	private List<Valuable> amount = new ArrayList<Valuable>();
	private List<Valuable> withdraw;

	@Before
	public void setUp() {

		strategy = new GreedyWithdraw();
		// strategy = new RecursiveWithdrawStategy();
		thaiMoney = new ThaiMoneyFactory();
		amount.add(thaiMoney.createMoney(100));
		amount.add(thaiMoney.createMoney(20));
		amount.add(thaiMoney.createMoney(1));
		amount.add(thaiMoney.createMoney(5));

	}

	@Test
	public void testWithdrawEverything() {
		withdraw = strategy.withdraw(new Coin(126, "Baht"), amount);
		Collections.sort(amount);
		Collections.sort(withdraw);
		assertEquals(amount, withdraw);

	}

	@Test
	public void testImpossibleWithdraw() {

		withdraw = strategy.withdraw(new Coin(2, "Baht"), amount);
		assertNull(withdraw);
	}

	@Test
	public void testWithdrawMoreThanAmount() {
		withdraw = strategy.withdraw(new Coin(127, "Baht"), amount);
		assertNull(withdraw);
	}

	@Test
	public void testDifferentCurrency() {
		withdraw = strategy.withdraw(new Coin(126, "Ringgit"), amount);
		assertNotEquals(amount, withdraw);
	}

	@Test
	public void testMinusWithdraw() {
		withdraw = strategy.withdraw(new Coin(-1, "Baht"), amount);
		assertNull(withdraw);
	}

}
