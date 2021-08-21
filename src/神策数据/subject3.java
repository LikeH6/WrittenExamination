package 神策数据;

import java.util.Scanner;

/**
 * 类描述:
 *
 * @ClassName subject3
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/10 20:16
 */
public class subject3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int x = scanner.nextInt();
//        int y = scanner.nextInt();
//        int m = scanner.nextInt();
        long x = scanner.nextLong();
        long y = scanner.nextLong();
        long m = scanner.nextLong();

        int count = 0;
        long flag = 0;
        while (x < m && y < m){
            if (x + y <= x && x + y <= y){
                flag = 1;
                break;
            }
            if (x < y){
                x = x + y;
            }else
                y = x + y;
            count++;


        }
        if (flag == 1)
            System.out.println(-1);
        else
            System.out.println(count);

    }
}
