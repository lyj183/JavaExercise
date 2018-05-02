package JavaExercise;

/**
 * @author: linyijin
 * @Date: Created in 2017/12/12 15:54
 * @Description: Java泛型（generics）
 **/

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JavaGenericsTest {
    //    Java 实例 - 泛型方法
/*
    public static <E> void printArray(E[] inputArray) {
        for (E element :
                inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        System.out.println( "Array integerArray contains:" );
        printArray( intArray  ); // 传递一个整型数组
        System.out.println( "\nArray doubleArray contains:" );
        printArray( doubleArray ); // 传递一个双精度型数组
        System.out.println( "\nArray characterArray contains:" );
        printArray( charArray ); // 传递一个字符型型数组
    }
*/

    //    Java 实例 - 泛型方法，有界的类型参数: 限制那些被允许传递到一个类型参数的类型种类范围。
    // 要声明一个有界的类型参数，首先列出类型参数的名称，后跟extends关键字，最后紧跟它的上界。
/*
    public static <T extends Comparable<T>> T maximum(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.printf("Max of %d, %d and %d is %d\n", 3, 4, 5, maximum(3, 4, 5));
        System.out.printf("Max of %.1f, %.1f and %.1f is %.1f\n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));  // .1f 保留小数点后一位
        System.out.printf("Max of %s, %s and %s is %s\n", "Apple", "Pear", "Orange", maximum("Apple", "Pear", "Orange"));
    }
*/

    //    Java 实例 - 泛型类，看 JavaGenericsClassTest.java
    public static void main(String[] args) {
        JavaGenericsClassTest<Integer> integerJavaGenericsClassTest = new JavaGenericsClassTest<Integer>();
        JavaGenericsClassTest<String> stringJavaGenericsClassTest = new JavaGenericsClassTest<String>();

        integerJavaGenericsClassTest.add(new Integer(10));
        stringJavaGenericsClassTest.add(new String("Hello World"));

        System.out.printf("Integer Value :%d\n\n", integerJavaGenericsClassTest.get());
        System.out.printf("String Value :%s\n", stringJavaGenericsClassTest.get());
    }

}