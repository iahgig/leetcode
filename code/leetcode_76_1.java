public class leetcode_76_1 {
    public String minWindow(String s, String t) {
        int sl = s.length();
        int l = 0;
        int r = 0;
        int ansl = -1;
        int ansr = sl;
        int[] sc = new int[128];
        int[] tc = new int[128];
        for (char c : t.toCharArray()) {
            tc[c]++;
        }
        while (r < sl) {
            sc[s.charAt(r)]++;
            while (check(sc, tc)) {
                if (r - l < ansr - ansl) {
                    ansl = l;
                    ansr = r;
                }
                sc[s.charAt(l)]--;
                l++;
            }
            r++;
        }
        return ansl < 0 ? "" : s.substring(ansl, ansr + 1);
    }

    public boolean check(int[] sc, int[] tc) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (sc[i] < tc[i])
                return false;
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (sc[i] < tc[i])
                return false;
        }
        return true;
    }
}
