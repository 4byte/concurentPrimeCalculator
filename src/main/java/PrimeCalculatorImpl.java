import java.util.List;

/**
 * Actual prime calculator implementation of PrimeCalculatorContract,
 * uses ForkJoinPool PrimeRecursiveCalculator to divide job and generate Primes
 */
public class PrimeCalculatorImpl extends PrimeCalculatorContract {
	@Override
	public List<Integer> returnAllPrimeNumbers(int limit) {
		return PrimeRecursiveCalculator.countPrimes(1,limit);
	}
}
