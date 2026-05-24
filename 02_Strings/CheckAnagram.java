public class CheckAnagram {
    public static boolean isAnagram(String s1, String s2) {
        // Step 1: lengths must match
        if (s1.length() != s2.length()) return false;

        int[] count = new int[26]; // one slot per letter a-z

        // Step 2: increment for s1, decrement for s2
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        // Step 3: all counts must be zero
        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent"));   // true
        System.out.println(isAnagram("hello", "world"));     // false
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car"));         // false
    }
}