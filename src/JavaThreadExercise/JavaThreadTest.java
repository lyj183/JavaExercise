package JavaThreadExercise;

import java.io.IOException;

/**
 * @author: linyijin
 * @Date: Created in 2018/1/15 11:39
 * @Description:
 **/
public class JavaThreadTest extends Thread {
    // Java 实例 - 查看线程是否存活
/*
    public void run() {
        for (int i = 0; i < 10; i++) {
            printMsg();
        }
    }
    public void printMsg() {
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        System.out.println("name = " + name);
    }
    public static void main(String[] args) {
        JavaThreadTest javaThreadTest = new JavaThreadTest();
        javaThreadTest.setName("Thread");
        System.out.println("before start(), javaThreadTest.isAlive() = " + javaThreadTest.isAlive());
        javaThreadTest.start();
        System.out.println("just after start(), javaThreadTest.isAlive() = " + javaThreadTest.isAlive());
        for (int i = 0; i < 10; i++) {
            javaThreadTest.printMsg();
        }
        System.out.println("The end of main(), javaThreadTest.isAlive() = " + javaThreadTest.isAlive());
    }
*/

    // Java 实例 - 获取当前线程名称
    public void run() {
        for (int i = 0; i < 10; i++) {
            printMsg();
        }
    }
    public void printMsg() {
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        System.out.println("name = " + name);
    }
    public static void main(String[] args) {
        JavaThreadTest javaThreadTest = new JavaThreadTest();
        javaThreadTest.start();
        for (int i = 0; i < 10; i++) {
            javaThreadTest.printMsg();
        }
    }

    // Java 实例 - 状态监测
/*
    boolean waiting = true;
    boolean ready = false;
    JavaThreadTest() {}
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " Starting.");
        while (waiting)
            System.out.println("waiting:" + waiting);
            System.out.println("waiting..." );
            startWait();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(threadName + " interrupted.");
            }
        System.out.println(threadName + " terminating.");

    }
    synchronized void startWait() {
        try {
            while (!ready)
                wait();
        } catch (InterruptedException e) {
            System.out.println("wait() interrupted");
        }
    }
    synchronized void notice() {
        ready = true;
        notify();
    }
    public static void main(String[] args) throws InterruptedException {
        JavaThreadTest thread = new JavaThreadTest();
        thread.setName("MyThread #1");
        showThreadStatus(thread);
        thread.start();
        Thread.sleep(50);
        showThreadStatus(thread);
        thread.waiting = false;
        Thread.sleep(50);
        showThreadStatus(thread);
        thread.notice();
        Thread.sleep(50);
        showThreadStatus(thread);
        while (thread.isAlive())
            System.out.println("alive");
        showThreadStatus(thread);
    }
    static void showThreadStatus(Thread thread) {
        System.out.println(thread.getName() + "Alive:=" + thread.isAlive() + " State:=" +thread.getState());
    }
*/

    // Java 实例 - 线程优先级设置
/*
    private int countDown = 5;
    private volatile double d = 0;
    public JavaThreadTest (int priority) {
        setPriority(priority);
        start();
    }
    @Override
    public String toString() {
        return super.toString() + ": " +countDown;
    }
    public void run() {
        while (true) {
            for (int i = 0; i < 100000; i++) {
                d = d + (Math.PI + Math.E) / (double)i;
                System.out.println(this);
                if (--countDown == 0) return;
            }
        }
    }
    public static void main(String[] args) {
        new JavaThreadTest(Thread.MAX_PRIORITY);
        for (int i = 0; i < 5; i++) {
            new JavaThreadTest(Thread.MIN_PRIORITY);
        }
    }
*/

    // Java 实例 - 线程挂起
/*
    private int countDown = 5;
    private static int threadCount = 0;
    public JavaThreadTest() {
        super(" " + ++threadCount);
        start();
    }
    @Override
    public String toString() {
        return "#" + getName() + ": " + countDown;
    }
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) return;
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new JavaThreadTest().join();
            System.out.println("线程已被挂起");
        }
    }
*/

    // Java 实例 - 终止线程
    // Java中原来在Thread中提供了stop()方法来终止线程，但这个方法是不安全的，所以一般不建议使用。
    // 本文向大家介绍使用interrupt方法中断线程。
    // 使用interrupt方法来终端线程可分为两种情况：
    // （1）线程处于阻塞状态，如使用了sleep方法。
    // （2）使用while（！isInterrupted（））{……}来判断线程是否被中断。
    // 在第一种情况下使用interrupt方法，sleep方法将抛出一个InterruptedException例外，而在第二种情况下线程将直接退出。下面的代码演示了在第一种情况下使用interrupt方法。
/*
    public void run() {
        try {
            sleep(50000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) throws Exception {
        Thread thread = new JavaThreadTest();
        thread.start();
        System.out.println("在50秒之内按任意键中断线程!");
        System.in.read();
        thread.interrupt();
        thread.join();
        System.out.println("线程已经退出!");
    }
*/

    // Java 实例 - 获取所有线程
/*
    public static void main(String[] args) {
        JavaThreadTest t1 = new JavaThreadTest();
        t1.setName("thread1");
        t1.start();
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        int noThreads = currentGroup.activeCount();
        Thread[] lstThreads = new Thread[noThreads];
        currentGroup.enumerate(lstThreads);
        for (int i = 0; i < noThreads; i++)
            System.out.println("线程号：" + i + " = " + lstThreads[i].getName());
    }
*/

    // Java 实例 - 查看线程优先级
/*
    private static Runnable makeRunnable() {
        Runnable r = new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    Thread t = Thread.currentThread();
                    System.out.println("in run() - priority=" + t.getPriority()+ ", name=" + t.getName());
                    try {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException x) {
                    }
                }
            }
        };
        return r;
    }
    public static void main(String[] args) {
        System.out.println("in main() - Thread.currentThread().getPriority()=" + Thread.currentThread().getPriority());
        System.out.println("in main() - Thread.currentThread().getName()="+ Thread.currentThread().getName());
        Thread threadA = new Thread(makeRunnable(), "threadA");
        threadA.start();
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException x) {
        }
        System.out.println("in main() - threadA.getPriority()="+ threadA.getPriority());
    }
*/

    // Java 实例 - 中断线程
    // 以下实例演示了如何使用interrupt()方法来中断线程并使用 isInterrupted() 方法来判断线程是否已中断：
/*
    public void run() {
        try {
            System.out.println("in run() - 将运行 work2() 方法");
            work2();
            System.out.println("in run() - 从 work2() 方法回来");
        }
        catch (InterruptedException x) {
            System.out.println("in run() - 中断 work2() 方法");
            return;
        }
        System.out.println("in run() - 休眠后执行");
        System.out.println("in run() - 正常离开");
    }
    public void work2() throws InterruptedException {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("C isInterrupted()=" + Thread.currentThread().isInterrupted());
                Thread.sleep(2000);
                System.out.println("D isInterrupted()=" + Thread.currentThread().isInterrupted());
            }
        }
    }
    public void work() throws InterruptedException {
        while (true) {
            for (int i = 0; i < 100000; i++) {
                int j = i * 2;
            }
            System.out.println("A isInterrupted()=" + Thread.currentThread().isInterrupted());
            if (Thread.interrupted()) {
                System.out.println("B isInterrupted()=" + Thread.currentThread().isInterrupted());
                throw new InterruptedException();
            }
        }
    }
    public static void main(String[] args) {
        JavaThreadTest si = new JavaThreadTest();
        Thread t = new Thread(si);
        t.start();
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException x) {
        }
        System.out.println("in main() - 中断其他线程");
        t.interrupt();
        System.out.println("in main() - 离开");
    }
*/

}
