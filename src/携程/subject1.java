package 携程;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 类描述:
 *
 * @ClassName subject1
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/12 19:02
 */
public class subject1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        double max = 0.0;
        int left = 0;
        int right = n-1;
        int length = 0;
        for (int i = k; i <= n; i++) {
            for (int j = 0; j < n-i+1; j++) {
                int sum = 0;
                for (int l = j; l < j+i; l++) {
                    sum += a[l];
                }
                double ave = sum*1.0/i;

                if (ave > max) {
                    max = ave;
                    left = j;
                    right = j + i -1;
                    length = i;
                }else if (ave == max){
                    if (length < i){
                        left = j;
                        right = j + i -1;
                        length = i;
                    }
                }

            }
        }
        System.out.println(left+" "+right);
    }
}
