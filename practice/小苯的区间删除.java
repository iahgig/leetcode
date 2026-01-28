import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        in.close();
        int l = 1;
        int r = n;// 删除a[l]至a[r]区间的元素，保证剩下的元素有序
        int ans = 0;
        a[0] = 0;
        a[r + 1] = (int) 1e9 + 10;
        boolean flag = false;// 判断是否为有序序列
        while (a[r + 1] >= a[r] && a[r + 1] >= a[l - 1]) {
            r--;
            if (l > r) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.print(n * (n + 1) / 2);
        } else {
            ans += n - r + 1;
            while (true) {
                if (l <= n && a[l - 1] <= a[l])
                    l++;
                else
                    break;
                while (a[r + 1] < a[l - 1])
                    r++;
                ans += n - r + 1;
                if (r == n)
                    break;
            }
            System.out.print(ans);
        }

    }
}
