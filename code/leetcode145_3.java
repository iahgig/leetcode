import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leetcode145_3 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        while (root != null) {
            if (root.right != null) {
                TreeNode right_final = root.right;
                while (right_final.left != null && right_final.left != root) {
                    right_final = right_final.left;
                }
                if (right_final.left == null) {
                    res.add(root.val);
                    right_final.left = root;
                    root = root.right;
                } else {
                    right_final.left = null;
                    root = root.left;
                }
            } else {
                res.add(root.val);
                root = root.left;
            }
        }
        Collections.reverse(res);
        return res;
    }
}
