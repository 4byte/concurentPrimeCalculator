import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class PrimeRecursiveCalculator extends RecursiveTask<List<Integer>> {
	private int high;
	private int low;

	PrimeRecursiveCalculator(int low, int high) {
		this.high = high;
		this.low = low;
	}

	static List<Integer> countPrimes(int low, int high) {
		return fjPool.invoke(new PrimeRecursiveCalculator(low, high));
	}

	@Override
	protected List<Integer> compute() {
		List<Integer> primes = new ArrayList<>();
		if (high - low <= 1000) {
			for (int i = low; i < high; i++) {
				if (PrimeCalculatorContract.isPrime(i)) primes.add(i);
			}
		} else {
			int divider = ((high - low) / 2) + low;
			PrimeRecursiveCalculator small = new PrimeRecursiveCalculator(low, divider);
			PrimeRecursiveCalculator large = new PrimeRecursiveCalculator(divider, high);
			large.fork();
			primes.addAll(small.compute());
			primes.addAll(large.join());
		}
		return primes;
	}

	static final ForkJoinPool fjPool = new ForkJoinPool();
}