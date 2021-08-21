package 一点资讯;

/**
 * 类描述:
 *
 * @ClassName subject2
 * @Description
 * @Author chenjiahao
 * @Date 2021/7/30 20:04
 */
public class subject2 {
    public static void main(String[] args) {
        int[][] mapArray = {{1,3,1},{1,5,1},{4,2,1}};
        int row = mapArray.length;
        int col = mapArray[0].length;
        if (mapArray == null || row == 0 || col == 0)
            System.out.println(0);

        int[][] dp = new int[row][col];
        dp[0][0] = mapArray[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + mapArray[i][0];
        }

        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i-1] + mapArray[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] =Math.min( dp[i-1][j],dp[i][j-1]) + mapArray[i][j];
            }
        }
        System.out.println(dp[row-1][col-1]);
    }
}
