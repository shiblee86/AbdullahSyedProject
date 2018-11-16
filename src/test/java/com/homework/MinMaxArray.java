package com.homework;

public class MinMaxArray {

	public static void main(String[] args) {

		// Create an Array

		int bucket[] = new int[100];

		// Fill the array with Values

		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = i;

			System.out.println(i);
		}

		System.out.println(getMinValue(bucket) + " this is the smallest value in the bucket");
		System.out.println(getMaxValue(bucket) + " this is the largest value in the bucket");

	}

	// Get minimum value from Array
	public static int getMinValue(int[] bucket) {
		int minValue = bucket[0];
		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i] < minValue) {
				minValue = bucket[i];
			}
		}
		return minValue;
	}

	// Get Maximum Value from an Array
	public static int getMaxValue(int[] bucket) {
		int maxValue = bucket[0];
		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i] > maxValue) {
				maxValue = bucket[i];
			}
		}
		return maxValue;
	}
}
