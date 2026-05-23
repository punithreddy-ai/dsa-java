public class CheckPalindrome {
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;   // mismatch found → not palindrome
            }
            left++;
            right--;
        }
        return true;    // all characters matched → palindrome
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar")); // true
        System.out.println(isPalindrome("hello"));   // false
        System.out.println(isPalindrome("madam"));   // true
        System.out.println(isPalindrome("a"));       // true  (single char)
        System.out.println(isPalindrome(""));        // true  (empty string)
    }
}