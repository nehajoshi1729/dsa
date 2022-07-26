package trees;

import CommonLibrary.TreeNode;

/**
 * Based on a premise that there will be only one LowestCommonAncestor
 * Traverse until you find p and q
 * Return p / q if found or return null
 * if left and right for a root turn out to be non-null (they will be p and q indeed), return that root as ans
 * TC O(n)
 */

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return root;
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode != null && rightNode != null)
            return root;
        if (leftNode != null)
            return leftNode;
        if (rightNode != null)
            return rightNode;
        return null;

    }
}
