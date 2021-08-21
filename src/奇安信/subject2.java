package 奇安信;

/**
 * 类描述:
 *
 * @ClassName subject2
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/7 15:45
 */
public class subject2 {


    public static void main(String[] args) {
        int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(getMaximumResource(grid));
    }

    private static int res = 0;
    private static int max = 0;
    public static int getMaximumResource (int[][] grid) {
        // write code here
        int row = grid.length;
        int col = grid[0].length;

        // 记录是否访问过
        int[][] valid = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                valid[i][j] = 0;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 0) {
                    backtrace(grid,valid, i, j);
                }
            }
        }
        return max;

    }

    public static void backtrace(int[][] grid,int[][] valid,int i,int j){
        int row = grid.length;
        int col = grid[0].length;
        res += grid[i][j];
        valid[i][j] = 1;
        if (i+1 < row && grid[i+1][j] != 0 && valid[i+1][j] == 0){
            backtrace(grid, valid,i+1,j);
        }
        if (i-1 >= 0 && grid[i-1][j] != 0 && valid[i-1][j] == 0){
            backtrace(grid, valid,i-1,j);
        }
        if (j+1 < col && grid[i][j+1] != 0 && valid[i][j+1] == 0){
            backtrace(grid, valid,i,j+1);
        }
        if (j-1 >= 0 && grid[i][j-1] != 0 && valid[i][j-1] == 0){
            backtrace(grid, valid,i,j-1);
        }
        valid[i][j] = 0;
        if (max < res)
            max = res;
        System.out.println(max);
        res -= grid[i][j];
        return;


    }
}
