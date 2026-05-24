public class FirstNonRepeatingChar {
    public static char firstNonRepeating(String s) {
        int[] count = new int[26]; // index 0='a', 1='b', ... 25='z'

        // Phase 1: count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // Phase 2: find first character with count == 1
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }

        return '_'; // no unique character found
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeating("leetcode")); // l
        System.out.println(firstNonRepeating("aabb"));     // _ (none)
        System.out.println(firstNonRepeating("swiss"));    // w
    }
}
