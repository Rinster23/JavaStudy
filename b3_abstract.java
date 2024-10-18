
// 有些父类的方法就是为了被override的，可以将其实现为抽象方法
// 同时也必须将该类实现为抽象类
// 抽象类无法被实例化 因为抽象类本身被设计成只能用于被继承
abstract class b3_Person {
    // 可以定义实例字段
    // 可以定义非抽象方法
    public abstract void run();
}