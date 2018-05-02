package JavaExercise;

/**
 * @author: linyijin
 * @Date: Created in 2017/12/12 15:57
 * @Description: Java 时间处理
 **/

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class JavaDateTest {
    //    Java 实例 - 格式化时间 SimpleDateFormat
/*
    public static void main(String[] args) {
        Date date = new Date(); // 获取当前时间
        String string = "yyyy-MM-dd HH:mm:ss a"; // a为am/pm的标记
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string); // 格式化时间
        System.out.println(simpleDateFormat.format(date)); // 输出已经格式化的现在时间（24小时制）
    }
*/


    //    Java 实例 - 时间戳转换成时间 currentTimeMillis
/*
    public static void main(String[] args) {
        Long timeStamp = System.currentTimeMillis(); // 获取当前的时间戳
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String string = simpleDateFormat.format(new Date(Long.parseLong(String.valueOf(timeStamp)))); // 时间戳转换成时间
        System.out.println(string);
    }
*/

    //    Java 实例 - 获取年份月份 Calendar
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH) + 1; // 一月对应0，十二月对应11
        int year = calendar.get(Calendar.YEAR);
        int dow = calendar.get(Calendar.DAY_OF_WEEK);
        int dom = calendar.get(Calendar.DAY_OF_MONTH);
        int doy = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println("当期时间: " + calendar.getTime());
        System.out.println("日期: " + day);
        System.out.println("月份: " + month);
        System.out.println("年份: " + year);
        System.out.println("一周的第几天: " + dow);  // 星期日为一周的第一天输出为 1，星期一输出为 2，以此类推
        System.out.println("一月中的第几天: " + dom);
        System.out.println("一年的第几天: " + doy);
    }

}