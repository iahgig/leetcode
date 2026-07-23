import java.util.Stack;

public class leetcode114_1 {
    public void flatten(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode dummy = new TreeNode(-1);
        TreeNode pre = dummy;
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                pre.right = root;
                pre = root;
                st.push(root.right);
                root = root.left;
                pre.left = null;
            }
            root = st.pop();
        }
    }
}
