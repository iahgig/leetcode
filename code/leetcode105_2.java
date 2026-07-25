import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class leetcode105_2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> mp = new HashMap<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        for (int i = 0; i < inorder.length; i++) {
            mp.put(inorder[i], i);
        }
        TreeNode root = new TreeNode(preorder[0]);
        st.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode pre = null;
            TreeNode cur = new TreeNode(preorder[i]);
            int cur_index = mp.get(cur.val);
            while (!st.isEmpty() && cur_index > mp.get(st.peek().val)) {
                pre = st.pop();
            }
            if (pre == null) {
                st.peek().left = cur;
            } else {
                pre.right = cur;
            }
            st.push(cur);
        }
        return root;
    }
}
