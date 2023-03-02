class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(Character.compare(grid[i][j],'1') == 0){
                    numIslands++;
                    dfs(grid, i , j);
                }
            }
        }
        return numIslands;
    }

    public void dfs(char[][] grid, int i, int j){
        if(i < 0 || i == grid.length || j < 0 || j == grid[i].length || Character.compare(grid[i][j], '1') != 0)
            return;
        grid[i][j] = '#';
        int directions[][] = {{-1, 0},{0, -1}, {0, 1}, {1, 0}};
        for(int d[]: directions)
            dfs(grid, i + d[0], j + d[1]);
    }
}
