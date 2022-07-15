package trees;

import CommonLibrary.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * we need both preorder and inorder traversals to create a unique binary tree
 * we get the root value from preorder
 * split the remaining nodes into left and right subtrees using inorder (get root position in inorder) recursively
 */
public class ConstructTreeFromPreAndInOrder {
    private TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderValueIndexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            //[value,index]
            inOrderValueIndexMap.put(inorder[i], i);
        }
        TreeNode root = build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inOrderValueIndexMap);
        return root;

    }

    private TreeNode build(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> inOrderValueIndexMap) {
        if (preorderStart > preorderEnd || inorderStart > inorderEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preorderStart]);
        int inorderRootIndex = inOrderValueIndexMap.get(root.val);
        int numsLeft = inorderRootIndex - inorderStart;
        root.left = build(preorder, preorderStart + 1, preorderStart + numsLeft, inorder, inorderStart, inorderRootIndex - 1, inOrderValueIndexMap);
        root.right = build(preorder, preorderStart + 1 + numsLeft, preorderEnd, inorder, inorderRootIndex + 1, inorderEnd, inOrderValueIndexMap);
        return root;


    }
}
