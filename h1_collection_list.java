import java.util.Iterator;
import java.util.List;

public class h1_collection_list {
    public static void main(String[] args) {
//        ArrayList把添加和删除的操作封装起来，让我们操作List类似于操作数组，却不用关心内部元素如何移动
//        我们考察List<E>接口，可以看到几个主要的接口方法：
//        在末尾添加一个元素：boolean add(E e)
//        在指定索引添加一个元素：boolean add(int index, E e)
//        删除指定索引的元素：E remove(int index)
//        删除某个元素：boolean remove(Object e)
//        获取指定索引的元素：E get(int index)
//        获取包含元素的个数：int size()
//        list允许重复也允许添加null
//        要始终坚持使用迭代器Iterator来访问List
        List<String> list = List.of("a", "b", "c");
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }
//        上面的循环就等于
        for (String s : list) {
            System.out.println(s);
        }
//        List转换成数组
//        如果传入的数组不够大，那么List内部会创建一个新的刚好够大的数组，填充后返回；
//        如果传入的数组比List元素还要多，那么填充完元素后，剩下的数组元素一律填充null
        String[] array = list.toArray(new String[list.size()]);
//        Array转List
        Integer[] arr = new Integer[]{1, 2, 3};
        List<Integer> arr2 = List.of(arr); // 如果我们调用List.of()，它返回的是一个只读List
//        List还提供了boolean contains(Object o)方法来判断List是否包含某个指定元素。
//        此外，int indexOf(Object o)方法可以返回某个元素的索引，如果元素不存在，就返回-1
        System.out.println(list.contains(new String("b"))); // true
//        ist内部并不是通过==判断两个元素是否相等，而是使用equals()方法判断两个元素是否相等
//        因此，要正确使用List的contains()、indexOf()这些方法，放入的实例必须正确覆写equals()方法
//        要求x.equals(null)永远返回false 可以调用Objects.equals(this.firstName, p.firstName)
    }
}
