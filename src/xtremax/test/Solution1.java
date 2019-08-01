package xtremax.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution1 {
    public static void main(String[] args) {
        String str = "   we   test codersu    ";
        System.out.println(solution(str));
    }

    public static String solution(String S) {
        List<Stack<Character>> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == ' ') {
                if (!stack.isEmpty()) {
                    list.add(stack);
                    stack = new Stack<>();
                }
                continue;
            }
            stack.push(S.charAt(i));
        }
        if (!stack.isEmpty()) {
            list.add(stack);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            while (!list.get(i).isEmpty()) {
                sb.append(list.get(i).pop());
            }
            if (i < list.size() - 1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
