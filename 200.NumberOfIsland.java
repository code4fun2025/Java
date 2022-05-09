class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 )
        {
            return 0;
            
        }

        int ROWS = grid.length;
        int COLS = grid[0].length;
        int count = 0;
        
        //#1. Check the grid for DFS
        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                if (grid[r][c] == '1')
                {
                    dfs(grid, r, c);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    void dfs(char[][] grid, int r, int c)
    {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        
        //#2. If it's out of bound or cannot find land node, return
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] != '1') {
            return;
        }        

        //#3. Mark node is visisted and perform further DFS
        grid[r][c] = '2';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);        
    }

}
