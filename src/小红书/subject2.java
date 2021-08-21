package 小红书;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 类描述:
 *
 * @ClassName subject2
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/21 10:23
 */
public class subject2 {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j)=='.')
                    sum++;
            }
            list.add(s);
        }
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = 0;
            }
        }

        backtrace(list,nums,0,0,0,sum);
        System.out.println(count);
    }

    public static void backtrace(List<String> list,int[][] nums,int time,int i,int j,int sum){
        int n = nums.length;

        if (list.get(i).charAt(j)!='#')
            time++;

        if (time == sum && i==n-1)
        {
            count++;
            return;
        }

        nums[i][j] = 1;

        if (i+1<n && list.get(i+1).charAt(j)!='#' && nums[i+1][j]==0)
            backtrace(list,nums,time,i+1,j,sum);
        if (i-1>=0 && list.get(i-1).charAt(j)!='#' && nums[i-1][j]==0)
            backtrace(list,nums,time,i-1,j,sum);
        if (j+1<n && list.get(i).charAt(j+1)!='#' && nums[i][j+1]==0)
            backtrace(list,nums,time,i,j+1,sum);
        if (j-1>=0 && list.get(i).charAt(j-1)!='#' && nums[i][j-1]==0)
            backtrace(list,nums,time,i,j-1,sum);
        nums[i][j] = 0;
        if (list.get(i).charAt(j)!='#')
            time--;
        return;
    }
}
