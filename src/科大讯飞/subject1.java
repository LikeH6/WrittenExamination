package 科大讯飞;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 类描述:
 *
 * @ClassName subject1
 * @Description
 * @Author chenjiahao
 * @Date 2021/7/31 19:43
 */
public class subject1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] nums = new int[k][2];
        for (int i = 0; i < k; i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }

        for (int i = 0; i < k; i++) {
            if (nums[i][0] == x || nums[i][1] == x){
                x = nums[i][0] == x ? nums[i][1] : nums[i][0];
            }
        }
        System.out.println(x);
    }
}
