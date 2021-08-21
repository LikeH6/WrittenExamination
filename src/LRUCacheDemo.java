import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 类描述:
 *
 * @ClassName LRUCacheDemo
 * @Description
 * @Author chenjiahao
 * @Date 2021/6/23 10:36
 */
public class LRUCacheDemo<k,v> extends LinkedHashMap<k,v> {
    private int capacity; // 缓存坑位

    @Override
    protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
        return super.size() > capacity;  // size大于capacity,则最近最少使用的remove
    }


    /*
                参数accessOrder:
                    为true：access-order,按照使用顺序
                    为false：insertion-order，按照插入顺序
                 */
    public LRUCacheDemo(int capacity){
        super(capacity,0.75F,false);
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRUCacheDemo lRUCacheDemo = new LRUCacheDemo(3);
        lRUCacheDemo.put(1,"a");
        lRUCacheDemo.put(2,"b");
        lRUCacheDemo.put(3,"c");
        System.out.println(lRUCacheDemo.keySet());
        lRUCacheDemo.put(4,"d");
        System.out.println(lRUCacheDemo.keySet());
        lRUCacheDemo.put(3,"c");
        System.out.println(lRUCacheDemo.keySet());
        lRUCacheDemo.put(3,"c");
        System.out.println(lRUCacheDemo.keySet());
        lRUCacheDemo.put(3,"c");
        System.out.println(lRUCacheDemo.keySet());
        lRUCacheDemo.put(5,"x");
        System.out.println(lRUCacheDemo.keySet());

        /*
        accessOrder:
            为true时的结果为：
            [1, 2, 3]
            [2, 3, 4]
            [2, 4, 3]
            [2, 4, 3]
            [2, 4, 3]
            [4, 3, 5]
            false时的结果为：
            [1, 2, 3]
            [2, 3, 4]
            [2, 3, 4]
            [2, 3, 4]
            [2, 3, 4]
            [3, 4, 5]
         */


    }

}
