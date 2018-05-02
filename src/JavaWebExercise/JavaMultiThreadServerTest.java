package JavaWebExercise;

import java.io.IOException;
import java.io.PrintStream;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: linyijin
 * @Date: Created in 2018/1/15 10:46
 * @Description:
 **/

// Java 实例 - Socket 实现多线程服务器程序
public class JavaMultiThreadServerTest implements Runnable{
    Socket csocket;

    public JavaMultiThreadServerTest(Socket csocket) {
        this.csocket = csocket;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket ssocket = new ServerSocket(1234);
        System.out.println("Listening");
        while (true) {
            Socket socket = ssocket.accept();
            System.out.println("Connected");
            new Thread(new JavaMultiThreadServerTest(socket)).start();
        }
    }

    @Override
    public void run() {
        try {
            PrintStream printStream = new PrintStream(csocket.getOutputStream());
            for (int i = 100; i >= 0 ; i--) {
                printStream.println(i + " bottles of beer on the wall");
            }
            printStream.close();
            csocket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
