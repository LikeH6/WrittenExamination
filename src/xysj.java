import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 类描述:
 *
 * @ClassName xysj
 * @Description
 * @Author chenjiahao
 * @Date 2021/7/22 19:12
 */
public class xysj {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> nums = new ArrayList<>();
        System.out.print(n+"=");

        for (int i = 2; i <= n; i++) {
            if (n%i == 0){
                nums.add(i);

                n = n / i;
                i--;
            }
        }
        if (nums.size() == 1)
            System.out.print(nums.get(0));
        else {
            for (int i = 0; i < nums.size(); i++) {
                if (i == nums.size()-1)
                    System.out.print(nums.get(i));
                else
                    System.out.print(nums.get(i) + "*");

            }
        }

    }

}
