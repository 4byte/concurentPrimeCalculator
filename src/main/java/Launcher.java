//simple test launcher for Recursive Calculator
public class Launcher {
	public static void main(String[] args) {
		PrimeCalculatorImpl calculator = new PrimeCalculatorImpl();
		System.out.println(calculator.returnAllPrimeNumbers(10000));
	}
}
