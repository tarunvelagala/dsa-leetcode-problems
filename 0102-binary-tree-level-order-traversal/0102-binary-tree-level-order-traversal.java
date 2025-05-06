/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public void levelOrderHelper(TreeNode root, List<List<Integer>> levelList, int position) {
        if (root == null) return;
        if (position >= levelList.size()) {
            levelList.add(new ArrayList<>());
        }
        levelList.get(position).add(root.val);
        levelOrderHelper(root.left, levelList, position + 1);
        levelOrderHelper(root.right, levelList, position + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        levelOrderHelper(root, levelList, 0);
        return levelList;
    }
}
