package trees;

import CommonLibrary.TreeNode;

public class ValidateBinarySearchTree {
    private boolean isValidBST(TreeNode root, int minValue, int maxValue) {
        if (root == null)
            return true;
        else if (root.val >= maxValue || root.val <= minValue)
            return false;
        else
            return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

}
