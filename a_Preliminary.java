import java.util.Arrays;

public class a_Preliminary {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        /* java中有两种变量类型，基本数据类型和引用数据类型
         * 基本数据类型：byte, short, int, long, float, double, char, boolean
         * 引用数据类型：String, Array, Class等
         * 引用类型的变量类似于C语言的指针，指向某个对象在内存的位置
         */
//        int[] ns = new int[5];
//        System.out.println(ns.length); // 5
//        int[] ns2 = new int[]{68, 79, 91, 85, 62};
        int[] ns3 = {68, 79, 91, 85, 62};
//        for (int j : ns2) {
//            System.out.println(j);
//        }
        String[] names = {"ABC", "XYZ", "zoo"};
        String s = names[1];
        names[1] = "cat";
        System.out.println(s);  // XYZ
        Arrays.sort(ns3);
        System.out.println(Arrays.toString(ns3));
        System.out.println(ns3.length / 2);
    }
}

