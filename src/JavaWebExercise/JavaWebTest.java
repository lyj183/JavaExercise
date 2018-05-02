package JavaWebExercise;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @author: linyijin
 * @Date: Created in 2018/1/15 10:18
 * @Description:
 **/
public class JavaWebTest {

    // Java 实例 – 获取指定主机的IP地址
/*
    public static void main(String[] args) {
        InetAddress address = null;
        try {
            address = InetAddress.getByName("www.runoob.com");
        }
        catch (UnknownHostException e) {
            System.exit(2);
        }
        System.out.println(address.getHostName() + "=" + address.getHostAddress());
        System.exit(0);
    }
*/

    // Java 实例 - 查看端口是否已使用
/*
    public static void main(String[] args) {
        Socket socket;
        String host = "localhost";
        if (args.length > 0) {
            host = args[0];
        }
        for (int i = 0; i < 1024; i++) {
            try {
                System.out.println("查看" + i);
                socket = new Socket(host, i);
                System.out.println("端口" + i + " 已被使用");

            } catch (UnknownHostException e) {
                System.out.println("Exception occured"+ e);
                break;
            } catch (IOException e) {
            }
        }
    }
*/

    // Java 实例 - 获取本机ip地址及主机名
/*
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("Local HostAddress: " + address.getHostAddress());
        String hostname = address.getHostName();
        System.out.println("Local host name: "+hostname);
    }
*/

    // Java 实例 - 获取远程文件大小
/*
    public static void main(String[] args) throws IOException {
        int size;
        URL url = new URL("http://www.runoob.com/wp-content/themes/runoob/assets/img/newlogo.png");
        URLConnection connection = url.openConnection();
        size = connection.getContentLength();
        if (size < 0)
            System.out.println("无法获取文件大小。");
        else
            System.out.println("文件大小为：" + size + " bytes");
        connection.getInputStream().close();
    }
*/

    // Java 实例 - 查看主机指定文件的最后修改时间
/*
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://127.0.0.1/java.bmp");
        URLConnection urlConnection = url.openConnection();
        urlConnection.setUseCaches(false);
        long timestamp = urlConnection.getLastModified();
        System.out.println("java.bmp 文件最后修改时间 :" + timestamp);
    }
*/

    // Java 实例 - 使用 Socket 连接到指定主机
/*
    public static void main(String[] args) {
        try {
            InetAddress addr;
            Socket sock = new Socket("www.runoob.com", 80);
            addr = sock.getInetAddress();
            System.out.println("连接到 " + addr);
            sock.close();
        } catch (java.io.IOException e) {
            System.out.println("无法连接 " + args[0]);
            System.out.println(e);
        }
    }
*/

    // Java 实例 - 网页抓取（网页的源代码，存储在当前目录下的 data.html 文件中）
/*
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.runoob.com");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("data.html"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            writer.write(line);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }
*/

    // Java 实例 - 获取 URL响应头的日期信息
/*
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.runoob.com");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        long data = httpURLConnection.getDate();
        if (data == 0)
            System.out.println("无法获取信息。");
        else
            System.out.println("Date: " + new Date(data));
    }
*/

    // Java 实例 - 获取 URL 响应头信息
/*
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.runoob.com");
        URLConnection connection = url.openConnection();
        Map headers = connection.getHeaderFields();
        Set<String> keys = headers.keySet();
        for (String key :
                keys) {
            String val = connection.getHeaderField(key);
            System.out.println(key + "      " + val );
        }
        System.out.println(connection.getLastModified());
    }
*/

    // Java 实例 - 解析 URL
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.runoob.com/html/html-tutorial.html");
        System.out.println("URL 是 " + url.toString());
        System.out.println("协议是 " + url.getProtocol());
        System.out.println("文件名是 " + url.getFile());
        System.out.println("主机是 " + url.getHost());
        System.out.println("路径是 " + url.getPath());
        System.out.println("端口号是 " + url.getPort());
        System.out.println("默认端口号是 " + url.getDefaultPort());
    }

}
