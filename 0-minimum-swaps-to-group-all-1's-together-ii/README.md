
# 0. Minimum Swaps to Group All 1's Together II

## 🚀 Submission Details
- Runtime: 0 ms
- Memory: 10 MB

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

```
        