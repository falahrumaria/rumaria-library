package rumaria.library;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

    public static void main(String[] args) {
        int num = 2572;
        System.out.println(intToRoman(num));
        System.out.println(romanToInt(intToRoman(num)));
    }

    public static int romanToInt(String s) {
        final Map<Character, Integer> map = new HashMap<Character, Integer>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int allSum = 0;
        int num;
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            num = map.get(ch);
            switch (ch) {
                case 'I':
                    i++;
                    if (i < s.length() && (s.charAt(i) == 'V' || s.charAt(i) == 'X')) {
                        allSum += map.get(s.charAt(i)) - num;
                        i++;
                    } else {
                        allSum += num;
                    }
                    break;
                case 'X':
                    i++;
                    if (i < s.length() && (s.charAt(i) == 'L' || s.charAt(i) == 'C')) {
                        allSum += map.get(s.charAt(i)) - num;
                        i++;
                    } else {
                        allSum += num;
                    }
                    break;
                case 'C':
                    i++;
                    if (i < s.length() && (s.charAt(i) == 'D' || s.charAt(i) == 'M')) {
                        allSum += map.get(s.charAt(i)) - num;
                        i++;
                    } else {
                        allSum += num;
                    }
                    break;
                default:
                    allSum += num;
                    i++;
                    break;
            }
        }
        return allSum;
    }

    public static String intToRoman(int num) {
        final Map<Byte, char[]> map = new HashMap<Byte, char[]>() {
            {
                put((byte) 0, new char[]{'I', 'V', 'X'});
                put((byte) 1, new char[]{'X', 'L', 'C'});
                put((byte) 2, new char[]{'C', 'D', 'M'});
                put((byte) 3, new char[]{'M', 'M', 'M'});
            }
        };
        String numAsStr = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numAsStr.length(); i++) {
            char ch = numAsStr.charAt(i);
            byte key = (byte) (numAsStr.length() - 1 - i);
            switch (ch) {
                case '1':
                    sb.append(map.get(key)[0]);
                    break;
                case '2':
                    sb.append(map.get(key)[0]).append(map.get(key)[0]);
                    break;
                case '3':
                    sb.append(map.get(key)[0]).append(map.get(key)[0]).append(map.get(key)[0]);
                    break;
                case '4':
                    sb.append(map.get(key)[0]);
                case '5':
                    sb.append(map.get(key)[1]);
                    break;
                case '6':
                    sb.append(map.get(key)[1]).append(map.get(key)[0]);
                    break;
                case '7':
                    sb.append(map.get(key)[1]).append(map.get(key)[0]).append(map.get(key)[0]);
                    break;
                case '8':
                    sb.append(map.get(key)[1]).append(map.get(key)[0]).append(map.get(key)[0]).append(map.get(key)[0]);
                    break;
                case '9':
                    sb.append(map.get(key)[0]).append(map.get(key)[2]);
                    break;
                default:
                    break;
            }
        }
        return sb.toString();
    }
}
