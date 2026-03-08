
public class leetcode_11 {

    public int maxArea(int[] height) {
        // 贪心：每次移动左右指针较短的那一个，因为如果移动较长的指针，结果一定更劣（长减少，宽不变或减少）
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while (l < r) {
            ans = Math.max(ans, (r - l) * Math.min(height[l], height[r]));
            if (height[l] <= height[r])
                l++;
            else {
                r--;
            }
        }
        return ans;
    }
}