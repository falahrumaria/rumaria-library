package ovo.test;

import java.util.LinkedList;
import java.util.Queue;

public class SortTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 1, 13, 20, 30, 90, 100 };
		int[] arr2 = { 11, 22 };
		printArray(sortTwoArrays(arr1, arr2));
	}

	// tes ovo
	private static int[] sortTwoArrays(int[] arr1, int[] arr2) {
		int[] combinedArr = new int[arr1.length + arr2.length];
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		for (int i = 0; i < arr1.length; i++) {
			q1.add(arr1[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			q2.add(arr2[i]);
		}
		for (int i = 0; i < combinedArr.length; i++) {
			if (q1.isEmpty()) {
				combinedArr[i] = q2.poll();
			} else if (q2.isEmpty()) {
				combinedArr[i] = q1.poll();
			} else {
				combinedArr[i] = q1.peek() < q2.peek() ? q1.poll() : q2.poll();
			}
		}
		return combinedArr;
	}

	private static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}

}
