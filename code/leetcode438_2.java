import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode438_2 {
    public List<Integer> findAnagrams(String s, String p) {
        int s_l = s.length();
        int p_l = p.length();
        if (s_l < p_l)
            return new ArrayList<Integer>();
        int[] count = new int[26];
        for (int i = 0; i < p_l; i++) {
            count[p.charAt(i) - 'a']--;
            count[s.charAt(i) - 'a']++;
        }
        int differ = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0)
                differ++;
        }
        List<Integer> ans = new ArrayList<Integer>();
        if (differ == 0) {
            ans.add(0);
        }
        for (int i = 0; i < s_l - p_l; i++) {
            if (count[s.charAt(i) - 'a'] == 0)
                differ++;
            if (count[s.charAt(i) - 'a'] == 1)
                differ--;
            count[s.charAt(i) - 'a']--;
            if (count[s.charAt(i + p_l) - 'a'] == 0)
                differ++;
            if (count[s.charAt(i + p_l) - 'a'] == -1)
                differ--;
            count[s.charAt(i + p_l) - 'a']++;
            if (differ == 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
