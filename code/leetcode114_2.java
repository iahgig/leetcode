
public class leetcode114_2 {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode left_final = root.left;
                while (left_final.right != null) {
                    left_final = left_final.right;
                }
                left_final.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
