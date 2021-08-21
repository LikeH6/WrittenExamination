package 阿里;

import java.util.Scanner;

/**
 * 类描述:
 *
 * @ClassName subject1
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/2 19:01
 */
public class subject1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int si = 0; si < t; si++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] a = new int[n][m];
            int start_i = 0;
            int start_j = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    a[j][k] = scanner.nextInt();
                    if (a[j][k] == 0){
                        start_i = j;
                        start_j = k;
                    }
                }
            }
            int[][] temp = new int[n][m];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    temp[j][k] = 0;
                }
            }
            if ((start_i == n-1 && start_j == m-1) || valid(a,start_i,start_j,0,temp))
                System.out.println("YES");
            else
                System.out.println("NO");


        }
    }
    public static boolean valid(int[][] a,int i,int j,int time,int[][] temp){
        int row = a.length;
        int col = a[0].length;
        if (time > a[i][j]){
            return false;
        }

        if (i == row-1 && j == col-1)
            return true;

        if (
                (i+1 < row && valid(a,i+1,j,time+1,temp) && temp[i+1][j] == 0) ||
                (i-1 >= 0 && valid(a,i-1,j,time+1,temp) && temp[i-1][j] == 0) ||
                (j+1 < col && valid(a,i,j+1,time+1,temp) && temp[i][j+1] == 0) ||
                (j-1 >= 0 && valid(a,i,j-1,time+1,temp) && temp[i][j-1] == 0)
        ){
            return true;
        }

        return false;
    }
}
