import java.util.List;

public class PrimeCalculatorImpl extends PrimeCalculatorContract {
	@Override
	public List<Integer> returnAllPrimeNumbers(int limit) {
		return PrimeRecursiveCalculator.countPrimes(1,limit);
	}
}
