package com.github.brunoroberto.peakfinder;

import com.github.brunoroberto.peakfinder.time.ExecutionTime;

/**
 * 
 * Suppose a two dimension array A of NxM elements
 * 
 * Peak definition: position [i, j] is a peak if and only if A[i][j] >= A[i][j -
 * 1] and A[i][j] >= A[i][j + 1] and A[i][j] >= A[i - 1][j] and A[i][j] >= A[i +
 * 1][j]. When the [i, j] position is in the corners we must check only the
 * others three sides
 * 
 * Problem: find a peak if it exists
 * 
 * @author micro
 *
 * @param <T>
 */
public abstract class PeakFinder2D<T extends Comparable<T>> {

	protected ExecutionTime executionTime = new ExecutionTime();

	public ExecutionTime getExecutionTime() {
		return this.executionTime;
	}

	protected boolean isPeak(T[][] values, int i, int j) {
		if (isLeftTopCorner(i, j))
			return isGreaterThan(values[i][j], values[i][j + 1]) && isGreaterThan(values[i][j], values[i + 1][j]);
		if (isLeftBottomCorner(i, j, values.length))
			return isGreaterThan(values[i][j], values[i][j + 1]) && isGreaterThan(values[i][j], values[i - 1][j]);
		if (isRightTopCorner(i, j, values[i].length))
			return isGreaterThan(values[i][j], values[i][j - 1]) && isGreaterThan(values[i][j], values[i + 1][j]);
		if (isRightBottomCorner(i, j, values.length, values[i].length))
			return isGreaterThan(values[i][j], values[i][j - 1]) && isGreaterThan(values[i][j], values[i - 1][j]);
		if (isTopCorner(i))
			return isGreaterThan(values[i][j], values[i][j + 1]) && isGreaterThan(values[i][j], values[i + 1][j])
					&& isGreaterThan(values[i][j], values[i][j - 1]);
		if (isBottomCorner(i, values.length))
			return isGreaterThan(values[i][j], values[i][j + 1]) && isGreaterThan(values[i][j], values[i - 1][j])
					&& isGreaterThan(values[i][j], values[i][j - 1]);
		if (isLeftCorner(j))
			return isGreaterThan(values[i][j], values[i - 1][j]) && isGreaterThan(values[i][j], values[i][j + 1])
					&& isGreaterThan(values[i][j], values[i + 1][j]);
		if (isRightCorner(j, values[i].length))
			return isGreaterThan(values[i][j], values[i - 1][j]) && isGreaterThan(values[i][j], values[i][j - 1])
					&& isGreaterThan(values[i][j], values[i + 1][j]);
		return isGreaterThan(values[i][j], values[i - 1][j]) && isGreaterThan(values[i][j], values[i][j + 1])
				&& isGreaterThan(values[i][j], values[i + 1][j]) && isGreaterThan(values[i][j], values[i][j - 1]);
	}

	protected boolean isGreaterThan(T o1, T o2) {
		return o1.compareTo(o2) >= 0;
	}

	protected boolean isTopCorner(int row) {
		return (row == 0);
	}

	protected boolean isBottomCorner(int row, int nLength) {
		return (row == (nLength - 1));
	}

	protected boolean isLeftCorner(int column) {
		return (column == 0);
	}

	protected boolean isRightCorner(int column, int mLength) {
		return (column == (mLength - 1));
	}

	protected boolean isLeftTopCorner(int row, int column) {
		return (row == 0 && column == 0);
	}

	protected boolean isRightTopCorner(int row, int column, int mLength) {
		return (row == 0 && (column == (mLength - 1)));
	}

	protected boolean isLeftBottomCorner(int row, int column, int nLength) {
		return (row == (nLength - 1) && column == 0);
	}

	protected boolean isRightBottomCorner(int row, int column, int nLength, int mLength) {
		return (row == (nLength - 1) && column == (mLength - 1));
	}

	public abstract T findPeak(T[][] values);

}
