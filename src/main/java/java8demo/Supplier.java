package java8demo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/6/10.
 */
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
class Car {
    public static Car create(final  Supplier<Car> supplier){
        return supplier.get();
    }
    public static void collide(final Car car){
        System.out.println("Collide "+car.toString());
    }
    public void follow(final Car another){
        System.out.println("Following the "+another.toString());
    }
    public void repair(){
        System.out.println("Repaired "+ this.toString());
    }
}
class CarDemo{
    void testLambda(){
        // 1.构造器引用：他的语法是Class::new ，或者更一般的是Class<T>::new
        final Car car = Car.create(Car::new);
        List<Car> cars = Arrays.asList(car) ;
        //2.静态方法引用：他的语法是Class::static_method
        cars.forEach(Car::collide);
        //3.特点类的任意对象方法引用：Class::method
        cars.forEach(Car::repair);
        //4.特点对象的方法引用,他的语法是install::method
        final Car police = Car.create(Car::new) ;
        cars.forEach(police::follow);
    }

}
