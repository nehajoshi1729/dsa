package stacks;

import java.util.*;

/**
 * design a stack like data structure such that -
 * 1. void push(int val) pushes an integer val onto the top of the stack.
 * 2. int pop() removes and returns the most frequent element in the stack.
 * If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 * <p>
 * we will need a list of stack and hashmap (to store the current freq of any char)
 * list will be indexed based on frequencies, i.e index = 0 means frequency 1 characters
 * use a stack so that we know the order in which we are adding to same freq chars => this will be useful for the rule 2 above
 */

public class MaximumFrequencyStack {
    List<Stack<Integer>> stackList = null;
    Map<Integer, Integer> map = null;

    public MaximumFrequencyStack() {
        map = new HashMap<>();
        stackList = new ArrayList<>();

    }

    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        int freq = map.get(val);
        if (freq - 1 >= stackList.size())
            stackList.add(new Stack<Integer>());
        stackList.get(freq - 1).add(val);


    }

    public int pop() {
        int val = stackList.get(stackList.size() - 1).pop();
        if (stackList.get(stackList.size() - 1).empty())
            stackList.remove(stackList.size() - 1);
        map.put(val, map.get(val) - 1);
        if (map.get(val) == 0)
            map.remove(val);
        return val;


    }

    public static void main(String[] args) {

        MaximumFrequencyStack obj = new MaximumFrequencyStack();
        obj.push(5);
        obj.push(7);
        obj.push(5);
        obj.push(7);
        obj.push(4);
        obj.push(5);
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
        System.out.println(obj.stackList);


    }
}
