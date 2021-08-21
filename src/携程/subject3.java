package 携程;

import java.util.Scanner;

/**
 * 类描述:
 *
 * @ClassName subject3
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/12 19:34
 */
public class subject3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] tree = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tree[i][j] = 0;
            }
        }
        int allCount = (n-1)*n/2;
        int count_1 = 0;
        int[] a = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            a[i] = scanner.nextInt();
            tree[i][a[i]-1] = 1;
            tree[a[i]-1][i] = 1;
            count_1++;
        }
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }


        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (tree[i][j] == 0){
                    System.out.println(w[i] +" "+ w[j]);
                    if (w[i] * w[j] > max)
                        max = w[i] * w[j];
                }
            }
        }
        System.out.println((allCount - count_1)*count_1 + " "+ max);


    }
}
