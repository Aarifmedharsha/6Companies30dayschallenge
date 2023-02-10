/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int a, r, m, p = 0;
        a  = 0;
        r = n - 1;
        while (a < r) {
            m = (a + r) / 2;
            if (mountainArr.get(m) < mountainArr.get(m + 1))
                a = p = m + 1;
            else
                r = m;
        }
        a = 0;
        r = p;
        while (a <= r) {
            m = (a + r) / 2;
            if (mountainArr.get(m) < target)
                a = m + 1;
            else if (mountainArr.get(m) > target)
                r = m - 1;
            else
                return m;
        }
        a = p;
        r = n - 1;
        while (a <= r) {
            m = (a + r) / 2;
            if (mountainArr.get(m) > target)
                a = m + 1;
            else if (mountainArr.get(m) < target)
                r = m - 1;
            else
                return m;
        }
        return -1;
    }
}