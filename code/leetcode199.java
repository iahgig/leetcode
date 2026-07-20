import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode199 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        que.offer(root);
        while (!que.isEmpty()) {
            int cnt = que.size();
            for (int i = 0; i < cnt; i++) {
                root = que.poll();
                if (root.left != null) {
                    que.offer(root.left);
                }
                if (root.right != null) {
                    que.offer(root.right);
                }
                if (i == cnt - 1) {
                    res.add(root.val);
                }
            }
        }
        return res;
    }
}
