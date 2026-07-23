import java.util.ArrayList;
import java.util.List;

public class leetcode144_2 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        while (root != null) {
            if (root.left != null) {
                TreeNode left_final = root.left;
                while (left_final.right != null && left_final.right != root) {
                    left_final = left_final.right;
                }
                if (left_final.right == root) {
                    left_final.right = null;
                    root = root.right;
                } else {
                    left_final.right = root;
                    res.add(root.val);
                    root = root.left;
                }
            } else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}