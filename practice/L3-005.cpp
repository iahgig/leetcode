#include <bits/stdc++.h>
using namespace std;
const int N = 1e3 + 20;
const int inf = 1e9;
int a[N][N];
int dis[N];
int vis[N];
int n, m, k, d, ans_id = inf;
double ans_ave = inf;
double ans_max = -1;
int convert(string s)
{
    if (s[0] != 'G')
    {
        return stoi(s);
    }
    return n + stoi(s.substr(1));
}
void dijkstra(int root)
{
    for (int i = 1; i <= n + m; i++)
    {
        dis[i] = inf;
        vis[i] = 0;
        if (a[root][i])
            dis[i] = a[root][i];
        if (i == root)
        {
            dis[i] = 0;
            vis[i] = 1;
        }
    }
    for (int i = 1; i < n + m; i++)
    {
        int dmin = inf;
        int index = -1;
        for (int j = 1; j <= n + m; j++)
        {
            if (!vis[j] && dmin > dis[j])
            {
                dmin = dis[j];
                index = j;
            }
        }
        if (index == -1) // 源点与剩下的点不连通
            break;
        vis[index] = 1;
        for (int j = 1; j <= n + m; j++)
        {
            dis[j] = min(dis[index] + a[index][j], dis[j]);
        }
    }
}
int main()
{
    cin >> n >> m >> k >> d;
    for (int i = 1; i <= n + m; i++)
    {
        for (int j = 1; j <= n + m; j++)
        {
            if (i != j)
            {
                a[i][j] = inf;
                a[j][i] = inf;
            }
        }
    }
    for (int i = 0; i < k; i++)
    {
        int u, v, dis;
        string s1, s2;
        cin >> s1 >> s2 >> dis;
        u = convert(s1);
        v = convert(s2);
        a[u][v] = dis;
        a[v][u] = dis;
    }
    for (int id = n + 1; id <= n + m; id++) // 垃圾候选点编号
    {
        dijkstra(id);
        int d_min = inf;  // 当前垃圾候选点到各居民点的最短距离，编号
        double d_ave = 0; // 当前垃圾候选点到各居民点的平均距离
        bool flag = true;
        for (int j = 1; j <= n; j++) // 居民点编号
        {
            if (dis[j] > d)
            {
                flag = false;
                break;
            }
            d_min = min(d_min, dis[j]);
            d_ave += dis[j];
        }
        d_ave /= n;
        if (flag) // 答案优中选优时一定要有层次结构
        {
            if (d_min > ans_max)
            {
                ans_id = id;
                ans_ave = d_ave;
                ans_max = d_min;
            }
            else if (d_min == ans_max)
            {
                if (d_ave < ans_ave)
                {
                    ans_id = id;
                    ans_ave = d_ave;
                }
            }
        }
    }
    if (ans_id == inf)
    {
        cout << "No Solution";
    }
    else
    {
        ans_ave = round(ans_ave * 10) / 10;
        cout << 'G' << ans_id - n << endl;
        printf("%.1f %.1f", ans_max, ans_ave);
    }
    system("pause");
    return 0;
}