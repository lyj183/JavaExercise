package JavaExercise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author: linyijin
 * @Date: Created in 2018/1/10 14:32
 * @Description: Java lambda表达式
 **/

public class JavaLambdaTest {
    //    java8 手把手教你学会写lambda表达式
    // http://blog.csdn.net/bitcarmanlee/article/details/70195403

    // 知识点
    // 初识IntelliJ IDEA下JUnit单元测试 (需要引入JUnit lib)
    @Test
    public void runable() {
        new Thread(() -> System.out.println("It's a lambda function!")).start();
    }


    // 1.替代匿名内部类
/*
    public static void main(String[] args) {
        // 使用匿名内部类：
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("The old runable now is using!");
            }
        }).start();
        // 使用lambda表达式：
        new Thread(() -> System.out.println("It's a lambda function!")).start();
    }
*/

    // 2.使用lambda表达式对集合进行迭代
/*
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("java","scala","python");
        System.out.println("===before java8===");
        // before java8
        for(String each:languages) {
            System.out.println(each);
        }
        System.out.println("===after java8===");
        // after java8
        languages.forEach(x -> System.out.println(x));
        System.out.println("===这一行看起来有点像c++里面作用域解析的写法，在这里也是可以的===");
        languages.forEach(System.out::println);
    }
*/

    // 3.用lambda表达式实现map
    public static void main(String[] args) {
        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);
        cost.stream().map(x -> x + x*0.05).forEach(x -> System.out.println(x));
    }

    // 4.用lambda表达式实现map与reduce
/*
    public static void main(String[] args) {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        double allCost = cost.stream().map(x -> x + x*0.05).reduce((sum,x) -> sum + x).get();
        System.out.println(allCost);
    }
*/

    // 5.filter操作
/*
    public static void main(String[] args) {
        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0, 40.0);
        List<Double> filteredCost = cost.stream().filter(x -> x > 25.0).collect(Collectors.toList());
        filteredCost.forEach(x -> System.out.println(x));
    }
*/

    // 6.与函数式接口Predicate配合
/*
    public static void filter(List<String> names, Predicate<String> condition) {
        names.stream().filter(condition).forEach(name -> System.out.println(name + " "));
    }
    public static void main(String[] args) {
        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, str ->str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str)->str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str)->true);

        System.out.println("Print no language : ");
        filter(languages, (str)->false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str)->str.length() > 4);
    }
*/

}
