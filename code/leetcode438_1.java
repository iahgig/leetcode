import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode438_1 {
    public List<Integer> findAnagrams(String s, String p) {
        int s_l = s.length();
        int p_l = p.length();
        if (s_l < p_l)
            return new ArrayList<Integer>();
        int[] p_count = new int[26];
        int[] s_count = new int[26];
        for (int i = 0; i < p_l; i++) {
            p_count[p.charAt(i) - 'a']++;
            s_count[s.charAt(i) - 'a']++;
        }
        List<Integer> ans = new ArrayList<Integer>();
        if (Arrays.equals(s_count, p_count)) {
            ans.add(0);
        }
        for (int i = 0; i < s_l - p_l; i++) {
            s_count[s.charAt(i) - 'a']--;
            s_count[s.charAt(i + p_l) - 'a']++;
            if (Arrays.equals(s_count, p_count)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
