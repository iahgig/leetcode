import java.util.LinkedList;
import java.util.Queue;

public class leetcode101_2 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root.left);
        que.offer(root.right);
        while (!que.isEmpty()) {
            TreeNode left = que.poll();
            TreeNode right = que.poll();
            if (left != null && right != null && left.val == right.val) {
                que.offer(left.left);
                que.offer(right.right);
                que.offer(left.right);
                que.offer(right.left);
            } else if (left == null && right == null) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}