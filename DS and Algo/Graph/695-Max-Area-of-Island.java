import java.util.*;

class main{

    public static int dfs(int row, int col, int[][] grid){
        int rowCount = grid.length;
        int colCount = grid[0].length;

        if(row<0 || col <0 || row>= rowCount || col>= colCount){
            return 0;
        }

        if(grid[row][col] == 0) return 0;

        grid[row][col] = 0;

        return 1+
        dfs(row+1,col,grid)+
        dfs(row,col+1,grid)+
        dfs(row-1,col,grid)+
        dfs(row,col-1,grid);

    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        if(grid==null) return maxArea;

        int rowCount = grid.length;
        int colCount = grid[0].length;

        for(int i=0; i<rowCount; i++){
            for(int j=0; j<colCount; j++){
                maxArea = Math.max(maxArea,dfs(i,j,grid));
            }
        }

        return maxArea;
    }

    public static  void main(String args[]){
        int[][] grid = {
                {0,1,1,0,1},
                {1,0,1,0,1},
                {0,1,1,0,1},
                {0,1,0,0,1}
        };
        System.out.println(maxAreaOfIsland(grid));
    }
}