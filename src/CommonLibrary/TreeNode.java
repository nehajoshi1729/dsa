package CommonLibrary;
/*
 * One node of a binary tree.
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode(int data) {
        val = data;
    }

    private void setLeftChild(TreeNode left) {
        this.left = left;
        if (left != null)
            left.parent = this;

    }

    private void setRightChild(TreeNode right) {
        this.right = right;
        if (right != null)
            right.parent = this;
    }

    public void insertInorder(int data) {
        if (data < val) {
            if (left == null)
                setLeftChild(new TreeNode(data));
            left.insertInorder(data);
        } else {
            if (right == null)
                setRightChild(new TreeNode(data));
            right.insertInorder(data);

        }

    }

//    public void insertPreorder(int data) {
//
//
//    }
//
//    public void insertPostorder(int data) {
//
//    }

    public boolean isBST() {
        if (left != null) {
            if (val < left.val || !left.isBST())
                return false;
        }
        if (right != null) {
            if (val > right.val || !right.isBST())
                return false;
        }
        return true;
    }

    public int height() {
        int leftSubTreeHeight = left != null ? left.height() : 0;
        int rightSubTreeHeight = right != null ? right.height() : 0;

        return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);

    }

    public TreeNode find(int data) {
        if (data == val)
            return this;
        else if (data <= val)

            return left != null ? left.find(data) : null;

        else if (data > val)
            return right != null ? right.find(data) : null;

        return null;
    }

    public static TreeNode createMinimalBST(int arr[], int start, int end) {
        if (end < start)
            return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(mid);
        node.setLeftChild(createMinimalBST(arr, start, mid - 1));
        node.setRightChild(createMinimalBST(arr, mid + 1, end));

        return node;

    }

    public static TreeNode createMinimalBST(int arr[]) {
        return createMinimalBST(arr, 0, arr.length);

    }



}
