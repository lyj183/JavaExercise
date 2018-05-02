package JavaExercise;

/**
 * @author: linyijin
 * @Date: Created in 2017/12/12 15:55
 * @Description: Java泛型(generics)
 **/

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

//    Java 实例 - 泛型类
public class JavaGenericsClassTest<T> {
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
