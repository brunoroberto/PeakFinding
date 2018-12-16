package com.github.brunoroberto.peakfinder.bruteforce;

import com.github.brunoroberto.peakfinder.PeakFinder1D;

public class BruteForcePeakFinder1D<T extends Comparable<T>> extends PeakFinder1D<T> {

	@Override
	public T findPeak(T[] values) {
		this.executionTime.start();
		try {
			if (values == null)
				return null;

			for (int i = 0; i < values.length; i++)
				if (isPeak(values, i))
					return values[i];
			return null;
		} finally {
			this.executionTime.stop();
		}

	}

}
