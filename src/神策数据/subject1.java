package 神策数据;

import java.util.*;

/**
 * 类描述:
 *
 * @ClassName subject1
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/10 20:15
 */
public class subject1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp == '('){
                stack.add(i);
            } else if (temp == ')'){
                count++;
                List<Integer> list = new ArrayList<>();
                list.add(stack.pop());
                list.add(i);
                res.add(list);
            }
        }
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0)-o2.get(0);
            }
        });
        System.out.println(count);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(res.get(i).get(j));
            }
        }
    }
}
