package com.github.brunoroberto.peakfinder;

import com.github.brunoroberto.peakfinder.time.ExecutionTime;

/**
 * 
 * Suppose an one dimension array A of N elements
 * 
 * Peak definition: position i is a peak if and only if A[i] >= A[i - 1] and
 * A[i] >= A[i + 1]. When the i position is in the corners we must check only
 * one side
 * 
 * Problem: find a peak if it exists
 * 
 * @author brunoroberto
 *
 * @param <T>
 */
public abstract class PeakFinder1D<T extends Comparable<T>> {

	protected ExecutionTime executionTime = new ExecutionTime();

	public ExecutionTime getExecutionTime() {
		return this.executionTime;
	}

	protected boolean isPeak(T[] values, int index) {
		if (values.length == 1)
			return true;
		if (isLeftCorner(index))
			return isGreaterThan(values[index], values[index + 1]);
		if (isRightCorner(index, values.length))
			return isGreaterThan(values[index], values[index - 1]);
		return isGreaterThan(values[index], values[index + 1]) && isGreaterThan(values[index], values[index - 1]);
	}

	protected boolean isGreaterThan(T o1, T o2) {
		return o1.compareTo(o2) >= 0;
	}

	protected boolean isLeftCorner(int index) {
		return (index == 0);
	}

	protected boolean isRightCorner(int index, int length) {
		return (index == (length - 1));
	}

	public abstract T findPeak(T[] values);

}
