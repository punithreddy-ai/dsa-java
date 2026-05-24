public class ReverseString {
    public static String reverse(String s) {
        char[] chars = s.toCharArray();   // convert to char array
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            // swap characters
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);         // convert back to String
    }

    public static void main(String[] args) {
        System.out.println(reverse("hello"));   // olleh
        System.out.println(reverse("java"));    // avaj
        System.out.println(reverse("abcde"));   // edcba
        System.out.println(reverse("a"));       // a
        System.out.println(reverse(""));        // (empty)
    }
}
