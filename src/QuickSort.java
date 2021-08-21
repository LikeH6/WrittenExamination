/**
 * 类描述:
 *
 * @ClassName QuickSort
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/2 16:23
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{6,3,7,9,5,5,1,4,8};
        quickSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    // 用来进行快速排序
    public static void quickSort(int[] arr,int left,int right){
        // 如果左边索引大于右边索引，不合法，直接return
        if (left > right)
            return;

        // 定义变量保存基准数,把最左边的当作基准数
        int base = arr[left];
        // 定义变量i指向最左边
        int i = left;
        // 定义变量j指向最右边
        int j = right;

        // i和j不相遇的时候，在循环中进行检索
        while (i != j){
            // 先由j从右往左检索比基准数小的，如果检索到比基准数小的，就停下
            // 如果检索到比基准数大的或者相等的，就继续检索
            while (arr[j] >= base && i < j){
                j--; // j 从右往左移动
            }
            // 先由i从左往右检索比基准数大的，如果检索到比基准数大的，就停下
            // 如果检索到比基准数小的或者相等的，就继续检索
            while (arr[i] <= base && i < j){
                i++; // i 从左往右移动
            }

            // 如果代码走到这里。i j 停下，说明都找到了，然后交换i j位置的元素
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // 如果上面while循环的条件不成立，就跳出循环
        // 如果条件不成立，说明i和j相遇了
        // i和j相遇了，则交换基准数和这个相遇位置的元素
        arr[left] = arr[i];
        arr[i] = base;  // 使用base，不要重新定义一个中间变量

        // 基准数在这里就归位了，左边比它小，右边比它大

        // 排基准数左边的
        quickSort(arr,left,i-1);
        // 排基准数右边的
        quickSort(arr,i+1,right);

    }
}
