package 拼多多;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 * 类描述:
 *
 * @ClassName subject3
 * @Description
 * @Author chenjiahao
 * @Date 2021/7/25 19:23
 */
public class subject3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n>0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int q = scanner.nextInt();

            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            priorityQueue.add(a);
            int flag = 0;
            while (!priorityQueue.isEmpty()){
                if (priorityQueue.contains(q)){
                    flag = 1;
                    System.out.println(1);
                    break;
                }
                int temp = priorityQueue.poll();

                if (temp > q){
                    flag = 1;
                    System.out.println(0);
                    break;
                }
                int num1 = temp + b;
                int num2 = temp * c;
                if (num1 == q || num2 == q){
                    flag = 1;
                    System.out.println(1);
                    break;
                }
                if (num1 <= q && !priorityQueue.contains(num1))
                    priorityQueue.add(num1);
                if (num2 <= q && !priorityQueue.contains(num2))
                    priorityQueue.add(num2);
            }
            if (flag == 0)
                System.out.println(0);
            n--;
        }
    }
}
