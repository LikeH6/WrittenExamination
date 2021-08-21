package 美团;

import java.util.*;

/**
 * 类描述:
 *
 * @ClassName subject3
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/8 10:31
 */
public class subject3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] prev = new int[n];


        for (int i = 1; i < n; i++) {
            prev[i] = getPrev(nums,i,nums[i]);
        }
        int sum = 0;
        for (int i = 1; i <= n ; i++) {
            sum = sum + i * prev[i-1];
        }
        System.out.println(sum);
    }

    public static int getPrev(int[] nums,int k,int target){
        int max = 0;
        for (int i = 0; i < k; i++) {
            if (nums[i] < target){
                if (max < nums[i])
                    max = nums[i];
            }
        }
        return max;


    }
}
