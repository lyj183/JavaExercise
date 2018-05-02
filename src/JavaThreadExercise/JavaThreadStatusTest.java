package JavaThreadExercise;

/**
 * @author: linyijin
 * @Date: Created in 2018/1/15 15:50
 * @Description:
 **/

public class JavaThreadStatusTest {
    public static void main(String args[]) throws Exception{
        MyThread thread = new MyThread();
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
        while(thread.isAlive()) {
            System.out.println("alive");
        }
        showThreadStatus(thread);
    }
    static void showThreadStatus(Thread thrd) {
        System.out.println(thrd.getName()+" 存活:" +thrd.isAlive()+" 状态:" + thrd.getState() );
    }
}
class MyThread extends Thread {
    boolean waiting = true;
    boolean ready = false;
    MyThread() {}
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " 启动");
        while (waiting)
            System.out.println("等待：" + waiting);
        System.out.println("等待...");
        startWait();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(threadName + " 中断。");
        }
        System.out.println(threadName + " 结束。");

    }
    synchronized void startWait() {
        try {
            while (!ready) wait();
        } catch (InterruptedException e) {
            System.out.println("wait() 中断。");
        }
    }
    synchronized void notice() {
        ready = true;
        notify();
    }
}
