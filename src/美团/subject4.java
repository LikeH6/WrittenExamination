package 美团;

import java.util.Scanner;

/**
 * 类描述:
 *
 * @ClassName subject4
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/8 10:50
 */
public class subject4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int count = 0;
        for (int i = 0; i < n/2; i++) {
            if (nums[i] != nums[i+n/2])
                count++;
        }
        System.out.println(count);
    }
}
