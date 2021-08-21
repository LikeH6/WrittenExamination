package 美团;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 类描述:
 *
 * @ClassName subject1
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/8 10:01
 */
public class subject1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] nums = new int[n];

            if (k > n){
                System.out.println("NO");
                continue;
            }

            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }

            Arrays.sort(nums);
            if (k == 0){
                System.out.println("YES");
                System.out.println(nums[0]);
                continue;
            }
            if (k == n){
                if (nums[n-1] == n){
                    System.out.println("NO");
                    continue;
                }else {
                    System.out.println("YES");
                    System.out.println(nums[n-1]+1);
                    continue;
                }
            }else {
                int pre = nums[k-1];
                int next = nums[k];
                if (pre != next){
                    System.out.println("YES");
                    System.out.println(pre+1);
                    continue;
                }else {
                    System.out.println("NO");
                    continue;
                }
            }
        }
    }
}
