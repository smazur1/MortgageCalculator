package customcode;

import java.text.NumberFormat;

public class MoneyFormat {

	public MoneyFormat() {
		// TODO Auto-generated constructor stub
	}

	public static String getDollarString(double m) {

		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String moneyString = formatter.format(m);
		return moneyString;
	}
}
