package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * classic recursion + backtracking
 */

public class LetterCombinations {
    public static List<String> get(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return ans;
        String[] lettersMap = {"000", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(ans, new StringBuilder(), digits, lettersMap, 0);
        return ans;
    }

    private static void backtrack(List<String> res, StringBuilder stringBuilder, String digits, String[] lettersMap, int index) {
        if (index == digits.length()) {
            res.add(stringBuilder.toString());
            return;
        }
        int number = digits.charAt(index) - '0';
        String strNumber = lettersMap[number - 1];
        for (int i = 0; i < strNumber.length(); i++) {
            stringBuilder.append(strNumber.charAt(i));
            backtrack(res, stringBuilder, digits, lettersMap, index + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        }
    }

}
