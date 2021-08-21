package 拼多多;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 类描述:
 *
 * @ClassName subject2
 * @Description
 * @Author chenjiahao
 * @Date 2021/7/25 19:15
 */
public class subject2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] chicken = new int[n];
        int[] duck = new int[n];
        for (int i = 0; i < n; i++) {
            chicken[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            duck[i] = scanner.nextInt();
        }
        int res_chicken = 0;
        int res_duck = 0;

        // 记录每次放的牌
        int[] temp = new int[201];
        // 用于判断是否有相同的牌出现
        Set<Integer> set = new HashSet<>();

        int j = 0;
        int start = 0;
        int i = 0;
        int k = 0;
        while (i < n || k < n) {
            if (!set.contains(chicken[i])){
                temp[j++] = chicken[i];
                set.add(chicken[i]);
                i++;
            }else {
                temp[j++] = chicken[i];
                res_chicken = getCount(res_chicken,temp,start,j,chicken[i],set);
                if (i < n-1)
                    temp[j++] = chicken[i++];
                start = j;

            }

            if (!set.contains(duck[k])) {
                temp[j++] = duck[k];
                set.add(duck[k]);
                k++;
            }else {
                temp[j++] = duck[k];
                res_duck = getCount(res_duck,temp,start,j,duck[k],set);
                if (k < n-1)
                    temp[j++] = duck[k++];
                start = j;

            }
        }
        for (i = start; i < 2 * n; i++) {
            if (temp[i] % 2 == 0)
                res_duck += 1;
            else
                res_chicken += 1;
        }
        System.out.print(res_chicken);
        System.out.print(" ");
        System.out.print(res_duck);

    }
    public static int getCount(int count,int[] nums,int start,int end,int num,Set<Integer> set){
        int flag = 0;
        for (int i = start; i < end - 1 ; i++) {
            if (nums[i] == num)
            {
                flag = 1;
                count =  count+end-start;
            }
            if (flag == 1)
                set.remove(nums[i]);
        }
        return count;
    }
}
