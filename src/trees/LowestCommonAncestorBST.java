package trees;

import CommonLibrary.TreeNode;

/**
 * BST is sorted
 *  either root.val is greater than p & q ; go left subtree
 *  either root.val is lesser than p & q ; go right subtree
 *  if root.val is in between p and q => root is in between => LowestCommonAncestor
 *
 */

public class LowestCommonAncestorBST {
    public TreeNode get(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val)
            return get(root.left, p, q);
        else if (root.val < p.val && root.val < q.val)
            return get(root.right, p, q);
        else
            return root;

    }
}
