import java.util.*;

public class h3_set_q_stack {
//    Set用于存储不重复的元素集合，它主要提供以下几个方法：
//    将元素添加进Set<E>：boolean add(E e)
//    将元素从Set<E>删除：boolean remove(Object e)
//    判断是否包含元素：boolean contains(Object e)
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        System.out.println(set1.add("abc")); // true
        System.out.println(set1.add("xyz")); // true
        System.out.println(set1.add("xyz")); // false，添加失败，因为元素已存在
        System.out.println(set1.contains("xyz")); // true，元素存在
        System.out.println(set1.contains("XYZ")); // false，元素不存在
        System.out.println(set1.remove("hello")); // false，删除失败，因为元素不存在
        System.out.println(set1.size()); // 2，一共两个元素
//        和Map的key一样，需要覆写equals和hashcode
//        HashSet并不保证有序，而TreeSet则保证元素是有序的
//        使用TreeSet和使用TreeMap的要求一样，添加的元素必须正确实现Comparable接口，
//        如果没有实现Comparable接口，那么创建TreeSet时必须传入一个Comparator对象
        // Queue FIFO
//                           throw Exception	返回false或null
//        添加元素到队尾	        add(E e)	   boolean offer(E e)
//        取队首元素并删除	        E remove()	        E poll()
//        取队首元素但不删除	    E element()	        E peek()
        Queue<String> q = new LinkedList<>();
//        LinkedList即实现了List接口，又实现了Queue接口
        List<String> q2 = new LinkedList<>();

        // PriorityQueue
//        放入PriorityQueue的元素，必须实现Comparable接口，PriorityQueue会根据元素的排序顺序决定出队的优先级
//        也可以提供一个Comparator对象来判断两个元素的顺序 较小的在前
        Queue<h3_User> q3 = new PriorityQueue<>(new h3_UserComparator());
        // 添加3个元素到队列:
        q3.offer(new h3_User("Bob", "A1"));
        q3.offer(new h3_User("Alice", "A2"));
        q3.offer(new h3_User("Boss", "V1"));
        System.out.println(q3.poll()); // Boss/V1
        System.out.println(q3.poll()); // Bob/A1
        System.out.println(q3.poll()); // Alice/A2
        System.out.println(q3.poll()); // null,因为队列为空

        // stack需要使用Deque来模拟
    }
}

//Comparator是一个泛型接口
class h3_UserComparator implements Comparator<h3_User> {
    public int compare(h3_User u1, h3_User u2) {
        if (u1.number.charAt(0) == u2.number.charAt(0)) {
            // 如果两人的号都是A开头或者都是V开头,比较号的大小:
            return u1.number.compareTo(u2.number);
        }
        if (u1.number.charAt(0) == 'V') {
            // u1的号码是V开头,优先级高:
            return -1;
        } else {
            return 1;
        }
    }
}

class h3_User {
    public final String name;
    public final String number;

    public h3_User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }
}
