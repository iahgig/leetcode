import java.util.Stack;

public class leetcode98_2 {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        long pre = Long.MIN_VALUE;
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }
}
