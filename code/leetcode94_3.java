import java.util.ArrayList;
import java.util.List;

public class leetcode94_3 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        while (root != null) {
            if (root.left != null) {
                TreeNode left_final = root.left;
                while (left_final.right != null && left_final.right != root) {
                    left_final = left_final.right;
                }
                if (left_final.right == null) {
                    left_final.right = root;
                    root = root.left;
                } else {
                    res.add(root.val);
                    left_final.right = null;
                    root = root.right;
                }
            } else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}