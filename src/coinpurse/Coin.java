package coinpurse;

public class Coin implements Comparable<Coin> {
	private double value;
	private String currency;

	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	public double getValue() {
		return this.value;
	}

	public String getCurrency() {
		return this.getCurrency();
	}

	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		Coin other = (Coin) arg;
		if (this.value == other.getValue() && this.currency == other.getCurrency())
			return true;

		return false;
	}

	public String toString() {
		return String.format("%.0f-%s", this.value, this.currency);

	}

	@Override
	public int compareTo(Coin coin) {
		if (coin == null) {
			return -1;
		}

		return (int) Math.signum(this.value - coin.getValue());
	}
}
