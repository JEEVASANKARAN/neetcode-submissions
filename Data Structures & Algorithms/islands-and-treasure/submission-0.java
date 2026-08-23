class Solution {
    int[][] directions={
        {-1,0},{1,0},
        {0,-1},{0,1}
    };
    class Pair{
        int row;
        int col;

        public Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    q.add(new Pair(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int r=curr.row;
            int c=curr.col;

            for(int[] direction : directions){
                int nr=direction[0]+r;
                int nc=direction[1]+c;

                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    if(grid[nr][nc]==Integer.MAX_VALUE){
                        grid[nr][nc]=grid[r][c]+1;
                        q.add(new Pair(nr,nc));
                    }
                }
            }
        }
    }
}
