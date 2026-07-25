import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode145_2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                res.addFirst(root.val);
                st.push(root);
                root = root.right;
            }
            root = st.pop();
            root = root.left;
        }
        return res;
    }
}
