package com.github.brunoroberto.peakfinder.bruteforce;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.github.brunoroberto.peakfinder.PeakFinder2D;
import com.github.brunoroberto.peakfinder.time.ExecutionTimePrinter;

public class BruteForcePeakFinder2DTest {

	@Test
	public void testIntegerPeakFinder() {
		final int n = 3_000;
		final int m = 3_000;
		Integer[][] values = new Integer[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				values[i][j] = j + 1;
		PeakFinder2D<Integer> peakFinder = new BruteForcePeakFinder2D<>();
		int peak = peakFinder.findPeak(values);
		assertEquals(n, peak);
		ExecutionTimePrinter.print(peakFinder.getExecutionTime());
	}

}
