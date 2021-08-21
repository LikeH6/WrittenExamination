package 奇安信;

/**
 * 类描述:
 *
 * @ClassName subject1
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/7 16:21
 */
public class subject1 {
    public static void main(String[] args) {
        int[] height = {1,5,3,2,4};
        System.out.println(TeamNums(height));
    }

    public static int TeamNums (int[] height) {
        // write code here
        int count = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                for (int k = j+1; k < height.length; k++) {
                    if ((height[i] > height[j] && height[i] > height[k] && height[j] > height[k])
                            || (height[i] < height[j] && height[i] <height[k] && height[j] < height[k])
                    )
                        count++;
                }
            }
        }
        return count;
    }


}
