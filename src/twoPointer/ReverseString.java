package twoPointer;

/**
 * level 0 for two pointer technique
 * need to reverse the array in-place
 */

public class ReverseString {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i <= j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;

        }

    }
}
