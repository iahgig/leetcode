#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9;
struct point
{
    int id; // 点在集合中的序号，以该点为起点的边的序号为id，以该点为终点的边的序号为(id-1+n)%n
    double x;
    double y;
};
struct edge
{
    int id;        // 边在集合中的序号,该边的起点序号为id，终点序号为(id+1)%n
    point u;       // 起点
    point v;       // 终点
    double slope() // slope为inf时表示与y轴平行
    {
        if (v.x == u.x)
            return inf;
        return (v.y - u.y) / (v.x - u.x);
    }
    double length()
    {
        return sqrt(pow(u.x - v.x, 2) + pow(u.y - v.y, 2));
    }
};
struct polygon
{
    int n;                    // 边数
    vector<point> p_set;      // 顺序顶点集合
    vector<edge> e_set;       // 顺序边集合
    int get_right_angel_num() // 多边形直角个数
    {
        int num = 0;
        for (auto it : p_set)
        {
            if (judge_right_angel_point(it))
                num++;
        }
        return num;
    }
    bool judge_right_angel_point(point p) // 判断是否为直角顶点
    {
        double e1_slope = e_set[(p.id - 1 + n) % n].slope();
        double e2_slope = e_set[p.id].slope();
        return e1_slope * e2_slope == -1 || (max(e1_slope, e2_slope) == inf && min(e1_slope, e2_slope) == 0);
    }
    bool judge_right_angel_edge(edge e) // 判断是否为直角边
    {
        return judge_right_angel_point(e.u) || judge_right_angel_point(e.v);
    }
    bool judge_parallel_edge(edge e) // 判断边是否与坐标轴平行
    {
        return e.slope() == inf || e.slope() == 0;
    }
    void create_p_set(point p)
    {
        p_set.push_back(p);
    }
    void create_e_set()
    {
        for (int i = 0; i < n; i++)
        {
            edge e;
            e.id = i;
            e.u = p_set[i];
            e.v = p_set[(i + 1) % n];
            e_set.push_back(e);
        }
    }
    bool judge_legal() // 判断自身合法性
    {
        // 边数合法性
        if (n > 5)
            return false;
        int right_angel_num = get_right_angel_num();
        // 直角个数合法性
        if (n == 4) // 四边形包含矩形和梯形
        {
            if (right_angel_num != n - 2 && right_angel_num != 4)
                return false;
        }
        else
        {
            if (right_angel_num != n - 2)
                return false;
        }
        for (auto it : e_set) // 直角边必须平行坐标轴
        {
            if (judge_right_angel_edge(it))
            {
                if (!judge_parallel_edge(it))
                    return false;
            }
        }
        return true;
    }
    int find_diagonal() // 斜边id
    {
        for (auto it : e_set)
        {
            if (!judge_right_angel_edge(it))
                return it.id;
        }
        return -1;
    }
    int find_diagonal_opposite_edge() // 斜对边id
    {
        if (n != 4)
            return -1;
        int diagonal_id = find_diagonal();
        if (diagonal_id == -1)
            return -1;
        return ((diagonal_id + 2) % n);
    }
};
bool judge_rectangle(polygon poly1, polygon poly2)
{
    if (!poly1.judge_legal() || !poly2.judge_legal())
        return false;
    // 边数合法性
    if (poly1.n == 5 && poly2.n == 5)
        return false;
    if (min(poly1.n, poly2.n) == 4 && max(poly1.n, poly2.n) == 5)
        return false;
    //
    int poly1_diagonal_id = poly1.find_diagonal();
    int poly2_diagonal_id = poly2.find_diagonal();
    if (poly1.n == 4 && poly2.n == 4)
    {
        if (poly1_diagonal_id == -1 && poly2_diagonal_id == -1) // 两个矩形,有一边相等即可
        {
            for (auto it1 : poly1.e_set)
            {
                for (auto it2 : poly2.e_set)
                {
                    if (it1.length() == it2.length())
                        return true;
                }
            }
            return false;
        }
        if (poly1_diagonal_id == -1 || poly2_diagonal_id == -1) // 只有一个矩形
            return false;
        int poly1_diagonal_length = poly1.e_set[poly1_diagonal_id].length();
        int poly2_diagonal_length = poly2.e_set[poly2_diagonal_id].length();
        int poly1_diagonal_opposite_edge_id = poly1.find_diagonal_opposite_edge();
        int poly2_diagonal_opposite_edge_id = poly2.find_diagonal_opposite_edge();
        int poly1_diagonal_opposite_edge_length = poly1.e_set[poly1_diagonal_opposite_edge_id].length();
        int poly2_diagonal_opposite_edge_length = poly2.e_set[poly2_diagonal_opposite_edge_id].length();
        return poly1_diagonal_length == poly2_diagonal_length && poly1_diagonal_opposite_edge_length == poly2_diagonal_opposite_edge_length;
        // 四边形保证斜边相等和斜对边相等
    }

    if (poly1_diagonal_id != -1 && poly2_diagonal_id != -1) // 非四边形保证斜边相等
    {
        int poly1_diagonal_length = poly1.e_set[poly1_diagonal_id].length();
        int poly2_diagonal_length = poly2.e_set[poly2_diagonal_id].length();
        return poly1_diagonal_length == poly2_diagonal_length;
    }
    else
        return false;
}
int main()
{
    int n;
    cin >> n;
    while (n--)
    {
        polygon poly1, poly2;
        int k;
        cin >> k;
        poly1.n = k;
        for (int i = 0; i < k; i++)
        {
            point p;
            p.id = i;
            cin >> p.x;
            cin >> p.y;
            poly1.create_p_set(p);
        }
        poly1.create_e_set();
        cin >> k;
        poly2.n = k;
        for (int i = 0; i < k; i++)
        {
            point p;
            p.id = i;
            cin >> p.x;
            cin >> p.y;
            poly2.create_p_set(p);
        }
        poly2.create_e_set();
        if (judge_rectangle(poly1, poly2))
            cout << "YES";
        else
            cout << "NO";
        cout << endl;
    }
    system("pause");
    return 0;
}