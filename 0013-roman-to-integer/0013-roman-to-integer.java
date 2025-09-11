import java.util.*;

class Solution {

    // Convert Integer -> Roman
    public String intToRoman(int num) {
        int[] intValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] rom    = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < intValues.length; i++) {
            while (num >= intValues[i]) {
                sb.append(rom[i]);
                num -= intValues[i];
            }
        }
        return sb.toString();
    }

    // Convert Roman -> Integer
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = map.get(s.charAt(i));
            if (curr < prev) {
                total -= curr;
            } else {
                total += curr;
            }
            prev = curr;
        }
        return total;
    }

    // Test driver
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Integer -> Roman
        System.out.println(sol.intToRoman(3));    // III
        System.out.println(sol.intToRoman(58));   // LVIII
        System.out.println(sol.intToRoman(1994)); // MCMXCIV

        // Roman -> Integer
        System.out.println(sol.romanToInt("III"));     // 3
        System.out.println(sol.romanToInt("LVIII"));   // 58
        System.out.println(sol.romanToInt("MCMXCIV")); // 1994
    }
}
