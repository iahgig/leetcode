import java.util.HashMap;
import java.util.Map;

public class leetcode_3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int ans = 0;
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        // 字符的重复下标
        while (r < n) {
            char c = s.charAt(r);
            if (mp.containsKey(c) && mp.get(c) >= l) {
                // 对于以l为起点的子串，维护一个字符重复判别表，因此若存在一个字符重复位置在l之前，则认定此字符不重复
                ans = Math.max(ans, r - l);
                l = mp.get(c) + 1;
            }
            mp.put(c, r);
            r++;
        }
        ans = Math.max(ans, r - l);
        return ans;
    }
}
