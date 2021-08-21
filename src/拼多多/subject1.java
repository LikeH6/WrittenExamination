package 拼多多;

import java.util.Scanner;

/**
 * 类描述:
 *
 * @ClassName subject1
 * @Description
 * @Author chenjiahao
 * @Date 2021/7/25 18:58
 */
public class subject1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        // 按L从小到大排序，相同则再按R从小到大排序
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums[i][0] > nums[j][0]){
                    int[] temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }else if (nums[i][0] == nums[j][0]){
                    if (nums[i][1] > nums[j][1]){
                        int[] temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < n-1; i++) {
            if ((nums[i][0] <= nums[i+1][0]) && (nums[i][1] >= nums[i+1][1]))
            {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);

    }

}
