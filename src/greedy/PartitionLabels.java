package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * we need lastIndexes of every char, and when all the char's lastIndexes are part of the substring break and add it to the answer
 * we want max partitions, so we need min chars in a string partition ===> greedy
 */

public class PartitionLabels {
    public static List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        List<Integer> ans = new ArrayList<>();
        int startIndex = -1;
        int maxLastIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            maxLastIndex = Math.max(maxLastIndex, map.get(current));
            if (maxLastIndex == i) {
                ans.add(maxLastIndex - startIndex);
                startIndex = maxLastIndex;
            }

        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
//        String s = "eccbbbbdec";
        System.out.println(partitionLabels(s));
    }


}
