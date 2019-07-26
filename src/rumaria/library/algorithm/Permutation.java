package rumaria.library.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutation {

	public static void main(String[] args) {
		Queue<Character> q = new LinkedList<>();
		q.add('1');
		q.add('2');
		q.add('3');
		q.add('4');
		q.add('5');
		printPermutation(q);
	}

	public static <T> List<List<T>> permutate(List<T> list) {
		Queue<T> q = new LinkedList<>();
		q.addAll(list);
		return permutate(q);
	}

	public static <T> List<List<T>> permutate(Queue<T> q) {
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

	public static <T> void printPermutation(Queue<T> q) {
		List<List<T>> permutationList = permutate(q);
		for (List<T> list : permutationList) {
			for (T ch : list) {
				System.out.print(ch + ", ");
			}
			System.out.println();
		}
	}
}
