package 一点资讯;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 类描述:
 *
 * @ClassName subject1
 * @Description
 * @Author chenjiahao
 * @Date 2021/7/30 20:10
 */
public class subject1 {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> timeSchedule = new ArrayList<ArrayList<String>>();
        ArrayList<String> time = new ArrayList<>();
        ArrayList<String> time1 = new ArrayList<>();

        ArrayList<String> time2 = new ArrayList<>();

        time.add("10:00");
        time.add("12:00");
        timeSchedule.add(time);
        time1.add("03:00");
        time1.add("11:30");
        timeSchedule.add(time1);
        time2.add("11:30");
        time2.add("14:00");
        timeSchedule.add(time2);

        Collections.sort(timeSchedule, new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        for (int i = 0; i < 3; i++) {
            System.out.println(timeSchedule.get(i));
        }
        int res = 1;
        for (int i = 0; i < timeSchedule.size()-1; i++) {
            for (int j = i+1; j < timeSchedule.size(); j++) {
                if (timeSchedule.get(i).get(1).compareTo(timeSchedule.get(j).get(0)) <= 0)
                    res++;
            }
        }
        System.out.println(res);
    }

//    public static void dfs(ArrayList<ArrayList<String>> timeSchedule,int res,){
//
//    }
}
