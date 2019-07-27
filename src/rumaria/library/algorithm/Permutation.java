package rumaria.library.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutation {

	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		printPermutation(arr);
	}

	public static <T> List<List<T>> getPermutation(Collection<T> c) {
		Queue<T> q = new LinkedList<>();
		q.addAll(c);
		return permutate(q);
	}

	public static <T> List<List<T>> getPermutation(T[] array) {
		Queue<T> q = new LinkedList<>();
		q.addAll(Arrays.asList(array));
		return permutate(q);
	}

	private static <T> List<List<T>> permutate(Queue<T> q) {
		if (q.size() == 1) {
			List<List<T>> list = new ArrayList<>();
			List<T> list1 = new LinkedList<>();
			list1.add(q.poll());
			list.add(list1);
			return list;
		}
		return arrange(q.poll(), permutate(q));
	}

	private static <T> List<List<T>> arrange(T c, List<List<T>> list) {
		List<List<T>> listParent = new ArrayList<>();
		for (List<T> list2 : list) {
			for (int i = 0; i <= list2.size(); i++) {
				List<T> listChild = new LinkedList<>();
				listChild.addAll(list2);
				listChild.add(i, c);
				listParent.add(listChild);
			}
		}
		return listParent;
	}

	public static <T> void printPermutation(Collection<T> c) {
		List<List<T>> permutationList = getPermutation(c);
		for (List<T> list : permutationList) {
			for (T ch : list) {
				System.out.print(ch + ", ");
			}
			System.out.println();
		}
	}

	public static <T> void printPermutation(T[] array) {
		List<List<T>> permutationList = getPermutation(array);
		for (List<T> list : permutationList) {
			for (T ch : list) {
				System.out.print(ch + ", ");
			}
			System.out.println();
		}
	}
}
