package 携程;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 类描述:
 *
 * @ClassName subjectfuben
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/12 20:14
 */
public class subjectfuben {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> lists = new ArrayList<>();
      //  int[][] tree = new int[n][n];
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                list.add(0);
            }
            lists.add(list);

        }
        int allCount = (n-1)*n/2;
        int count_1 = 0;
        int[] a = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            a[i] = scanner.nextInt();
            List<Integer> temp ;

            if ((i+1) < a[i]){
                int t = i;
                i = a[i];
                a[t] = t;
            }
            temp = lists.get(i-1);
            temp.set(a[i],1);
            lists.set(i-1,temp);

            count_1++;
        }
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(lists.toString());
        int max = 0;
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size()-1; j++) {
                if (lists.get(i).get(j) == 0){
                    if (w[i] * w[j] > max)
                        max = w[i] * w[j];
                }
            }
        }
        System.out.println((allCount - count_1)*count_1 + " "+ max);

    }
}
