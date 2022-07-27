package trees;

import CommonLibrary.TreeNode;

/**
 * Flatten a Binary tree to a linkedlist, you cannot create a new LL but have to modify the existing tree
 * Output will be sequenced as in order traversal
 * <p>
 * left child's, rightmost node connect to right child
 * root.right will be left child
 * root.left will be null
 */

public class FlattenBinaryTree {
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;
        preOrderTraversalHelper(root);

    }


    private TreeNode preOrderTraversalHelper(TreeNode root) {
        if(root == null)
            return null;
        TreeNode leftChild = preOrderTraversalHelper(root.left);
        TreeNode rightChild = preOrderTraversalHelper(root.right);
        TreeNode rightMostLeftChild = leftChild;
        while (rightMostLeftChild != null && rightMostLeftChild.right != null)
            rightMostLeftChild = rightMostLeftChild.right;
        if (rightMostLeftChild != null) {
            rightMostLeftChild.right = rightChild;
            root.right = leftChild;
            root.left = null;
        }

        return root;
    }
}
