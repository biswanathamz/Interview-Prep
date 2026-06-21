import java.util.*;

class main{

    public static void dfs(char[][]grid, int row, int col){
        int rowCount = grid.length;
        int colCount = grid[0].length;

        if(row<0 || col<0 || row>=rowCount || col>=colCount){
            return;
        }

        if(grid[row][col]=='0'){
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        int rowCount = grid.length;
        int colCount = grid[0].length;

        if(rowCount==0 || grid==null){
            return count;
        }

        for(int i = 0; i < rowCount; i++){
            for(int j = 0; j< colCount; j++){
                if(grid[i][j]=='1'){
                    count += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public static  void main(String args[]){
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid)); // Output: 3
    }
}