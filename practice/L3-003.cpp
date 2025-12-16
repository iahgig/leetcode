#include <bits/stdc++.h>
using namespace std;
const int N = 1e3 + 10;
int f[N]; // f[i]爱好i所属集合
int c[N]; // c[i]爱好i集合人数,i必须是集合根节点
int find(int i)
{
    if (f[i] == i)
        return i;
    return f[i] = find(f[i]);
}
void merge(int i, int j)
{
    int u = find(i);
    int v = find(j);
    if (u != v) // 第一次合并，合并人数
    {
        f[v] = u;
        c[u] += c[v];
    }
}
int main()
{
    for (int i = 0; i < N; i++)
        f[i] = i;
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int k;
        cin >> k;
        getchar();
        int head;
        cin >> head;
        int u = find(head);
        c[u] += 1;
        for (int i = 1; i < k; i++)
        {
            int h;
            cin >> h;
            merge(head, h);
        }
    }
    int num = 0;
    priority_queue<int> q;
    for (int i = 0; i < N; i++)
    {
        if (f[i] == i && c[i] > 0)
        {
            num++;
            q.push(c[i]);
        }
    }
    cout << num << endl;
    bool first = true;
    while (!q.empty())
    {

        if (first)
        {
            cout << q.top();
            first = false;
        }
        else
            cout << " " << q.top();
        q.pop();
    }
    system("pause");
}