package trees;

import CommonLibrary.TreeNode;

public class Traversals {
    public static void visit(TreeNode treeNode) {
        if (treeNode != null)
            System.out.println(treeNode.val);
    }

    public static void inOrderTraversal(TreeNode treeNode) {
        if (treeNode != null) {
            inOrderTraversal(treeNode.left);
            visit(treeNode);
            inOrderTraversal(treeNode.right);
        }
    }

    public static void preOrderTraversal(TreeNode treeNode) {
        if (treeNode != null) {
            visit(treeNode);
            preOrderTraversal(treeNode.left);
            preOrderTraversal(treeNode.right);
        }
    }
    public static void postOrderTraversal(TreeNode treeNode)
    {
        if(treeNode != null)
        {
            postOrderTraversal(treeNode.left);
            postOrderTraversal(treeNode.right);
            visit(treeNode);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,4,6,7,1};
        TreeNode root = TreeNode.createMinimalBST(arr);
        inOrderTraversal(root);
    }
}
