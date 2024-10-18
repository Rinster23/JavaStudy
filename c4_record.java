public class c4_record {
    // 不变类如String Integer, 定义class的时候使用final, 每个字段都是final
    // 使用record可以一行写出一个不变类
    // 除了用final修饰class以及每个字段外，编译器还自动为我们创建了构造方法，和字段名同名的方法
    // 以及覆写toString()、equals()和hashCode()方法

    public static void main(String[] args) {
        var p = c4_Point.of();
        var q = c4_Point.of(11, 22);
    }
}

record c4_Point(int x, int y) {
    public c4_Point {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
    }

    // 作为record的Point仍然可以添加静态方法。一种常用的静态方法是of()方法，用来创建Point
    public static c4_Point of() {
        return new c4_Point(0, 0);
    }

    public static c4_Point of(int x, int y) {
        return new c4_Point(x, y);
    }
}
// 注意到方法public Point {...}被称为Compact Constructor，
// 它的目的是让我们编写检查逻辑，编译器最终生成的构造方法如下：
//public final class Point extends Record {
//    public Point(int x, int y) {
//        // 这是我们编写的Compact Constructor:
//        if (x < 0 || y < 0) {
//            throw new IllegalArgumentException();
//        }
//        // 这是编译器继续生成的赋值代码:
//        this.x = x;
//        this.y = y;
//    }
//    ...
//}