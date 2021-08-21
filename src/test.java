import java.util.*;



public class test {
    public static void main(String[] args) {
        String s1 = "abb";
        String s2 = "eidbaboo";
        boolean res = compareStr(s1,s2);
        System.out.println(res);
    }

    //  s1= "abb" s2 = "eidboaoo"
    public static boolean compareStr(String s1,String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        if (len2 < len1)
            return false;
        Map<Character,Integer> map1 = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
        }
        for (int i = 0; i < len2-len1; i++) {
            Map<Character,Integer> map2 = new HashMap<>();
            for (int j = 0; j < len1; j++) {
                map2.put(s2.charAt(i+j),map2.getOrDefault(s2.charAt(i+j),0)+1);

            }
            int flag = 0;
            for (Character key : map1.keySet()){
                if (! map2.containsKey(key)){
                    flag = 1;
                    break;
                }else {
                    if (map1.get(key) != map2.get(key)){
                        flag = 1;
                        break;
                    }
                }

            }
            if (flag == 0)
                return true;

        }
        return false;

    }
}


