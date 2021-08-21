package 小红书;

import java.util.Scanner;

/**
 * 类描述:
 *
 * @ClassName subject1
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/21 10:09
 */
public class subject1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][3];
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            System.out.println(s);
            String[] str = s.split(" ");
            if (str.length > 1){
                nums[i][0] = Integer.parseInt(str[0]);
                nums[i][1] = Integer.parseInt(str[1]);
                nums[i][2] = Integer.parseInt(str[2]);
            }else {
                nums[i][0] = Integer.parseInt(s);
                nums[i][1] = 0;
                nums[i][2] = 0;
            }
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(nums[i][0]);
//            System.out.println(nums[i][1]);
//            System.out.println(nums[i][2]);
//        }
    }
}
