package twoPointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseStringVowels {
    public String reverseVowels(String s) {
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] inputArray = s.toCharArray();
        int left = 0;
        int right = inputArray.length - 1;
        while (left < right) {
            if (!vowelSet.contains(inputArray[left]))
                left++;
            else if (!vowelSet.contains(inputArray[right]))
                right--;
            else {
                char temp = inputArray[left];
                inputArray[left] = inputArray[right];
                inputArray[right] = temp;
                left++;
                right--;
            }

        }
        return new String(inputArray);
    }
}
