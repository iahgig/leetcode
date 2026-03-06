import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_49_2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(count[i]);
                }
            }
            String key = sb.toString();
            List<String> list = mp.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            mp.put(key, list);
        }
        return new ArrayList<List<String>>(mp.values());
    }
}
