import java.lang.reflect.Array;

public class g3_super {
    public static void main(String[] args) {
        g2_Pair<Number> p1 = new g2_Pair<>(12.3, 4.56);
        g2_Pair<Integer> p2 = new g2_Pair<>(123, 456);
        setSame(p1, 100);
        setSame(p2, 200);
        System.out.println(p1.getFirst() + ", " + p1.getLast());
        System.out.println(p2.getFirst() + ", " + p2.getLast());
        // get只能读成Object最大的父类
        Object x = p1.getFirst();

        // 我们可以声明带泛型的数组，但不能用new操作符创建带泛型的数组
        // g2_Pair<String>[] ps = null; // ok
        // g2_Pair<String>[] ps = new g2_Pair<String>[2]; // compile error!
        // 必须通过强制转型实现带泛型的数组
        @SuppressWarnings("unchecked")
        g2_Pair<String>[] ps = (g2_Pair<String>[]) new g2_Pair[2];

    }

    // 和extends相反，super允许传入Integer的父类
    static void setSame(g2_Pair<? super Integer> p, Integer n) {
        p.setFirst(n);
        p.setLast(n);
    }

//    <? extends T>允许调用读方法T get()获取T的引用，但不允许调用写方法set(T)传入T的引用（传入null除外）；
//    <? super T>允许调用写方法set(T)传入T的引用，但不允许调用读方法T get()获取T的引用（获取Object除外）。
//    一个是允许读不允许写，另一个是允许写不允许读。
}

//可以通过Array.newInstance(Class<T>, int)创建T[]数组，需要强制转型
class g3_Abc<T> {
    T[] createArray(Class<T> cls) {
        return (T[]) Array.newInstance(cls, 5);
    }
}
