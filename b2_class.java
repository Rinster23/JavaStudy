public class b2_class {
    public static void main(String[] args) {
        // 正常情况下，只要某个class没有final修饰符，那么任何类都可以从该class继承。
        // 从Java 15开始，允许使用sealed修饰class，并通过permits明确写出能够从该class继承的子类名称。
        b2_Person p = new b2_Student();   // upcasting
        // down casting 借助instanceof判断
        Object obj = "hello";
        if (obj instanceof String s) {
            // 判断instanceof后，可以直接转型为指定变量，避免再次强制转型
            System.out.println(s.toUpperCase());
        }

        p.run(); // student run 实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型 这种特性称为多态
        // 因为所有类都继承了object类，object实现了toString()、equals()、hashCode()方法，我们也可以override它们
        // 在子类的覆写方法中，如果要调用父类的被覆写的方法，可以通过super来调用
//        class Person {
//            public final String name; 即实例一旦创建final字段就不可修改
//            public Person(String name) {
//                this.name = name;
//            }
//        }
    }
}

class b2_Person {
    // protected表示允许子类访问字段
    protected String name;
    protected int age;

    public b2_Person() {
    }

    public b2_Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("invalid age value");
        }
        this.age = age;
    }

    public void run() {
        System.out.println("person run");
    }
}

// 子类自动获得了父类的所有字段，严禁定义与父类重名的字段！
class b2_Student extends b2_Person {
    // 不要重复name和age字段/方法,
    // 只需要定义新增score字段/方法:
    private int score;

    public b2_Student() {
    }

    public b2_Student(String name, int age, int score) {
        super(name, age); // 调用父类的构造方法Person(String, int)
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void sayHello() {
        System.out.println("Hello, " + this.name);
        // 也可以super.name 用super调用父类的字段和方法
    }

    @Override
    // 方法名、参数、返回值必须和父类一样才是override
    // @Override注解用来让编译器检查该方法是否正确地实现了覆写，不是必须
    public void run() {
        System.out.println("student run");
    }
}
