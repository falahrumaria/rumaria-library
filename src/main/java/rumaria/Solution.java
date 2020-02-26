package rumaria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
        Map<String, char[]> map = new HashMap<>();
        map.put("2", new char[]{'a', 'b', 'c'});
        map.put("3", new char[]{'d', 'e', 'f'});
        map.put("4", new char[]{'g', 'h', 'i'});
        map.put("5", new char[]{'j', 'k', 'l'});
        map.put("6", new char[]{'m', 'n', 'o'});
        map.put("7", new char[]{'p', 'q', 'r', 's'});
        map.put("8", new char[]{'t', 'u', 'v'});
        map.put("9", new char[]{'w', 'x', 'y', 'z'});


    }

    private List<String> combineLetterGroups(char[]... letterGroups) {
        StringBuilder sb = new StringBuilder();
        int len = letterGroups.length;
        int index = 0;
        for (int i = 0; i < letterGroups[index].length; i++) {

        }
    }
}