import java.util.HashMap;
import java.util.Map;

public class leetcode889 {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return constructFromPrePost(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder, int prel, int prer, int postl, int postr) {

        if (prel > prer) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prel]);
        if (prel == prer) {
            return root;
        }
        int left_num = map.get(preorder[prel + 1]) - postl + 1;
        root.left = constructFromPrePost(preorder, postorder, prel + 1, prel + left_num, postl, postl + left_num - 1);
        root.right = constructFromPrePost(preorder, postorder, prel + left_num + 1, prer, postl + left_num, postr - 1);
        return root;
    }
}