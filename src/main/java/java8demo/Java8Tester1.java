package java8demo;

/**
 * @Auther: lizhanxiang@passiontec.cn
 * @Date: 2018-06-01 19:11
 * @Description:
 */
public class Java8Tester1 {
    public static void main(String[] args) {
        Java8Tester1 tester = new Java8Tester1();
        MathOperation addition = (a,b)->a-b;
        MathOperation subtraction = (a,b)->a-b;
        MathOperation multiplication =(a,b)->a*b ;
        MathOperation division = (a,b)->a/b;
        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));
        GreetingService greetingService1 =  message-> System.out.println("hello " +message) ;
        GreetingService greetingService2 = (message)-> System.out.println("hello " +message) ;
        greetingService1.sayMessage("lzx");
        greetingService2.sayMessage("lzx2");
    }
    interface MathOperation{
        int operation(int a,int b);
    }
    interface GreetingService{
        void sayMessage(String message);
    }
    private int operate(int a ,int b ,MathOperation mathOperation){
        return mathOperation.operation(a,b) ;
    }
}
