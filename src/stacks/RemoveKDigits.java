package stacks;

import java.util.Stack;

/**
 * brute force way - just slide and remove k digits and get the min number -> O(k* n)
 * to optimise think in the greedy way, we would want to remove the larger numbers
 * need a mechanism to remove the larger numbers and preserve the order -->
 * all smaller nos ----- all larger numbers
 */

public class RemoveKDigits {
    public static String removeKDigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        for (; i < num.length() && k > 0; i++) {
            while (k > 0 && !stack.isEmpty() && num.charAt(i) < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));

        }
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        ans = ans + num.substring(i);

        int j = 0;
        while (j < ans.length()) {
            if (ans.charAt(j) == '0') {
                j++;
            } else
                break;

        }
        return ans.substring(j).length() == 0 ? "0" : ans.substring(j);

    }

    public static void main(String[] args) {
        System.out.println(removeKDigits("1432219", 3));
        //System.out.println(removeKDigits("14532219",3));

    }
}


