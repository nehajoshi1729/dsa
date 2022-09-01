package trees;

import CommonLibrary.TreeNode;

/**
 * a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 * return the count of good nodes
 * <p>
 * dfs
 * if the current root.val is the maxSoFar in that path, that's a Good Node
 * TC O(n)
 */

public class GoodNodes {
    public int get(TreeNode root) {
        if (root == null)
            return 0;
        int count = 1;
        count += dfs(root.right, root.val);
        count += dfs(root.left, root.val);
        return count;

    }

    private int dfs(TreeNode root, int maxSoFar) {
        int count = 0;
        if (root == null)
            return 0;
        if (root.val >= maxSoFar) {
            count++;
            maxSoFar = root.val;
        }
        count += dfs(root.left, maxSoFar);
        count += dfs(root.right, maxSoFar);
        return count;
    }

}
