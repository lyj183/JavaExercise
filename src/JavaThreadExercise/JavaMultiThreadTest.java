package JavaThreadExercise;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: linyijin
 * @Date: Created in 2018/1/16 10:09
 * @Description:
 * Java 提供了三种创建线程的方法：
 * 1、通过实现 Runnable 接口；
 * 2、通过继承 Thread 类本身；
 * 3、通过 Callable 和 Future 创建线程。
 **/

// 1、通过实现 Runnable 接口来创建线程
/*
class RunnableDemo implements Runnable {
    private Thread thread;
    private String threadName;

    public RunnableDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating" + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running" + threadName);
        try {
            for (int i = 4; i > 0 ; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " +  threadName );
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}
public class JavaMultiThreadTest {
    public static void main(String[] args) {
        RunnableDemo runnableDemo1 = new RunnableDemo("Thread-One");
        runnableDemo1.start();
        RunnableDemo runnableDemo2 = new RunnableDemo("Thread-Two");
        runnableDemo2.start();
    }
}
*/

// 2、通过继承Thread来创建线程
/*
class ThreadDemo extends Thread {
    private Thread thread;
    private String threadName;

    public ThreadDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating" + threadName);
    }

    public void run() {
        System.out.println("Running" + threadName);
        try {
            for (int i = 4; i > 0 ; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " +  threadName );
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}
public class JavaMultiThreadTest {
    public static void main(String[] args) {
        ThreadDemo runnableDemo1 = new ThreadDemo("Thread-One");
        runnableDemo1.start();
        ThreadDemo runnableDemo2 = new ThreadDemo("Thread-Two");
        runnableDemo2.start();
    }
}
*/

// 3、通过 Callable 和 Future 创建线程
public class JavaMultiThreadTest implements Callable<Integer> {
    public static void main(String[] args) {
        JavaMultiThreadTest javaMultiThreadTest = new JavaMultiThreadTest();
        FutureTask<Integer> futureTask = new FutureTask<>(javaMultiThreadTest);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
            if (i==20) {
                new Thread(futureTask, "有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值：" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }
}