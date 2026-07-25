import java.util.HashMap;
import java.util.Map;

public class leetcode105_1 {
    private Map<Integer, Integer> mp;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        mp = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mp.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preleft, int preright, int inleft, int inright) {
        if (preleft > preright) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preleft]);
        int inmid = mp.get(root.val);
        int left_len = inmid - inleft;
        root.left = buildTree(preorder, inorder, preleft + 1, preleft + left_len, inleft, inmid - 1);
        root.right = buildTree(preorder, inorder, preleft + left_len + 1, preright, inmid + 1, inright);
        return root;
    }
}