
# 2134. Minimum Swaps to Group All 1's Together II
### Medium

<p>A <strong>swap</strong> is defined as taking two <strong>distinct</strong> positions in an array and swapping the values in them.</p>

<p>A <strong>circular</strong> array is defined as an array where we consider the <strong>first</strong> element and the <strong>last</strong> element to be <strong>adjacent</strong>.</p>

<p>Given a <strong>binary</strong> <strong>circular</strong> array <code>nums</code>, return <em>the minimum number of swaps required to group all </em><code>1</code><em>&#39;s present in the array together at <strong>any location</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,1,0,1,1,0,0]
<strong>Output:</strong> 1
<strong>Explanation:</strong> Here are a few of the ways to group all the 1&#39;s together:
[0,<u>0</u>,<u>1</u>,1,1,0,0] using 1 swap.
[0,1,<u>1</u>,1,<u>0</u>,0,0] using 1 swap.
[1,1,0,0,0,0,1] using 2 swaps (using the circular property of the array).
There is no way to group all 1&#39;s together with 0 swaps.
Thus, the minimum number of swaps required is 1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,1,1,1,0,0,1,1,0]
<strong>Output:</strong> 2
<strong>Explanation:</strong> Here are a few of the ways to group all the 1&#39;s together:
[1,1,1,0,0,0,0,1,1] using 2 swaps (using the circular property of the array).
[1,1,1,1,1,0,0,0,0] using 2 swaps.
There is no way to group all 1&#39;s together with 0 or 1 swaps.
Thus, the minimum number of swaps required is 2.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,0,0,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> All the 1&#39;s are already grouped together due to the circular property of the array.
Thus, the minimum number of swaps required is 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code> is either <code>0</code> or <code>1</code>.</li>
</ul>


---
## 🚀 Submission Details
- **Runtime**: N/A
- **Memory**: N/A

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
        