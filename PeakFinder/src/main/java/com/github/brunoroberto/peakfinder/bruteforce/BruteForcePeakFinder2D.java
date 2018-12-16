package com.github.brunoroberto.peakfinder.bruteforce;

import com.github.brunoroberto.peakfinder.PeakFinder2D;

public class BruteForcePeakFinder2D<T extends Comparable<T>> extends PeakFinder2D<T> {

	@Override
	public T findPeak(T[][] values) {
		this.executionTime.start();
		try {
			for (int i = 0; i < values.length; i++)
				for (int j = 0; j < values[i].length; j++)
					if (isPeak(values, i, j))
						return values[i][j];
			return null;
		} finally {
			this.executionTime.stop();
		}
	}

}
