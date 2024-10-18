import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class g1_template {
    public static void main(String[] args) {
        // 如ArrayList，既可以放int 也可以String，Double等，为了不需要转型，可以把ArrayList写成模板方便使用，更高效

        // 可以省略后面的String，编译器可以自动推断泛型类型：
        List<String> list = new ArrayList<>();

        // 除了ArrayList<T>使用了泛型，还可以在接口中使用泛型。
        // 例如，Arrays.sort(Object[])可以对任意数组进行排序，但待排序的元素必须实现Comparable<T>这个泛型接口
        g1_person[] ps = new g1_person[]{new g1_person("Nancy", 87), new g1_person("Ann", 99), new g1_person("Yang", 100)};
        Arrays.sort(ps);
        System.out.println(Arrays.toString(ps));
    }
}

interface Comparable<T> {
    /**
     * 返回负数: 当前实例比参数o小
     * 返回0: 当前实例与参数o相等
     * 返回正数: 当前实例比参数o大
     */
    int compareTo(T o);
}

class g1_person implements Comparable<g1_person> {
    String name;
    int score;

    g1_person(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int compareTo(g1_person other) {
        return this.name.compareTo(other.name);
        // String本身已经实现了Comparable<String>接口
    }

    public String toString() {
        return this.name + "," + this.score;
    }
}