package coinpurse;
/**
 * MoneyFactoryDemo that class check Monbeyfactory is singleton? and check all the methods work as specified.
 * @author Pittayut Sothanakul
 *
 */
	public class MoneyFactoryDemo {
		/*
		 * Main to run program to check answer.
		 */
		public static void main(String[] args) {
			System.out.println("Test ThaiMoneyFactory");
			MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
			MoneyFactory thFactory = MoneyFactory.getInstance();

			System.out.println("1.) Thai Money factory is singleton ?");
			MoneyFactory testFactory = MoneyFactory.getInstance();
			System.out.print("Answer is ");
			System.out.println(thFactory == testFactory );

			System.out.println("2.) All the methods work as specified");
			
	
			Valuable m = thFactory.createMoney(5);
			System.out.println(m.toString());
			Valuable m2 = thFactory.createMoney("1000.0");
			System.out.println(m2.toString());
			Valuable m3 = thFactory.createMoney(500);
			System.out.println(m3.toString());
			Valuable m4 = thFactory.createMoney(20);
			System.out.println(m4.toString());
		
			System.out.println("============================================");
			System.out.println("Test MalayMoneyFactory");
			MoneyFactory.setMoneyFactory(new MalayMoneyFactory());
			MoneyFactory mlfactory = MoneyFactory.getInstance();
			System.out.println("1.) Malay Money factory is singleton ?");
			System.out.print("Answer is ");
			System.out.println(thFactory == testFactory );
			
			System.out.println("2.) All the methods work as specified");
			
			Valuable ml1 = mlfactory.createMoney(5);
			System.out.println(ml1.toString());
			Valuable ml2 = mlfactory.createMoney(0.05);
			System.out.println(ml2.toString());
			Valuable ml3 = mlfactory.createMoney("100.0");
			System.out.println(ml3.toString());

		}
	}