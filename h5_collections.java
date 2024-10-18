import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class h5_collections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pineapple");
        list.add("peach");
        System.out.println(list);
        Collections.sort(list);
        Collections.shuffle(list);

//        Collections还提供了一组方法把可变集合封装成不可变集合：
//        封装成不可变List：List<T> unmodifiableList(List<? extends T> list)
//        封装成不可变Set：Set<T> unmodifiableSet(Set<? extends T> set)
//        封装成不可变Map：Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> m)
        List<String> mutable = new ArrayList<>();
        mutable.add("apple");
        mutable.add("pear");
        // 变为不可变集合:
        List<String> immutable = Collections.unmodifiableList(mutable);
        // immutable.add("orange"); // UnsupportedOperationException!
//        然而，继续对原始的可变List进行增删是可以的，并且，会直接影响到封装后的“不可变”List
//        mutable.add("orange");
//        System.out.println(immutable);
//        因此，如果我们希望把一个可变List封装成不可变List，
//        最好立刻扔掉可变List的引用，这样可以保证后续操作不会意外改变原始对象，从而造成“不可变”List变化了：
        mutable = null;
    }
}
