import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//    注释会被编译器直接忽略，注解则可以被编译器打包进入class文件，因此，注解是一种用作标注的“元数据”。
//    @Override：让编译器检查该方法是否正确地实现了覆写
//    @SuppressWarnings：告诉编译器忽略此处代码产生的警告
//    一个配置了@PostConstruct的方法会在调用构造方法后自动被调用
//    有一些注解可以修饰其他注解，这些注解就称为元注解 meta annotation

//    最常用的元注解是@Target。使用@Target可以定义Annotation能够被应用于源码的哪些位置：
//    类或接口：ElementType.TYPE；
//    字段：ElementType.FIELD；
//    方法：ElementType.METHOD；
//    构造方法：ElementType.CONSTRUCTOR；
//    方法参数：ElementType.PARAMETER

//    另一个重要的元注解@Retention定义了Annotation的生命周期：
//    仅编译期：RetentionPolicy.SOURCE；
//    仅class文件：RetentionPolicy.CLASS；
//    运行期：RetentionPolicy.RUNTIME。
//    如果@Retention不存在，则该Annotation默认为CLASS。
//    因为通常我们自定义的Annotation都是RUNTIME，所以，务必要加上@Retention(RetentionPolicy.RUNTIME)这个元注解

// 定义注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Range {
    int min() default 0;  // 最小值，默认为0

    int max() default 8;  // 最大值，默认为100
}

class f1_Person {
    @Range
    public String name;

    @Range(min = 3, max = 10)
    public String address;
}

