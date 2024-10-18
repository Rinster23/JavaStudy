import java.lang.reflect.Field;

public class f1_annotation {
    // 定义了注解@Range，本身对程序逻辑没有任何影响。我们必须自己编写代码来使用注解。
    public static void check(f1_Person person) throws IllegalArgumentException, ReflectiveOperationException {
        // 遍历所有Field:
        for (Field field : person.getClass().getFields()) {
            // 获取Field定义的@Range:
            Range range = field.getAnnotation(Range.class);
            // 如果@Range存在:
            if (range != null) {
                // 获取Field的值:
                Object value = field.get(person);
                // 如果值是String:
                if (value instanceof String s) {
                    // 判断值是否满足@Range的min/max:
                    if (s.length() < range.min() || s.length() > range.max()) {
                        throw new IllegalArgumentException("HEY! Invalid field: " + field.getName());
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws ReflectiveOperationException {
        var f1_p = new f1_Person();
        f1_p.name = "Mike";
        f1_p.address = "s";
        check(f1_p);
    }
}

