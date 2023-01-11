package trees;

import CommonLibrary.TreeNode;

public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        else if (p.val != q.val)
            return true;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}
