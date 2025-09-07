package java.sealedClass;

/**
 * Sealed Class
 * In Java, we have the concept of abstract classes. It is mandatory to inherit from these classes since objects of these classes
 * cannot be instantiated. On the other hand, there is a concept of a final class in Java, which cannot be inherited or extended by
 * any other class. What if we want to restrict the number of classes that can inherit from a particular class?
 * The answer is sealed class. So, a sealed class is a technique that limits the number of classes that can inherit the given class.
 * This means that only the classes designated by the programmer can inherit from that particular class,
 * thereby restricting access to it. when a class is declared sealed, the programmer must specify the list of classes that can
 * inherit it. The concept of sealed classes in Java was introduced in Java 15 and delivered in 17
 */
public class Demo {
}

sealed interface Shape permits Circle, Rectangle{
    double area();
}

final class Circle implements Shape{
    int radius;

    public Circle(int radius){
        this.radius = radius;
    }

    @Override
    public double area() {
        return 3.14*(radius^2);
    }
}

final class Rectangle implements Shape{
    int length;
    int breadth;

    public Rectangle (int length, int breadth){
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double area() {
        return 0;
    }
}