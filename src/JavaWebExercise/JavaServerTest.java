package JavaWebExercise;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: linyijin
 * @Date: Created in 2018/1/15 11:31
 * @Description:
 **/
public class JavaServerTest {
    // Java 实例 - ServerSocket 和 Socket 通信实例
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("启动服务器。。。。");
            Socket s = ss.accept();
            System.out.println("客户端：" + s.getInetAddress().getLocalHost() + "已连接到服务器");
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String mess = br.readLine();
            System.out.println("客户端：" + mess);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw.write(mess + "\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
