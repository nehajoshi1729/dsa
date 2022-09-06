package trees;

import CommonLibrary.TreeNode;

/**
 * Given the root of a binary tree,
 * return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 * not containing 1 : containing 0,return null (Node.val is either 0 or 1.)
 */

public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        // if(root.left != null || root.right != null || root.val == 1)
        //     return root;
        // return null;
        if (root.left == null && root.right == null && root.val == 0)
            return null;
        return root;

    }
}
