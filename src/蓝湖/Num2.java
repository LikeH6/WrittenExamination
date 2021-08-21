package 蓝湖;

import java.util.Scanner;

/**
 * 类描述:
 *
 * @ClassName 蓝湖.Num2
 * @Description
 * @Author chenjiahao
 * @Date 2021/7/9 19:21
 */
public class Num2 {
    private static int count=0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x0 = scanner.nextInt();
        int y0 = scanner.nextInt();
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        cal(x0,y0,x1,y1);
        System.out.println(count);
    }

    public static void cal(int cur_x, int cur_y, int x1, int y1){
        if (cur_x > x1 || cur_y > y1)
            return;
        if ((cur_x == x1) && (cur_y == y1))
            count++;
        // 只能走右上方的日字，因此有两种情况
        // x+1,y+2
        cal(cur_x+1,cur_y+2,x1,y1);
        // x+2,y+1
        cal(cur_x+2,cur_y+1,x1,y1);
    }
}
