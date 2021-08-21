/**
 * 类描述:
 *
 * @ClassName common
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/7 17:26
 */
public class common {
    private static int a = 100;
    public static void main(String[] args) {
        common c1 = new common();
        c1.a++;
        common c2 = new common();
        c2.a++;
        c1 = new common();
        c1.a++;
        common.a++;
        System.out.println(a);

    }
}
