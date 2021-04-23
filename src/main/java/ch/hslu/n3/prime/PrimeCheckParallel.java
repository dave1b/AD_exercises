package ch.hslu.n3.prime;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrimeCheckParallel {

	private AtomicInteger primes = new AtomicInteger(0);
	private static final Logger LOG = LogManager.getLogger(PrimeCheckParallel.class);

	/**
	 * Privater Konstruktor.
	 */
	public PrimeCheckParallel() {

	}

	public void searchPrimes(int amountOfPrimes) {
		long startTime = java.lang.System.currentTimeMillis();
		int amountOfThreads = Runtime.getRuntime().availableProcessors();
		final ExecutorService executor = Executors.newFixedThreadPool(amountOfThreads);
		while (primes.get() < amountOfPrimes) {
			executor.execute(() -> {
				if (primes.get() <= amountOfPrimes) {
					BigInteger bi = new BigInteger(1024, new Random());
					if (bi.isProbablePrime(Integer.MAX_VALUE) && primes.get() <= amountOfPrimes) {
						LOG.info(primes.get() + ": " + bi.toString().substring(0, 20) + "...");
						primes.incrementAndGet();
					} else
						return;
				} else
					return;
			});
		}
		LOG.info(executor);
		executor.shutdown();
		LOG.info("Es hat: " + (java.lang.System.currentTimeMillis() - startTime) + " Millisekunden gedauert mit "
				+ amountOfThreads + " Threads");
		return;
	}

	/**
	 * Main-Demo.
	 *
	 * @param args not used.
	 */
	public static void main(String[] args) {

		PrimeCheckParallel primeCheckP = new PrimeCheckParallel();
		primeCheckP.searchPrimes(100);

	}
}
