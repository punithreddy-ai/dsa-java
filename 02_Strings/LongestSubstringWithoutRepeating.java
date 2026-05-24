import java.util.HashSet;

public class LongestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // shrink window from left until duplicate is removed
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            // now c is safe to add
            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3 → "abc"
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1 → "b"
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3 → "wke"
        System.out.println(lengthOfLongestSubstring(""));         // 0
    }
}