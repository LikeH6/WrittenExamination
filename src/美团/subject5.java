package 美团;

import sun.font.TrueTypeFont;
import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 类描述:
 *
 * @ClassName subject5
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/8 11:32
 */
public class subject5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] tree = new int[n][2];
        for (int i = 0; i < n; i++) {
            tree[i][0] = scanner.nextInt();
            tree[i][1] = scanner.nextInt();
        }
        int[] change = new int[m];
        for (int i = 0; i < m; i++) {
            change[i] = scanner.nextInt();
            // 交换
            int temp = tree[change[i]][0];
            tree[change[i]][0] = tree[change[i]][1];
            tree[change[i]][1] = temp;
        }

        Deque<Integer> stack = new LinkedList<>();

        int[] res = new int[n];
        int i = 0;

        while (true){
            stack.add(k);
            if (tree[k][0] != 0){
                k = tree[k][0];
            }else if (tree[k][0] == 0){
                res[i++] = tree[k][0];
            }
        }




    }
//    static class TreeNode{
//        int val;
//        TreeNode right;
//        TreeNode left;
//        TreeNode(){}
//        TreeNode(int val){this.val = val;}
//        TreeNode(int val,TreeNode right,TreeNode left){
//            this.val = val;
//            this.right = right;
//            this.left = left;
//        }
//    }
}
