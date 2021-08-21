package 科大讯飞;

import java.util.Scanner;

/**
 * 类描述:
 *
 * @ClassName subject2
 * @Description
 * @Author chenjiahao
 * @Date 2021/7/31 19:51
 */
public class subject2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int max = 0;
        int temp_i = 0;
        int temp_j = 0;
        for (int i = 0; i < n-1; i++) {
            if (nums[i+1] - nums[i] > max){
                max = nums[i+1] - nums[i];
                temp_i = i;
                temp_j = i+1;
            }
        }
        if (max == 1)
            System.out.println(1);
        else {
            if (max > nums[temp_j] - nums[temp_i])
                System.out.println(1);
        }



    }
}
