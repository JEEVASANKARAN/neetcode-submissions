class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        boolean[] visited = new boolean[n];

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(new ArrayList<>());
        for(int[] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.poll();
            visited[curr] = true;

            for(int num : list.get(curr)){
                if(!visited[num]) q.add(num);
            }
        }

        for(boolean value : visited) if(!value) return false;
        return true;
    }
}
