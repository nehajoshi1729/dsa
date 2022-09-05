package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class NaryTreeTraversal extends Node {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null)
            return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> currentLevel = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) { //level order traversal
                Node node = queue.poll();
                currentLevel.add(node.val);
                for (Node c : node.children) {
                    queue.offer(c);
                }
            }
            ans.add(currentLevel); //add as a list after every level
        }
        return ans;

    }


}
