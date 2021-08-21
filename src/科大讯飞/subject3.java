package 科大讯飞;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 类描述:
 *
 * @ClassName subject3
 * @Description
 * @Author chenjiahao
 * @Date 2021/7/31 20:01
 */
public class subject3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        String[] str = new String[n];
        int[][] load = new int[n][m];
        for (int i = 0; i < n; i++) {
            str[i] = scanner.next();
            for (int j = 0; j < str[i].length(); j++) {
                if (str[i].charAt(j) == '.')
                    load[i][j] = 0;
                else
                    load[i][j] = 1;
            }
        }
        int res = 0;
        List<Integer> list = new ArrayList<>();
        traceback(load,0,0,res,n,m,list);
        System.out.println(res);
    }

    public static void traceback(int[][] load,int i,int j,int res,int n,int m,List<Integer> list){
        if (i == n-1 && j == m-1)
        {
            int k = 0;
            for (int l = 0; l < list.size(); l++) {
                if (list.get(i) == 1)
                    k++;
            }
            if (k<res)
                res = k;
            return;
        }
        else {
            list.add(load[i][j]);
        }
        if (i+1<n)
            traceback(load,i+1,j,res,n,m,list);
        if (j-1<m)
            traceback(load,i,j+1,res,n,m,list);
        if (i-1<n)
            traceback(load,i-1,j,res,n,m,list);
        if (j-1<m)
            traceback(load,i,j-1,res,n,m,list);
        list.remove(list.size()-1);
    }
}
