import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode236_1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> road1 = new ArrayDeque<>();
        Deque<TreeNode> road2 = new ArrayDeque<>();
        dfs(root, p, road1);
        dfs(root, q, road2);
        while (road1.size() > road2.size()) {
            road1.pop();
        }
        while (road2.size() > road1.size()) {
            road2.pop();
        }
        while (road1.peek() != road2.peek()) {
            road1.pop();
            road2.pop();
        }
        return road1.peek();
    }

    boolean dfs(TreeNode root, TreeNode p, Deque<TreeNode> road) {
        if (root == null) {
            return false;
        }
        road.push(root);
        if (root == p) {
            return true;
        }
        if (dfs(root.left, p, road) || dfs(root.right, p, road)) {
            return true;
        }
        road.pop();
        return false;
    }
}
