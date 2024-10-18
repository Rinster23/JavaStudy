public class e1_reflection {
    // 每加载一种我们写的类时，JVM就为其创建一个Class类型的实例，并关联起来
    // 例如 Class cls = new Class(String);
    // 只有JVM能创建Class实例，我们自己的Java程序是无法创建Class实例的
    // 一个Class实例包含了该类的所有完整信息
    // reflect不是常用方法，只是为了给一个实例我们通过这个实例获取更多信息
//    Class 实例       ────▶ String
//    │name = "java.lang.String"  │
//    ├───────────────────────────┤
//    │package = "java.lang"      │
//    ├───────────────────────────┤
//    │super = "java.lang.Object" │
//    ├───────────────────────────┤
//    │interface = CharSequence...│
//    ├───────────────────────────┤
//    │field = value[],hash,...   │
//    ├───────────────────────────┤
//    │method = indexOf()...      │
//    因此，如果获取了某个Class实例，我们就可以通过这个Class实例获取到该实例对应的类的所有信息。
//    这种通过Class实例获取class信息的方法称为反射 reflection
//    获取一个类的实例有三种方法
    public static void main(String[] args) throws ClassNotFoundException {
        // 方法一
        Class cls = String.class;
        // 方法二
        String s = "Hello";
        cls = s.getClass();
        // 方法三
        cls = Class.forName("java.lang.String");
        // 因为Class实例在JVM中是唯一的，所以上述方法获取的Class实例是同一个实例，可以用==比较两个Class实例

//        Integer n = Integer.valueOf(123);
//        boolean b1 = n instanceof Integer; // true，因为n是Integer类型
//        boolean b2 = n instanceof Number; // true，因为n是Number类型的子类
//        boolean b3 = n.getClass() == Integer.class; // true，因为n.getClass()返回Integer.class
//        boolean b4 = n.getClass() == Number.class; // false，因为Integer.class!=Number.class

        printClassInfo(int.class);
        printClassInfo(String[].class);

        // JVM在执行Java程序的时候，并不是一次性把所有用到的class全部加载到内存，而是第一次需要用到class时才加载
    }

    public static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }
}


