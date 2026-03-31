
# 1584. 1584. Min Cost to Connect All Points
### Medium

You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

 

Example 1:

Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation: 


We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.


Example 2:

Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18


 

Constraints:

1 <= points.length <= 1000
-106 <= xi, yi <= 106
All pairs (xi, yi) are distinct.

---
## 🚀 Submission Details
- **Runtime**: N/A
- **Memory**: N/A

## 💻 Code
```java
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0,0});
        int total =0;
        int used =0;
        while(used < n){
            int[] curr = pq.poll();
            int cost = curr[0];
            int i = curr[1];
            if(vis[i])continue;
            vis[i] = true;
            total += cost;
            used++;
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j=0; j<n; j++){
                if(vis[j]) continue;
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dis = Math.abs(x2 - x1) + Math.abs(y2 - y1);
                pq.offer(new int[]{dis, j});
            }
        }
        return total;
    }
}
```
        