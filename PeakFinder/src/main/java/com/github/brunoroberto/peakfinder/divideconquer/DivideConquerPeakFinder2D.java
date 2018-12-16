package com.github.brunoroberto.peakfinder.divideconquer;

import com.github.brunoroberto.peakfinder.PeakFinder2D;

public class DivideConquerPeakFinder2D<T extends Comparable<T>> extends PeakFinder2D<T> {

	@Override
	public T findPeak(T[][] values) {
		this.executionTime.start();
		try {
			if (values == null || values.length == 0)
				return null;
			return findPeak(values, values.length / 2, values[0].length / 2);
		} finally {
			this.executionTime.stop();
		}
	}

	private T findPeak(T[][] values, int row, int col) {
		MaxValue max = findGlobalMaximumValue(values[row]);
		if (row == 0 && isGreaterThan(max.getValue(), values[row + 1][max.getCol()]))
			return max.getValue();
		if (row == (values.length - 1) && isGreaterThan(max.getValue(), values[row - 1][max.getCol()]))
			return max.getValue();
		if (isGreaterThan(max.getValue(), values[row - 1][max.getCol()])
				&& isGreaterThan(max.getValue(), values[row + 1][max.getCol()]))
			return max.getValue();
		if (isGreaterThan(max.getValue(), values[row - 1][max.getCol()]))
			return findPeak(values, (values[row].length + row) / 2, col);
		return findPeak(values, row / 2, col);
	}

	private MaxValue findGlobalMaximumValue(T[] values) {
		if (values == null || values.length == 0)
			return null;
		MaxValue max = new MaxValue().setValue(values[0]).setCol(0);
		for (int i = 1; i < values.length; i++)
			if (!isGreaterThan(max.getValue(), values[i]))
				max.setValue(values[i]).setCol(i);
		return max;
	}

	private class MaxValue {

		private T value;
		private int col;

		public MaxValue setValue(T value) {
			this.value = value;
			return this;
		}

		public T getValue() {
			return this.value;
		}

		public MaxValue setCol(int col) {
			this.col = col;
			return this;
		}

		public int getCol() {
			return this.col;
		}

	}
}
