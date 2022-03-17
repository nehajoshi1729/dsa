package stacks;

import java.util.Stack;

/**
 * get the innerScore between ( innerScore )
 * keep pushing the current score value in the stack itself whenever you get a balanced () { get a ( for a ) }
 * if innerScore == 0, push 1 in the stack else 2 * innerScore when you find "("
 * add all the scores to get the final score ==> ans
 */

public class ScoreOfParenthesis {
    public static int scoreOfParentheses(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty())
                stack.push(c + "");
            else {
                if (c == '(')
                    stack.push(c + "");

                else if (c == ')') {
                    int innerScore = 0;

                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        innerScore += Integer.valueOf(stack.peek());
                        stack.pop();
                    }

                    stack.pop();
                    if (innerScore == 0)
                        stack.push("1");
                    else
                        stack.push(2 * innerScore + "");
//                } else
//                    stack.push("(");
                }

            }
        }
        int score = 0;
        while (!stack.isEmpty()) {
            score += Integer.valueOf(stack.peek());
            stack.pop();

        }
        return score;
    }


    public static void main(String[] args) {
        //String s = "(())";
        String s = "()(())";
        System.out.println(scoreOfParentheses(s));

    }

}


