public class c2_wrapper {
    public static void main(String[] args) {
        // 引用类型可以赋值为null，表示空，但基本类型不能赋值为null
        // wrapper class把基本类型包装成引用类型
        int i = 100;
        // 通过静态方法valueOf(int)创建Integer实例:
        Integer n2 = Integer.valueOf(i);
        // 通过静态方法valueOf(String)创建Integer实例:
        Integer n3 = Integer.valueOf("100");
        // auto boxing Java编译器可以帮助我们自动在int和Integer之间转型
        Integer n = 100; // 编译器自动使用Integer.valueOf(int)
        int x = n; // 编译器自动使用Integer.intValue()
        // wrapper class都有final修饰
        // Integer是引用类型，必须使用equals()比较

        // Integer提供了很多方法
//        Integer.parseInt("100"); // 100
//        Integer.toString(100);
//        Integer.parseInt("100", 16); // 256,因为按16进制解析
//        Integer.toBinaryString(100);
    }
}
