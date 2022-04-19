package trees;

import CommonLibrary.TreeNode;

/**
 * exactly two of the nodes in a BST are swapped, fix the BST
 *      -- inOrder traversal of a BST is sorted
 *      -- post inOrder traversal we'll find two nodes which are not in order
 *      -- store those nodes and swap their values later
 */

public class RecoverBST {
    TreeNode prev = null;
    TreeNode firstSwappedNode = null;
    TreeNode secondSwappedNode = null;

    private void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        if (prev != null && prev.val > root.val) {
            if (firstSwappedNode == null)
                firstSwappedNode = prev;
            secondSwappedNode = root;

        }
        prev = root;
        inOrderTraversal(root.right);

    }

    public void recover(TreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root);
        int temp = firstSwappedNode.val;
        firstSwappedNode.val = secondSwappedNode.val;
        secondSwappedNode.val = temp;
    }


}
