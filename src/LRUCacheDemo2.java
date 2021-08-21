import java.util.HashMap;
import java.util.Map;

/**
 * 类描述:
 *
 * @ClassName LRUCacheDemo2
 * @Description
 * @Author chenjiahao
 * @Date 2021/6/23 10:51
 */
public class LRUCacheDemo2 {
    // map负责查找，构建一个虚拟的双向链表，它里面安装的就是一个个Node节点，作为数据载体

    // 1、构建一个Node节点，作为数据载体
    class Node<k,v>{
        k key;
        v value;
        Node<k,v> prev;  // 有prev和next，说明是双向链表
        Node<k,v> next;

        public Node(){
            this.prev=this.next=null;
        }
        public Node(k key,v value){
            this.key = key;
            this.value = value;
            this.prev= this.next=null;
        }
    }
    // 2、构造一个虚拟的双向链表，里面安放的是我们的Node
    class DoubleLinkedList<k,v>{
        Node<k,v> head;
        Node<k,v> tail;

        // 2.2 构造方法
        public DoubleLinkedList(){
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.next = head;
        }

        // 2.2 添加到头
        public void addHead(Node<k,v> node){
            node.next  = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        // 2.3 删除节点
        public void removeNode(Node<k,v> node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }

        // 2.4 获得最后一个节点
        public Node getLast(){
            return tail.prev;
        }

    }

    private int cacheSize;
    Map<Integer,Node<Integer,Integer>> map;
    DoubleLinkedList<Integer,Integer> doubleLinkedList;

    public LRUCacheDemo2(int cacheSize){
        this.cacheSize = cacheSize;  // 坑位
        map = new HashMap<>(); // 查找
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key){
        if (!map.containsKey(key))
            return -1;
        Node<Integer,Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }

    public void put(int key,int value){
        if (map.containsKey(key)){
            Node<Integer,Integer> node = map.get(key);
            node.value = value;
            map.put(key,node);

            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        }
        else {
            if (map.size() == cacheSize) // 坑位满了
            {
                Node<Integer,Integer> lastNode = doubleLinkedList.getLast();
                map.remove(lastNode.key);
                doubleLinkedList.removeNode(lastNode);
            }
            // 新增
            Node<Integer,Integer> newNode = new Node<>(key,value);
            map.put(key,newNode);
            doubleLinkedList.addHead(newNode);
        }
    }

    public static void main(String[] args) {
        LRUCacheDemo2 lRUCacheDemo = new LRUCacheDemo2(3);
        lRUCacheDemo.put(1,1);
        lRUCacheDemo.put(2,2);
        lRUCacheDemo.put(3,3);
        System.out.println(lRUCacheDemo.map.keySet());
        lRUCacheDemo.put(4,4);
        System.out.println(lRUCacheDemo.map.keySet());
        lRUCacheDemo.put(3,2);
        System.out.println(lRUCacheDemo.map.keySet());
        lRUCacheDemo.put(3,3);
        System.out.println(lRUCacheDemo.map.keySet());
        lRUCacheDemo.put(3,3);
        System.out.println(lRUCacheDemo.map.keySet());
        lRUCacheDemo.put(5,5);
        System.out.println(lRUCacheDemo.map.keySet());

        /*
        结果为：说明跟false的情况相同
        [1, 2, 3]
        [2, 3, 4]
        [2, 3, 4]
        [2, 3, 4]
        [2, 3, 4]
        [3, 4, 5]
         */
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
