import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class leetcode106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> st = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        st.push(root);
        for (int i = postorder.length - 2; i >= 0; i--) {
            TreeNode pre = null;
            TreeNode cur = new TreeNode(postorder[i]);
            int cur_index = map.get(cur.val);
            while (!st.isEmpty() && cur_index < map.get(st.peek().val)) {
                pre = st.pop();
            }
            if (pre == null) {
                st.peek().right = cur;
            } else {
                pre.left = cur;
            }
            st.push(cur);
        }
        return root;
    }
}