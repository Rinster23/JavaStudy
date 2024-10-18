import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class e2_reflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        Field getField(name)：根据字段名获取某个public的field（包括父类）
//        Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
//        Field[] getFields()：获取所有public的field（包括父类）
//        Field[] getDeclaredFields()：获取当前类的所有field（不包括父类）
        Class cls = b2_Student.class;
        System.out.println(cls.getDeclaredField("score"));
//        一个Field对象包含了一个字段的所有信息
//        getName()：返回字段名称，例如，"name"；
//        getType()：返回字段类型，也是一个Class实例，例如，String.class；
//        getModifiers()：返回字段的修饰符，它是一个int，不同的bit表示不同的含义。
        Field f = String.class.getDeclaredField("value");
        System.out.println(f.getName()); // "value"
        System.out.println(f.getType()); // class [B 表示byte[]类型
        int m = f.getModifiers();
        Modifier.isFinal(m); // true
        Modifier.isPublic(m); // false
        Modifier.isProtected(m); // false
        Modifier.isPrivate(m); // true
        Modifier.isStatic(m); // false

        // 获取字段的值
        var p = new b2_Person("Xiao Ming", 23);
        Class c = p.getClass();
        Field f2 = c.getDeclaredField("name");
        var value = f2.get(p);
        System.out.println(value); // "Xiao Ming"
        // 这里name是protected可以直接获取，但是private就不能直接获取
        // 需要Field.setAccessible(true); 这样也不一定能成功
//        var stu = new b2_Student("Mike", 23, 99);
//        Field f3 = stu.getClass().getDeclaredField("score");
//        f3.setAccessible(true);
//        var score = f3.get("score");
//        System.out.println(score);

        // 修改字段的值
        f2.set(p, "Xiao Jun");
        System.out.println(p.getName());
        // 还可以获取方法、构造方法、继承关系

        // 反射是一种非常规的用法，使用反射，首先代码非常繁琐，其次，它更多地是给工具或者底层框架来使用，
        // 目的是在不知道目标实例任何信息的情况下，获取特定字段的值。
    }
}
