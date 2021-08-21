package 蓝湖;

import java.util.Scanner;

/**
 * 类描述:
 *
 * @ClassName 蓝湖.Num1
 * @Description
 * @Author chenjiahao
 * @Date 2021/7/9 19:01
 */
public class Num1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = scanner.nextInt();
        int[] arrs = new int[n];
        for (int i = 0; i < n; i++) {
            arrs[i] = scanner.nextInt();
        }

        // 类似于背包问题
        long[] dp = new long[sum+1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >=arrs[i] ; j--) {
                dp[j] = dp[j-arrs[i]] + dp[j];
            }
        }
        System.out.println(dp[sum]);
    }
}
