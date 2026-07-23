import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode144_1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            root = root.right;
        }
        return res;
    }
}
