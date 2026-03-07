import java.util.HashMap;
import java.util.Map;

public class leetcode_128_2 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        // mp[i]表示边界i的对应边界，内部元素无意义置为-1,表示被包含
        int max_len = 0;
        for (int i : nums) {
            if (!mp.containsKey(i)) {
                int len = 0;
                int l = mp.getOrDefault(i - 1, i);
                int r = mp.getOrDefault(i + 1, i);
                mp.put(l, r);// 修改左边界的对应右边界
                mp.put(r, l);// 修改右边界的对应左边界
                if (i != l && i != r)
                    mp.put(i, -1);
                len = r - l + 1;
                max_len = max_len > len ? max_len : len;
            }
        }
        return max_len;
    }
}
