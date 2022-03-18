package stacks;

import java.util.Stack;

/**
 * at each index, we have to check things on both sides of the index ==> stack
 * also we will need to maintain last occurring indexes for every num, so that we can decide to pop it or not; as in ans all the char must be present with freq == 1
 * 1. check if stack.peek() > currentChar, if yes we need to check if stack.peek() occurs to the right of currentChar
 * 2. if 1 is yes we can pop stack.peek()
 * 3. if 1 is no we will have to keep stack.peek() and push currentChar on top of it
 */

public class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {
        int n = s.length();
        boolean visited[] = new boolean[26];
        int lastIndex[] = new int[26];


        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int currentChar = s.charAt(i) - 'a';
            if (visited[currentChar] == true)
                continue;
            visited[currentChar] = true;

            while (!stack.isEmpty() && stack.peek() > currentChar && lastIndex[stack.peek()] > i) {
                visited[stack.pop()] = false;

            }
            stack.push(currentChar);
        }
        StringBuilder ans = new StringBuilder();
        for (int letter : stack)
            ans.append((char) (letter + 'a'));

        return ans.toString();
    }

    public static void main(String[] args) {
//        String s = "bcabc";
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }
}
