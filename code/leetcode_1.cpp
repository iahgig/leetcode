#include <bits/stdc++.h>
using namespace std;
class Solution
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        map<int, int> mp; // mp[i]表示nums数组中，最后一个值为i的下标
        vector<int> v;
        for (int i = 0; i < nums.size(); i++)
        {
            mp[nums[i]] = i;
        }
        for (int i = 0; i < nums.size(); i++)
        {
            int x = target - nums[i];
            if (mp.count(x))
            {
                if (x == nums[i]) // 重复时特殊处理
                {
                    if (i != mp[x])
                    {
                        v.push_back(i);
                        v.push_back(mp[x]);
                        break;
                    }
                }
                else
                {
                    v.push_back(i);
                    v.push_back(mp[x]);
                    break;
                }
            }
        }
        return v;
    }
};