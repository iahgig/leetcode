import java.util.*;

public class leetcode_49_1{
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);// 排序后的字符串
            List<String> list = mp.getOrDefault(key, new ArrayList<String>());
            list.add(strs[i]);
            mp.put(key, list);
        }
        return new ArrayList<List<String>>(mp.values());
    }
}
