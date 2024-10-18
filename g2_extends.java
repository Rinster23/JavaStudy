import java.util.List;

public class g2_extends {
    public static void main(String[] args) {
        g2_Pair<Integer> p = new g2_Pair<>(12, 3);
        // Java通过擦拭法实现泛型 Type Erasure
//        编译器把类型<T>视为Object
//        编译器根据<T>实现安全的强制转型
//        局限一：<T>不能是基本类型，例如int，因为实际类型是Object，Object类型无法持有基本类型：
//        局限二：无法取得带泛型的Class---Pair<String>和Pair<Integer>类型获取Class时，获取到的是同一个Class（Pair类的Class）
//        局限三：无法判断带泛型的类型 p instanceof Pair<String, Integer>
//        局限四：不能实例化T类型，必须借助额外的Class<T>参数用反射实例化
//        注意Pair<Integer>不是Pair<Number>的子类
        int n = add(p); // add不加extend会报错，因为Pair<Integer>不是Pair<Number>的子类，因此，add(Pair<Number>)不接受参数类型Pair<Integer>

        // extends限定T类型
        numPair<Number> p1 = null;
        numPair<Integer> p2 = new numPair<>(1, 2);
        numPair<Double> p3 = null;
//        numPair<String> p1 = null; // compile error!
//        numPair<Object> p2 = null; // compile error!
    }

    // 接受一切泛型类型为Number的子类的Pair类型作为输入
    static int add(g2_Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        // p.setFirst(new Integer(first.intValue() + 100)); 编译错误
        // 原因还在于擦拭法。如果我们传入的p是Pair<Double>，显然它满足参数定义Pair<? extends Number>，然而，Pair<Double>的setFirst()显然无法接受Integer类型
        return first.intValue() + last.intValue();
    }

    int sumOfList(List<? extends Integer> list) {
        //从方法内部代码看，传入List<? extends Integer>或者List<Integer>是完全一样的，但是，注意到List<? extends Integer>的限制：
        //允许调用get()方法获取Integer的引用；
        //不允许调用set(? extends Integer)方法并传入任何Integer的引用（null除外）。
        //因此，方法参数类型List<? extends Integer>表明了该方法内部只会读取List的元素，不会修改List的元素（因为无法调用add(? extends Integer)、remove(? extends Integer)这些方法。
        // 换句话说，这是一个对参数List<? extends Integer>进行只读的方法
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            Integer n = list.get(i);
            sum = sum + n;
        }
        return sum;
    }
}

class g2_Pair<T> {
    private T first;
    private T last;

    public g2_Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setLast(T last) {
        this.last = last;
    }

    public T getFirst() {
        return this.first;
    }

    public T getLast() {
        return this.last;
    }
}

// 使用extends限定T类型
class numPair<T extends Number> {
    private T m;
    private T n;

    public numPair() {
    }

    public numPair(T a, T b) {
        this.m = a;
        this.n = b;
    }
}


// 多个未知类型
//class g2_Pair<T, K> {
//    private T first;
//    private K last;
//
//    public g2_Pair(T first, K last) {
//        this.first = first;
//        this.last = last;
//    }
//
//    public void setFirst(T first) {
//        this.first = first;
//    }
//
//    public void setLast(K last) {
//        this.last = last;
//    }
//
//    public T getFirst() {
//        return this.first;
//    }
//
//    public K getLast() {
//        return this.last;
//    }
//}
