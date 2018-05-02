package JavaExercise;

/**
 * @author: linyijin
 * @Date: Created in 2017/12/12 15:53
 * @Description: Java 字符串
 **/

import java.util.*;
import java.io.*;

public class JavaStringTest {
    //    Java 实例 - 字符串比较
/*
    public static void main(String[] args) {
        String string1 = "Hello World";
        String string2 = "hello World";
        Object object = string1;

        System.out.println(string1.compareTo(string2));
        System.out.println(string1.compareToIgnoreCase(string2));
        System.out.println(string1.compareTo(object.toString()));
    }
*/


    //    Java 实例 - 查找字符串最后一次出现的位置 / 查找
/*
    public static void main(String[] args) {
        String string = "Hello World, Hello Gemini";
        int lastIndex = string.lastIndexOf("Hello");
        int intIndex = string.indexOf("Hello");
        if (intIndex == -1) {
            System.out.println("Hello not found");
        } else {
            System.out.println("Last occurrence of Hello is at index " + lastIndex);
            System.out.println("Found Hello at index " + intIndex);
        }
    }
*/

    //    Java 实例 - 删除字符串中的一个字符
/*
    public static void main(String[] args) {
        String string = "This is Java";
        System.out.println(removeCharAt(string, 3));
    }
    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }
*/

    //    Java 实例 - 字符串替换
/*
    public static void main(String[] args) {
        String string = "Hello World";
        System.out.println(string.replace("H", "W"));
        System.out.println(string.replaceFirst("He", "Wa"));
        System.out.println(string.replaceAll("He", "Ha"));
        System.out.println(string);
    }
*/

    //    Java 实例 - 字符串反转
/*
    public static void main(String[] args) {
        String string = "abcdef";
        String reverse = new StringBuffer(string).reverse().toString();
        System.out.println("String before reverse：" + string);
        System.out.println("String after reverse：" + reverse);
    }
*/

    //    Java 实例 - 字符串分割
/*
    public static void main(String[] args) {
        String string = "www-wanda-com";
        String[] temp;
        String delimeter = "-";
        temp = string.split(delimeter);
        System.out.println("temp.length: " + temp.length);
        System.out.println("temp[0]: " + temp[0] + "\ntemp[1]: " + temp[1] + "\ntemp[2]: " + temp[2]);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i]);
            System.out.print(" ");
        }
        System.out.println("\n------java for each循环输出的方法-----");
        String string1 = "www.w3cschool.cn";
        String[] temp1;
        String delimeter1 = "\\.";
        temp1 = string1.split(delimeter1);
        for (String s :
                temp1) {
            System.out.print(s);
            System.out.print(" ");
        }
    }
*/

    //    Java 实例 - 字符串小写转大写
/*
    public static void main(String[] args) {
        String str = "string abc touppercase ";
        String strUpper = str.toUpperCase();
        System.out.println("Original String: " + str);
        System.out.println("String changed to upper case: "
                + strUpper);
    }
*/

    //    Java 实例 - 测试两个字符串区域是否相等
/*
    public static void main(String[] args) {
        String string1 = "Welcome to Microsoft";
        String string2 = "I work with microsoft";
        boolean match1 = string1.regionMatches(11, string2, 12, 9);
        boolean match2 = string1.regionMatches(true, 11, string2, 12, 9);
        System.out.println("区分大小写返回值：" + match1);
        System.out.println("不区分大小写返回值：" + match2);
    }
*/

    //    Java 实例 - 字符串性能比较测试
/*
    public static void main(String[] args) {
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            String string1 = "hello";
            String string2 = "hello";
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("通过String关键词创建字符串" + " : " + (endTime1 - startTime1) + "毫秒");

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            String string3 = new String("hello");
            String string4 = new String("hello");
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("通过String对象创建字符串" + " : " + (endTime2 - startTime2) + "毫秒");
    }
*/

    //    Java 实例 - 字符串优化
/*
    public static void main(String[] args) {
        String variables[] = new String[5000];
        for (int i = 0; i < 5000; i++) {
            variables[i] = "s" + i;
        }
        long startTime0 = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            variables[i] = "hello";
        }
        long endTime0 = System.currentTimeMillis();
        System.out.println("Creation time" + " of String literals : " + (endTime0 - startTime0) + " ms");
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            variables[i] = new String("hello");
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("Creation time of" + " String objects with 'new' key word : " + (endTime1 - startTime1) + " ms");
        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            variables[i] = new String("hello");
            variables[i] = variables[i].intern(); // 根据不同的jdk版本体现不一样，实测1_8_152并没有减少时间
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("Creation time of" + " String objects with intern(): " + (endTime2 - startTime2) + " ms");
    }
*/

    //    Java 实例 - 字符串格式化
    // 转  换  符 / 说    明 / 示    例
    // %s / 字符串类型 / "mingrisoft"
    // %c / 字符类型 / 'm'
    // %b / 布尔类型 / true
    // %d / 整数类型（十进制） / 99
    // %x / 整数类型（十六进制） / FF
    // %o / 整数类型（八进制） / 77
    // %f / 浮点类型 / 99.99
    // %a / 十六进制浮点类型 / FF.35AE
    // %e / 指数类型 / 9.38e+5
    // %g / 通用浮点类型（f和e类型中较短的）
    // %h / 散列码
    // %% / 百分比类型 / ％
    // %n / 换行符
    // %tx / 日期与时间类型（x代表不同的日期与时间转换符）
    public static void main(String[] args) {
        double e = Math.E;
        System.out.format("%f %n", e);
        System.out.format(Locale.GERMANY, "%-10.4f %n %n", e);   //指定本地为德国（GERMANY）
    }
}
