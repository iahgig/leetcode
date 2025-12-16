#include <bits/stdc++.h>
using namespace std;
stack<int> s;
vector<int> v;
// 维护栈s和有序数组v
int main()
{
    int n;
    cin >> n;
    while (n--)
    {
        string str;
        cin >> str;
        if (str == "Pop")
        {
            if (s.empty())
            {
                cout << "Invalid" << endl;
            }
            else
            {
                int element = s.top();
                cout << element << endl;
                s.pop();
                auto index = lower_bound(v.begin(), v.end(), element);
                v.erase(index);
            }
        }
        else if (str == "Push")
        {
            int element;
            cin >> element;
            s.push(element);
            auto index = lower_bound(v.begin(), v.end(), element);
            v.insert(index, element);
        }
        else
        {
            if (v.empty())
            {
                cout << "Invalid" << endl;
            }
            else
            {
                int mid;
                if (v.size() % 2 == 0)
                    mid = v.size() / 2 - 1;
                else
                    mid = (v.size() + 1) / 2 - 1;
                cout << v[mid] << endl;
            }
        }
    }
    system("pause");
    return 0;
}