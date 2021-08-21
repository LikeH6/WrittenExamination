package 美团;

import java.util.Scanner;

/**
 * 类描述:
 *
 * @ClassName subject2
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/8 10:18
 */
public class subject2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String res = "";
        str = str.replace(" ","");
        for (int i = 0; i < str.length()-1; i++) {
            char ch = str.charAt(i);
            int flag = 0;
            if (ch != str.charAt(i+1)){
                res += ch + "";
                flag = 1;
            }
            if (flag == 0 && i == str.length()-2)
                res += ch + "";
        }
        if (str.charAt(str.length()-1) != str.charAt(str.length()-2))
            res += str.charAt(str.length()-1) + "";
        System.out.println(res);
    }
}
