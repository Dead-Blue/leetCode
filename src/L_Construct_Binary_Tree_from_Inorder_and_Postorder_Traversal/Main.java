package L_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by DeadBlue on 2017/4/8.
 */
/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.


 */
public class Main {
    public static void main(String[] args) {
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(inorder, postorder);

        System.out.println("ok");
    }
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
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inorderLen = inorder.length;
        int len = postorder.length;
        if (inorderLen == 0) {
            return null;
        }
        for (int i = 0; i < inorderLen; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = build(inorder, postorder, 0, inorderLen, 0, len);
        return root;
    }

    public TreeNode build(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int postOrderStart, int postOrderEnd) {
        int len = postOrderEnd - postOrderStart;
        int inorderLen = inorderEnd - inorderStart;
        if (inorderLen == 0 || len == 0) {
            return null;
        }
        int rootValue = postorder[postOrderStart + len - 1];
        int index = 0;
        index = map.get(rootValue) - inorderStart;
        TreeNode root = new TreeNode(rootValue);
        if (index > 0) {
            root.left = build(inorder, postorder, inorderStart, inorderStart + index, postOrderStart, postOrderStart + index);
        } else {
            root.left = null;
        }
        if (index < inorderLen - 1) {
            root.right = build(inorder, postorder, inorderStart + index + 1, inorderEnd, postOrderStart + index, postOrderEnd - 1);
        } else {
            root.right = null;
        }
        return root;
    }
}