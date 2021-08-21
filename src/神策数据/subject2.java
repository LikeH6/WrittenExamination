package 神策数据;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 * 类描述:
 *
 * @ClassName subject2
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/10 20:15
 */
public class subject2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        List<List<Character>> lists = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp != ' '){
                list.add(temp);
                if (i == str.length()-1)
                    lists.add(list);
            }else {
                if (list.size() != 0 ){
                    lists.add(list);
                    list = new ArrayList<>();
                }
            }
        }
        for (int i = 0; i < lists.size(); i++) {
            for (int j = lists.get(i).size()-1 ; j >= 0 ; j--) {
                System.out.print(lists.get(i).get(j));
            }
            if (i != lists.size()-1)
                System.out.print(" ");
        }
    }
}
