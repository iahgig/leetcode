#include <bits/stdc++.h>
using namespace std;
int v[60][1290][130];
int vis[60][1290][130]; // vis[i][j][k]表示第i个切片第j行第k列个像素点
int dir[6][3] = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
struct node
{
    int x;
    int y;
    int z;
};
int ans = 0;
int n, m, l, t;
bool is_valid(int i, int j, int k)
{
    if (i >= l || i < 0 || j < 0 || j >= m || k >= n || k < 0 || vis[i][j][k] == 1 || v[i][j][k] == 0)
        return false;
    return true;
}
void bfs(int i, int j, int k, int &vol) // 结点入队视为被访问，则应同步标记，否则会重复入队
{
    if (!is_valid(i, j, k))
        return;
    queue<node> que;
    que.push({i, j, k});
    vol++;
    vis[i][j][k] = 1;
    while (!que.empty())
    {
        node p = que.front();
        que.pop();
        for (int r = 0; r < 6; r++)
        {
            node q;
            q.x = p.x + dir[r][0];
            q.y = p.y + dir[r][1];
            q.z = p.z + dir[r][2];
            if (is_valid(q.x, q.y, q.z))
            {
                vol++;
                vis[q.x][q.y][q.z] = 1;
                que.push(q);
            }
        }
    }
}
int main()
{
    cin >> m >> n >> l >> t;
    for (int i = 0; i < l; i++)
    {
        for (int j = 0; j < m; j++)
        {
            for (int k = 0; k < n; k++)
            {
                cin >> v[i][j][k];
            }
        }
    }
    for (int i = 0; i < l; i++)
    {
        for (int j = 0; j < m; j++)
        {
            for (int k = 0; k < n; k++)
            {
                int vol = 0;
                bfs(i, j, k, vol);
                if (vol >= t)
                    ans += vol;
            }
        }
    }
    cout << ans;
    system("pause");
    return 0;
}