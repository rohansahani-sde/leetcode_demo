
# 0. Minimum Swaps to Group All 1's Together II
### Medium

A swap is defined as taking two distinct positions in an array and swapping the values in them.

A circular array is defined as an array where we consider the first element and the last element to be adjacent.

Given a binary circular array nums, return the minimum number of swaps required to group all 1's present in the array together at any location.

 

Example 1:

Input: nums = [0,1,0,1,1,0,0]
Output: 1
Explanation: Here are a few of the ways to group all the 1's together:
[0,0,1,1,1,0,0] using 1 swap.
[0,1,1,1,0,0,0] using 1 swap.
[1,1,0,0,0,0,1] using 2 swaps (using the circular property of the array).
There is no way to group all 1's together with 0 swaps.
Thus, the minimum number of swaps required is 1.


Example 2:

Input: nums = [0,1,1,1,0,0,1,1,0]
Output: 2
Explanation: Here are a few of the ways to group all the 1's together:
[1,1,1,0,0,0,0,1,1] using 2 swaps (using the circular property of the array).
[1,1,1,1,1,0,0,0,0] using 2 swaps.
There is no way to group all 1's together with 0 or 1 swaps.
Thus, the minimum number of swaps required is 2.


Example 3:

Input: nums = [1,1,0,0,1]
Output: 0
Explanation: All the 1's are already grouped together due to the circular property of the array.
Thus, the minimum number of swaps required is 0.


 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.

---
## 🚀 Submission Details
- **Runtime**: 0 ms
- **Memory**: 10 MB

## 💻 Code
```java
class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int oneCount =0;
        for(int x: nums)if(x == 1)oneCount++;
        int[] nums1 = new int[n+n];
        for(int i=0; i<n; i++){
            nums1[i] = nums[i];
            nums1[i+n] = nums[i]; 
        }
        int k=0;
        for(int i=0;i<oneCount; i++){
            if(nums1[i] ==1) k++;
        }
        if(oneCount - k ==0) return 0;
        int min= oneCount - k;
        int l=0;
        for(int i=oneCount; i<n+n; i++){
            if(nums1[l++] ==1 ) k--;
            if(nums1[i] == 1) k++;
            min = Math.min(min, oneCount - k);
        }
        return min;
        
    }
}
```
        