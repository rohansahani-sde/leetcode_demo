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