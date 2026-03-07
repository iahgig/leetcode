import java.util.HashMap;
import java.util.Map;

public class leetcode_128_1{
    public int search(Map<Integer, Integer> mp, int i) {
        // 返回以i为起始的最大连续序列长度
        int len = 0;
        if (mp.containsKey(i)) {
            len = mp.get(i);
            if (len == 0) {
                len = search(mp, i + 1) + 1;
                mp.put(i, len);
            }
        }
        return len;
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        // mp[i]表示以i为起始的最大连续序列长度
        for (int i : nums) {
            mp.put(i, 0);
        }
        int max_len = 0;
        for (int i : mp.keySet()) {
            int len = search(mp, i);
            max_len = max_len > len ? max_len : len;
        }
        return max_len;
    }
}
