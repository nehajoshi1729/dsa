package trees;
/**
 * BFS traversal the tree and compute average on every level
 */

import CommonLibrary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> level = new LinkedList<>();
        if (root == null)
            return ans;
        level.add(root);
        while (!level.isEmpty()) {
            int sizeOfLevel = level.size();
            double sumOfLevel = 0.0;
            for (int i = 0; i < sizeOfLevel; i++) {
                TreeNode node = level.poll();
                sumOfLevel += node.val;
                if (node.left != null)
                    level.offer(node.left);
                if (node.right != null)
                    level.offer(node.right);

            }
            ans.add(sumOfLevel / sizeOfLevel);
        }
    return ans;

    }

}
