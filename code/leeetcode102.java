import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leeetcode102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root == null) {
            return res;
        }
        que.offer(root);
        while (!que.isEmpty()) {
            int cnt = que.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                root = que.poll();
                temp.add(root.val);
                if (root.left != null) {
                    que.offer(root.left);
                }
                if (root.right != null) {
                    que.offer(root.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}