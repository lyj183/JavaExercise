package JavaThreadExercise;

import java.util.Date;

/**
 * @author: linyijin
 * @Date: Created in 2018/1/15 14:23
 * @Description:
 **/
public class JavaThreadLockTest {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";
    public static void main(String[] args) {
        LockA la = new LockA();
        new Thread(la).start();
        LockB lb = new LockB();
        new Thread(lb).start();
    }
}
class LockA implements Runnable{
    public void run() {
        try {
            System.out.println(new Date().toString() + " LockA 开始执行");
            while(true){
                synchronized (JavaThreadLockTest.obj1) {
                    System.out.println(new Date().toString() + " LockA 锁住 obj1");
                    Thread.sleep(3000); // 此处等待是给B能锁住机会
                    synchronized (JavaThreadLockTest.obj2) {
                        System.out.println(new Date().toString() + " LockA 锁住 obj2");
                        Thread.sleep(60 * 1000); // 为测试，占用了就不放
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class LockB implements Runnable{
    public void run() {
        try {
            System.out.println(new Date().toString() + " LockB 开始执行");
            while(true){
                synchronized (JavaThreadLockTest.obj2) {
                    System.out.println(new Date().toString() + " LockB 锁住 obj2");
                    Thread.sleep(3000); // 此处等待是给A能锁住机会
                    synchronized (JavaThreadLockTest.obj1) {
                        System.out.println(new Date().toString() + " LockB 锁住 obj1");
                        Thread.sleep(60 * 1000); // 为测试，占用了就不放
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
