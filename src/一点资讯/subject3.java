package 一点资讯;

import java.util.Arrays;

/**
 * 类描述:
 *
 * @ClassName subject3
 * @Description
 * @Author chenjiahao
 * @Date 2021/7/30 19:23
 */
public class subject3 {
    public static void main(String[] args) {
        String[][] version_list = {{"0.1.0", "1.0"},{"2.1.13", "1.20.0"},{"2.1.0", "2.1.0"}};
        int[] res = new int[version_list.length];
        int k = 0;
        for (String[] str: version_list) {
//            String s = "0.1.0";
//            System.out.println(s.split("\\.").length);
//            System.out.println(str[0]);
//            System.out.println(str[1]);
            String[] str1 = str[0].split("\\.");
            String[] str2 = str[1].split("\\.");
            int len1 = str1.length;
            int len2 = str2.length;
            System.out.println(len1);
            System.out.println(len2);
            System.out.println("====");

            int[] num1 = new int[len1];
            int[] num2 = new int[len2];

            for (int i = 0; i < len1; i++) {
                num1[i] = Integer.parseInt(str[0].split("\\.")[i]);
            }
            for (int i = 0; i < len2; i++) {
                num2[i] = Integer.parseInt(str[1].split("\\.")[i]);
            }
            int len = Math.max(len1,len2);
            System.out.println(len);
            int j;
            for(j = 0;j < len ; j++){
                int n1 ,n2;
                if(len1 > j)
                    n1 = num1[j];
                else
                    n1 = 0;

                if(len2 > j)
                    n2 = num2[j];
                else
                    n2 = 0;

                if(n1 != n2)
                {
                    res[k] = n1 > n2 ? 1 : 2 ;
                    System.out.println(k);
                    k++;
                    break;
                }

            }
        }

        System.out.println("结束了");


//
//        for (String[] str: version_list) {
//            int len1 = str[0].split(".").length;
//            int len2 = str[1].split(".").length;
//            int max = Math.max(len1,len2);
//            System.out.println(len1);
//            System.out.println(len2);
//            int[] num1 = new int[len1];
//            int[] num2 = new int[len2];
//
//            for (int i = 0; i < len1; i++) {
//                num1[i] = Integer.parseInt(str[0].split(".")[i]);
//            }
//            for (int i = 0; i < len2; i++) {
//                num2[i] = Integer.parseInt(str[1].split(".")[i]);
//            }
//
//            int start = 0;
//            while (len1 > 0 || len2 > 0){
//                if (num1[start] > num2[start])
//                {
//                    System.out.println(1);
//                    break;
//                }
//                else if (num1[start] < num2[start])
//                {
//                    System.out.println(2);
//                    break;
//                }
//                start++;
//            }
//
//
//
//        }
    }
}
