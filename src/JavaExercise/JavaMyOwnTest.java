package JavaExercise;


import com.sun.javafx.collections.MappingChange;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author: linyijin
 * @Date: Created in 2018/1/10 14:39
 * @Description:
 **/

public class JavaMyOwnTest {
    // 一、内部函数调用
/*
    public static void main(String[] args) {
        // 调用方法一
        JavaMyOwnTest javaMyOwnTest = new JavaMyOwnTest();
        javaMyOwnTest.PrintTest();
        // 调用方法二
        new JavaMyOwnTest().PrintTest();
    }
    @Test // 如果是private，则不能@Test
    public void PrintTest() {
        System.out.println("这是内部函数调用练习");
    }
*/

    //  二、List
/*
    public static void main(String[] args) {
        List arrayList = new ArrayList();
        arrayList.add("这");
        arrayList.add("是");
        arrayList.add("一");
        arrayList.add("个");
        arrayList.add("List");
        arrayList.add("List");
        arrayList.add("练");
        arrayList.add("习");
        System.out.print("arrayList：" + arrayList);
        System.out.print("\narrayList的size：" + arrayList.size());
        arrayList.removeIf(list -> Pattern.compile("List").matcher((CharSequence) list).find());
        System.out.println("\narrayList的删除：" + arrayList);
    }
*/

    // Java 实例 - Enum（枚举）构造函数及方法的使用
/*
    enum Car {
        lamborghini(900),tata(2),audi(50),fiat(15),honda(12);
        private int price;
        Car(int p) {
            price = p;
        }
        int getPrice() {
            return price;
        }
    }
    public static void main(String args[]){
        System.out.println("所有汽车的价格：");
        for (Car car : Car.values())
            System.out.println(car + " 需要 "
                    + car.getPrice() + " 千美元。");
    }
*/

    // Java解析Json数据的两种方式JsonObject和JsonArray
    // 需要依赖json-lib.jar开发包
    // json解析需要写异常处理
/*
    public static void main(String[] args) {
        // JsonObject
        String objectString = "{\"name\":\"zhangsan\",\"password\":\"zhangsan123\",\"email\":\"10371443@qq.com\"}";
        try {
            JSONObject jsonObject = JSONObject.fromObject(objectString);
            User user = new User();
            user.setName(jsonObject.getString("name"));
            user.setPassword(jsonObject.getString("password"));
            user.setEmail(jsonObject.getString("email"));
            System.out.println(user.toString());
            // 将 Json 形式的字符串转换为 Map
            Map<String, Object> map = (Map<String, Object>) JSONObject.toBean(jsonObject, Map.class);
            System.out.println(map);
            // 将 Json 形式的字符串转换为 JavaBean
            User person = (User) JSONObject.toBean(jsonObject, User.class);
            System.out.println(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // JsonArray
        String arrayString = "[{\"name\":\"zhangsan\",\"password\":\"zhangsan123\",\"email\":\"10371443@qq.com\"},{\"name\":\"lisi\",\"password\":\"lisi123\",\"email\":\"1435123@qq.com\"}]";
        try {
            JSONArray jsonArray = JSONArray.fromObject(arrayString);
            ArrayList<User> users = new ArrayList<User>();
            for (int i = 0; i < jsonArray.size(); i++) {
                User user = new User();
                user.setName(jsonArray.getJSONObject(i).getString("name"));
                user.setPassword(jsonArray.getJSONObject(i).getString("password"));
                user.setEmail(jsonArray.getJSONObject(i).getString("email"));
                users.add(user);
            }
            for (User user :
                    users) {
                System.out.println(user.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/

    // java实现定时任务的三种方法
    // http://blog.csdn.net/haorengoodman/article/details/23281343/
    // 一、普通thread
    // 这是最常见的，创建一个thread，然后让它在while循环里一直运行着，
    // 通过sleep方法来达到定时任务的效果。这样可以快速简单的实现，代码如下：
/*
    public static void main(String[] args) {
        final long timeInterval = 1000;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Hello !!");
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
*/
    // 二、于第一种方式相比，优势 1>当启动和去取消任务时可以控制 2>第一次执行任务时可以指定你想要的delay时间
    // 在实现时，Timer类可以调度任务，TimerTask则是通过在run()方法里实现具体任务。 Timer实例可以调度多任务，它是线程安全的。
    // 当Timer的构造器被调用时，它创建了一个线程，这个线程可以用来调度任务。
/*
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello !!");
            }
        };
        Timer timer = new Timer();
        long delay = 0;
        long intevalPeriod = 1 * 1000;
        timer.scheduleAtFixedRate(task, delay, intevalPeriod);
    }
*/
    // 三、ScheduledExecutorService是从Java SE5的java.util.concurrent里，做为并发工具类被引进的，这是最理想的定时任务实现方式。
    // 相比于上两个方法，它有以下好处：
    // 1>相比于Timer的单线程，它是通过线程池的方式来执行任务的
    // 2>可以很灵活的去设定第一次执行任务delay时间
    // 3>提供了良好的约定，以便设定执行的时间间隔
    // 下面是实现代码，我们通过ScheduledExecutorService#scheduleAtFixedRate展示这个例子，通过代码里参数的控制，首次执行加了delay时间。
/*
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello !!");
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 10, 1, TimeUnit.SECONDS);
    }
*/

    // 使用索引访问用 String 的 split 方法得到的数组时，需做最后一个分隔符后有无内容的检查，否则会有抛 IndexOutOfBoundsException 的风险。
    // 《阿里巴巴Java开发手册》P.7.(13.)
/*
    public static void main(String[] args) {
        String str = "a,b,c,,";
        String[] ary = str.split(",");
        System.out.println(ary.length);
    }
*/
    // 使用集合转数组的方法，必须使用集合的toArray(T[] array)，传入的是类型完全 一样的数组，大小就是 list.size()。
    // 《阿里巴巴Java开发手册》P.7.(4.)
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(2);
        list.add("guan");
        list.add("bao");
        String[] array = new String[list.size()];
        array = list.toArray(array);
        for (String item :
                array) {
            System.out.println(item);
        }
    }

}



