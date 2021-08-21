import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {


        Map<String,String> map = new ConcurrentHashMap<>();

        ConcurrentHashMap map1 = new ConcurrentHashMap();
        for (int i = 0; i < 46; i++) {
            map1.put("adg"+i,i);
        }
        System.out.println(
                map1.toString()
        );
        System.out.println(map1.size());

        int initialCapacity = 17;
        int c = initialCapacity + (initialCapacity >>> 1) + 1;
        System.out.println(c);
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int MAXIMUM_CAPACITY = 1 << 30;
        System.out.println((n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1);
        List<Integer> list=new ArrayList<>();
        Collections.sort(list);
    }
}
