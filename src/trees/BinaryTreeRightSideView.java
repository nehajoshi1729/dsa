package trees;

import CommonLibrary.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public void traverse(TreeNode node, int height, List<Integer> ans) {
        if (node == null)
            return;
        if (height == ans.size())
            ans.add(node.val);
        traverse(node.right, height + 1, ans);
        traverse(node.left, height + 1, ans);


    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverse(root, 0, ans);
        return ans;


    }
}
