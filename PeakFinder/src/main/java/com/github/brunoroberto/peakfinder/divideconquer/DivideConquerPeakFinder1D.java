package com.github.brunoroberto.peakfinder.divideconquer;

import com.github.brunoroberto.peakfinder.PeakFinder1D;

public class DivideConquerPeakFinder1D<T extends Comparable<T>> extends PeakFinder1D<T> {

	@Override
	public T findPeak(T[] values) {
		this.executionTime.start();
		try {
			if (values == null || values.length == 0)
				return null;
			return findPeak(values, values.length / 2);
		} finally {
			this.executionTime.stop();
		}
	}

	private T findPeak(T[] values, int index) {
		if (isPeak(values, index))
			return values[index];
		if (isGreaterThan(values[index], values[index - 1]))
			return findPeak(values, (index + values.length) / 2);
		return findPeak(values, index / 2);
	}

}
