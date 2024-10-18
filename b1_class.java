import java.util.Arrays;

public class b1_class {
    public static void main(String[] args) {
        Person0 p = new Person0();
        p.setName("Xiao Ming");
        p.setAge(12);
        System.out.println(p.getName() + ", " + p.getAge());

        Group g = new Group();
        g.setNames("Xiao Ming", "Xiao Hong", "Xiao Jun");
        System.out.println(Arrays.toString(g.names));
        // 参数绑定
        // 基本类型传递的是值，引用类型传递的是引用
        Car benz = new Car();
        int max_speed = 120;
        benz.setSpeed(max_speed);
        max_speed = 220;
        System.out.println(benz.getSpeed()); // 120 不会改变

        String[] benz_type = {"Benz", "C200"};
        benz.setName(benz_type); // 引用类型作为参数时相当于是传入一个指针，这个指针指向一个数组对象
        benz_type[1] = "S500";  // 修改了数组对象 实例的属性随之改变
        System.out.println(benz.getName()); // Benz S500
        // String也是引用类型
        String country = "China";
        benz.setCountry(country);
        country = "Germany";
        System.out.println(benz.getCountry()); // China
        // 这里反而不会改变 因为String是不可变对象
        /*
        String 和 String[] 都是引用类型，存储的是对象的引用。但是String类型的对象是不可变的，
        也就是说，一旦创建了一个 String 对象，就无法再修改它的值，任何对 String 对象的修改都会创建一个新的对象。
        而 String[] 类型的对象是可变的，也就是说，可以修改数组中的元素值。
        当我们将一个 String[] 类型的变量传递给一个方法时，实际上传递的是该变量所引用的数组对象在内存中的地址。
        因此，当我们在方法中修改数组中的元素值时，对数组进行的修改会影响到原始数组，在方法返回后也能保留。
        而String类型因为不可变，修改即创建新的对象也就有了新的地址，所以方法中引用的地址的值没有改变，输出的结果也就没有改变
         */
        // 方法重载
        String s = "Test string";
        int n1 = s.indexOf('t');    // 3
        int n2 = s.indexOf("st"); //2
        int n3 = s.indexOf("st", 3); //5
        System.out.println(n1 + " " + n2 + " " + n3);

    }
}

class Group {
    public String[] names;

    public void setNames(String... names) {
        this.names = names;
    }
}

class Person0 {
    private String name;
    private int age;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        // this表示实例自身 不然会指局部变量
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
}

class Car {
    private String[] name;
    private int speed;
    private String country;

    // 不写的话编译器会自动构造默认构造方法
    // 没有在构造方法中初始化字段时，引用类型的字段默认是null，数值类型的字段用默认值，int类型默认值是0，布尔类型默认值是false
    public Car() {
    }

    // 可以定义多个构造方法，在通过new操作符调用的时候，编译器通过构造方法的参数数量、位置和类型自动区分
    public Car(String[] name, int speed, String country) {
        this.name = name;
        this.speed = speed;
        this.country = country;
    }

    // 也可以在一个构造方法中调用另一个构造方法
    public Car(String[] name, int speed) {
        this(name, speed, "China");
    }

    public String getName() {
        return this.name[0] + " " + this.name[1];
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }
}


