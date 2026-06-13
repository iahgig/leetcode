public class leetcode76_2 {
    public String minWindow(String s, String t) {
        int slen = s.length();
        int l = 0;
        int r = 0;
        int ansl = -1;
        int ansr = slen;
        int[] sc = new int[128];
        int[] tc = new int[128];
        int less = 0;
        for (char c : t.toCharArray()) {
            tc[c]++;
            if (tc[c] == 1) {
                less++;
            }
        }
        while (r < slen) {
            char sr = s.charAt(r);
            sc[sr]++;
            if (sc[sr] == tc[sr]) {
                less--;
            }
            while (less == 0) {
                if (r - l < ansr - ansl) {
                    ansl = l;
                    ansr = r;
                }
                char sl = s.charAt(l);
                sc[sl]--;
                if (sc[sl] == tc[sl] - 1) {
                    less++;
                }
                l++;
            }
            r++;
        }
        return ansl < 0 ? "" : s.substring(ansl, ansr + 1);
    }
}
