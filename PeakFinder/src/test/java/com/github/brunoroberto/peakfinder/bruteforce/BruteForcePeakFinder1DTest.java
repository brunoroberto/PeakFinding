package com.github.brunoroberto.peakfinder.bruteforce;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.github.brunoroberto.peakfinder.PeakFinder1D;
import com.github.brunoroberto.peakfinder.time.ExecutionTimePrinter;

public class BruteForcePeakFinder1DTest {

	@Test
	public void testIntegerPeakFinder() {
		final int n = 10_000_000;
		Integer[] values = new Integer[n];
		for (int i = 0; i < n; i++)
			values[i] = i + 1;
		PeakFinder1D<Integer> peakFinder = new BruteForcePeakFinder1D<>();
		int peak = peakFinder.findPeak(values);
		assertEquals(n, peak);
		ExecutionTimePrinter.print(peakFinder.getExecutionTime());
	}

}
