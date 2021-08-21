package 小红书;

import java.util.*;

/**
 * 类描述:
 *
 * @ClassName subject3
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/21 10:53
 */
public class subject3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n<3){
            System.out.println(0);
            return;
        }
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> list = new ArrayList<>();
            String[] s = scanner.next().split("-");
            list.add(s[0]);
            list.add(s[1]);
            lists.add(list);
        }
        Collections.sort(lists, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                if (o1.get(0).compareTo(o2.get(0))==0)
                    return o1.get(1).compareTo(o2.get(1));
                return o1.get(0).compareTo(o2.get(0));
            }
        });

        List<List<List<String>>> ress = new ArrayList<>();

        int flag = 0;
        for (int i = 0; i < lists.size()-1; i++) {
            List<List<String>> res = new ArrayList<>();
            res.add(lists.get(i));


            int temp = i;
            while(temp<lists.size()-1){
                int j = temp;
                int k = j+1;
                while(j<lists.size()-1 && k<lists.size()){
                    if (lists.get(j).get(1).compareTo(lists.get(k).get(0)) <= 0)
                    {
                        res.add(lists.get(k));
                        j++;
                    }
                    k++;

                }

                if (res.size()>=3){
                    //System.out.println(res);
                    ress.add(res);
                    flag = 1;
                }
                temp++;
            }


        }
        if (flag == 0){
            System.out.println(0);
            return;
        }
        int max = 0;
        for (int i = 0; i < ress.size(); i++) {
            int[] nums = new int[ress.get(i).size()];
            for (int j = 0; j < ress.get(i).size(); j++) {
                nums[j] = calTime(ress.get(i).get(j));
            }
            Arrays.sort(nums);
            int len = ress.get(i).size();
            if (nums[len-1]+nums[len-2]+nums[len-3] > max)
                max = nums[len-1]+nums[len-2]+nums[len-3];
        }
        System.out.println(max);

    }
    public static int calTime(List<String> list){
        String time1 = list.get(0);
        String time2 = list.get(1);
        int h1 = Integer.parseInt(time1.split(":")[0]);
        int m1 = Integer.parseInt(time1.split(":")[1]);

        int h2 = Integer.parseInt(time2.split(":")[0]);
        int m2 = Integer.parseInt(time2.split(":")[1]);
        if (h1 == h2){
            return m2-m1;
        }else {
            return (h2-h1)*60+m2-m1;
        }
    }
}
