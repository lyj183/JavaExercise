package JavaThreadExercise;

/**
 * @author: linyijin
 * @Date: Created in 2018/1/15 14:51
 * @Description:
 **/
public class JavaThreadIdTest extends Object implements Runnable{
    private ThreadId var;
    public JavaThreadIdTest(ThreadId var) {
        this.var = var;
    }
    @Override
    public void run() {
        try {
            print("var getThreadId =" + var.getThreadId());
            Thread.sleep(2000);
            print("var getThreadId =" + var.getThreadId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void print(String msg) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ": " + msg);
    }
    public static void main(String[] args) {
        ThreadId threadId = new ThreadId();
        JavaThreadIdTest shared = new JavaThreadIdTest(threadId);
        try {
            Thread threadA = new Thread(shared, "threadA");
            threadA.start();
            Thread.sleep(500);
            Thread threadB = new Thread(shared, "threadB");
            threadB.start();
            Thread.sleep(500);
            Thread threadC = new Thread(shared, "threadC");
            threadC.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreadId extends ThreadLocal {
    private int nextId;
    public ThreadId() {
        nextId = 10001;
    }
    private synchronized Integer getNewId() {
        Integer id = new Integer(nextId);
        nextId++;
        return id;
    }
    @Override
    protected Object initialValue() {
        print("in initialValue()");
        return getNewId();
    }
    public int getThreadId() {
        Integer id = (Integer) get();
        return id.intValue();
    }
    public static void print(String msg) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ": " +msg);
    }
}