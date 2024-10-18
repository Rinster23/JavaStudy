public interface b3_Shape {
    // 如果一个抽象类没有字段，所有方法全部都是抽象方法，就可以把该抽象类改写为接口
    // 接口定义的所有方法默认都是public abstract的，所以这两个修饰符不需要写出来
    // implement抽象类的时候必须覆写这边的所有方法
    double getArea();
    void draw();
    // default方法不需要被覆写
    default void printArea() {
        System.out.println("Area is" + getArea());
    }

}

// 一个类只能继承自另一个类，但是一个类可以实现多个interface
// 接口也可以继承另一个接口
class b3_Square implements b3_Shape {
    private final float edgeLength;

    public b3_Square(float len) {
        this.edgeLength = len;
    }

    @Override
    public double getArea() {
        return Math.pow(this.edgeLength, 2);
    }

    @Override
    public void draw() {
        System.out.println("Draw a square");
    }
}