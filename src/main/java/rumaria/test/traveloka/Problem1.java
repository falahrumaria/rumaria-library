package rumaria.test.traveloka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1 {
    public static void main(String[] args) {
        //
    }

    public static char slowestKey(List<List<Integer>> keyTimes) {
        // Write your code here
        Map<Integer, Character> map = new HashMap<>();
        map.put(0, 'a');
        map.put(1, 'b');
        map.put(2, 'c');
        map.put(3, 'd');
        map.put(4, 'e');
        map.put(5, 'f');
        map.put(6, 'g');
        map.put(7, 'h');
        map.put(8, 'i');
        map.put(9, 'j');
        map.put(10, 'k');
        map.put(11, 'l');
        map.put(12, 'm');
        map.put(13, 'n');
        map.put(14, 'o');
        map.put(15, 'p');
        map.put(16, 'q');
        map.put(17, 'r');
        map.put(18, 's');
        map.put(19, 't');
        map.put(20, 'u');
        map.put(21, 'v');
        map.put(22, 'w');
        map.put(23, 'x');
        map.put(24, 'y');
        map.put(25, 'z');
        int longestTime = 0;
        int key = 0;
        for (int i = 0; i < keyTimes.size(); i++) {
            final List<Integer> keyTime = keyTimes.get(i);
            if (i == 0) {
                key = keyTime.get(0);
                longestTime = keyTime.get(1);
                continue;
            }
            int time = keyTime.get(1) - keyTimes.get(i - 1).get(1);
            if (time > longestTime) {
                key = keyTime.get(0);
                longestTime = time;
            }
        }
        return map.get(key);
    }

    public static int minimumGroups(List<Integer> predators) {
        // Write your code here
        // search the top
        List<Integer> topList = new ArrayList<>();
        for (int i = 0; i < predators.size(); i++) {
            if (predators.get(i) == -1) {
                topList.add(predators.get(i));
            }
        }
        List<Integer> currentList = topList;
        while (currentList.stream().anyMatch(x -> predators.contains(x))) {
            List<Integer> directChildrenList = new ArrayList<>();
            for (Integer x : currentList) {
                for (int i = 0; i < predators.size(); i++) {
                    if (predators.get(i) == x) directChildrenList.add(i);
                }
            }
        }
        return 0;
    }
}
