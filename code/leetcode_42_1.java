public class leetcode_42_1 {
    public int trap(int[] height) {
        // 先找到合法的容器，再计算盛水体积，注意到容器一定满足两边高，中间低
        int n = height.length;
        int l = 0;
        // 容器左壁
        int r = 0;
        // 容器右壁
        int v = 0;
        while (l < n - 1) {
            int mid = l + 1;
            while (mid < n && height[mid] < height[l]) {
                // 先找右壁不低于左壁的合法容器
                mid++;
            }
            if (mid == n) {
                break;
            }
            r = mid;
            for (int i = l + 1; i < r; i++) {
                v += Math.min(height[l], height[r]) - height[i];
            }
            l = r;
        }
        r = n - 1;
        while (r > 0) {
            int mid = r - 1;
            while (mid >= 0 && height[mid] <= height[r]) {
                // 再找右壁低于左壁的合法容器
                mid--;
            }
            if (mid == -1) {
                break;
            }
            l = mid;
            for (int i = r - 1; i > l; i--) {
                v += Math.min(height[l], height[r]) - height[i];
            }
            r = l;
        }
        return v;
    }
}
