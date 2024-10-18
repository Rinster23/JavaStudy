import java.security.PublicKey;
import java.util.*;

public class h2_collection_dict {
    public static void main(String[] args) {
        b2_Person s = new b2_Person("Xiao Ming", 99);
        Map<String, b2_Person> map = new HashMap<>();
        map.put("Xiao Ming", s); // 将"Xiao Ming"和Student实例映射并关联
        b2_Person target = map.get("Xiao Ming"); // 通过key查找并返回映射的Student实例
        System.out.println(target == s); // true，同一个实例
        System.out.println(target.getAge()); // 99
        b2_Person another = map.get("Bob"); // 通过另一个key查找
        System.out.println(another); // 未找到返回null
//        如果只是想查询某个key是否存在，可以调用boolean containsKey(K key)方法
//        Map中不存在重复的key，因为放入相同的key，只会把原有的key-value对应的value给替换掉
        // 遍历
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("apple", 123);
        map2.put("pear", 456);
        map2.put("banana", 789);
//        遍历Map时，不可假设输出的key是有序的！
        for (String key : map2.keySet()) {
            Integer value = map2.get(key);
            System.out.println(key + " = " + value);
        }
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " = " + value);
        }

//        为key的对象必须正确覆写equals()方法，相等的两个key实例调用equals()必须返回true；
//        作为key的对象还必须正确覆写hashCode()方法，且hashCode()方法要严格遵循以下规范：
//        如果两个对象相等，则两个对象的hashCode()必须相等；
//        如果两个对象不相等，则两个对象的hashCode()尽量不要相等

//        如果key是enum类型，可以用EnumMap，更高效
//        有序key的map是TreeMap
        Map<String, Integer> map3 = new TreeMap<>();
        map3.put("orange", 1);
        map3.put("apple", 2);
        map3.put("pear", 3);
        for (String key : map.keySet()) {
            System.out.println(key);    // apple, orange, pear
        }
//        用TreeMap时，放入的Key必须实现Comparable接口
//        如果作为Key的class没有实现Comparable接口，那么，必须在创建TreeMap时同时指定一个自定义排序算法：
        Map<b2_Person, Integer> map4 = new TreeMap<>(new Comparator<b2_Person>() {
            // 这里的自定义比较方法对Key的必须实现相等、大于和小于逻辑！
            public int compare(b2_Person p1, b2_Person p2) {
                return p1.name.compareTo(p2.name);
            }
        }); // 也就是按名字String排序
        // 注意到使用TreeMap key不需要覆写hashcode和equals
    }
}

class h2_Person {
    private String name;
    private int age;

    public h2_Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof h2_Person p) {
            return Objects.equals(this.name, p.name) && this.age == p.age;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
//    编写equals()和hashCode()遵循的原则是：
//    equals()用到的用于比较的每一个字段，都必须在hashCode()中用于计算；equals()中没有使用到的字段，绝不可放在hashCode()中计算
}
