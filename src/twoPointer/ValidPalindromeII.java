package twoPointer;

/**
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 * classic two pointer
 */

public class ValidPalindromeII {
    private static boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else
                return false;
        }
        return true;
    }

    private static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(validPalindrome(s));
    }
}
