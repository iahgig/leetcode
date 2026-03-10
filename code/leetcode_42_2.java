public class leetcode_42_2 {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int L_max = height[l];
        // 指针l以左的最高点
        int R_max = height[r];
        // 指针r以右的最高点
        int v = 0;
        while (l < r) {
            // 数学归纳法的思想，第一次执行显然成立
            // 指针l和r最终共同指向最高点，l=r可不计
            if (height[l] <= height[r]) {
                // 不妨令L_max指向的最高点记为h[a],a<=l,指针从a迭代至l，则一定有h[a]<=h[b],b>=r>l,记L[i],R[i]分别为指针i以左和以右的最高点，显然有L[l]=L_max=h[a]<=h[b]<=R[l],所以min(L[l],R[l])=L_max
                v += L_max - height[l];
                l++;
                L_max = Math.max(L_max, height[l]);

            } else {
                // 依上同理可证
                v += R_max - height[r];
                r--;
                R_max = Math.max(R_max, height[r]);
            }
        }
        return v;
    }
}
