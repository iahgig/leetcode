import java.util.HashMap;
import java.util.Map;

public class leetcode437 {
    Map<Long, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        return pathSum(root, targetSum, 0);
    }

    public int pathSum(TreeNode root, int targetSum, long pre_sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        long cur_sum = pre_sum + root.val;
        res += map.getOrDefault(cur_sum - targetSum, 0);
        map.put(cur_sum, map.getOrDefault(cur_sum, 0) + 1);
        res += pathSum(root.left, targetSum, cur_sum);
        res += pathSum(root.right, targetSum, cur_sum);
        map.put(cur_sum, map.get(cur_sum) - 1);
        return res;
    }
}
