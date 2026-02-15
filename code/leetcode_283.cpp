#include <bits/stdc++.h>
using namespace std;
class Solution
{
public:
    void moveZeroes(vector<int> &nums) // 从左往右，zero指针指向第一个零元素;non_zero 指针指向zero指针后第一个非零元素，不断交换
    {
        int zero = 0;
        int non_zero = 0;
        while (true)
        {
            while (zero < nums.size() && nums[zero] != 0) // zero==non_zero是非法的
            {
                zero++;
            }
            if (zero == nums.size())
                break;
            while (non_zero <= zero)
                non_zero++;
            while (non_zero < nums.size() && nums[non_zero] == 0)
            {
                non_zero++;
            }
            if (non_zero == nums.size())
                break;
            swap(nums[zero], nums[non_zero]);
        }
    }
};