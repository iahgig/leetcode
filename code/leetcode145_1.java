import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode145_1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode pre = null;
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.peek();
            if (root.right == null || root.right == pre) {
                res.add(root.val);
                st.pop();
                pre = root;
                root = null;
            } else {
                root = root.right;
            }
        }
        return res;
    }
}
