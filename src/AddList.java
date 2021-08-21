import java.util.List;

/**
 * 类描述:
 *
 * @ClassName AddList
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/5 15:17
 */
public class AddList {
    public static void main(String[] args) {
        // 使用泛型后的写法
        // ListNode<String> a = new ListNode<>("9",null);

        // 不使用泛型后的写法
        ListNode a = new ListNode(9,null);
        ListNode b = new ListNode(7,a);
        ListNode c = new ListNode(4,b);
        ListNode head = new ListNode(2,c);

        ListNode t = add(head,1);
        while(t != null) {
            System.out.println(t.val);
            t =t.next;
        }
    }

    public static ListNode add(ListNode head,int val){
        ListNode temp = new ListNode(val,null);
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null && curr.val < val){
            pre = curr;
            curr = curr.next;
        }
        // 插在头结点
        if (pre == null){
            temp.next = curr;
            return temp;
        }else {
            temp.next = pre.next;
            pre.next = temp;
        }

        return head;


    }

    // 使用泛型
    static class TListNode<T>{
        T val;
        TListNode next;
        TListNode(T val,TListNode next){
            this.val = val;
            this.next = next;
        }
    }

    // 不使用泛型
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

}
