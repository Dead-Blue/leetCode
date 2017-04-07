package L_Minimum_Depth_of_Binary_Tree;

/**
 * Created by DeadBlue on 2017/4/7.
 */
/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class Main {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 && right == 0) {
            return 1;
        }
        left = left > 0 ? left + 1 : Integer.MAX_VALUE;
        right = right > 0 ? right + 1 : Integer.MAX_VALUE;
        return Math.min(left, right);
    }
}