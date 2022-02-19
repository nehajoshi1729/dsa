package trees;

import CommonLibrary.TreeNode;

/**
 * balanced tree : in a binary tree for every node, the height diff of left subtree and right subtree must be <= 1
 */

public class CheckIfBalanced {
    private static int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(getHeight(root.left), getHeight(root.left));
    }

    private static boolean checkIfBalanced(TreeNode root) {
        if (root == null)
            return false;
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1)
            return false;
        return checkIfBalanced(root.right) && checkIfBalanced(root.left);

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        TreeNode root = TreeNode.createMinimalBST(array);
        System.out.println("Root? " + root.val);
        System.out.println("Is balanced? " + checkIfBalanced(root));

//         Could be balanced, actually, but it's very unlikely...
        TreeNode unbalanced = new TreeNode(10);
        for (int i = 0; i < 10; i++) {
            unbalanced.insertInorder(i);
        }
        System.out.println("Root? " + unbalanced.val);
        System.out.println("Is balanced? " + checkIfBalanced(unbalanced));


    }
}

