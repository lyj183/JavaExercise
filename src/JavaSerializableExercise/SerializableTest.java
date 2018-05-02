package JavaSerializableExercise;

/**
 * @author: linyijin
 * @Date: Created in 2017/12/12 16:17
 * @Description: JAVA 对象序列化 Serializable
 **/

import java.io.*;

public class SerializableTest {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Worm w = new Worm(6, 'a');
        System.out.println("序列化操纵之前");
        System.out.println("w=" + w);

        //序列化操作1--FileOutputStream
        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(new FileOutputStream("worm.out"));
        objectOutputStream1.writeObject("Worm storage By FileOutputStream ");
        objectOutputStream1.writeObject(w);
        objectOutputStream1.close();

        //反序列化操作1---FileInputStream
        ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream("worm.out"));
        String s1 = (String) objectInputStream1.readObject();
        Worm w1 = (Worm) objectInputStream1.readObject();
        objectInputStream1.close();
        System.out.println("反序列化操作1之后");
        System.out.println(s1);
        System.out.println("w1:" + w1);

        //序列化操作2--ByteArrayOutputStream
        ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
        ObjectOutputStream oos2 = new ObjectOutputStream(byteOutStream);
        oos2.writeObject("Worm storage By ByteOutputStream ");
        oos2.writeObject(w);
        oos2.flush();

        //反序列操作2--ByteArrayInputStream
        ByteArrayInputStream byteInStream = new ByteArrayInputStream(byteOutStream.toByteArray());
        ObjectInputStream ois2 = new ObjectInputStream(byteInStream);
        String s2 = (String) ois2.readObject();
        Worm w2 = (Worm) ois2.readObject();
        ois2.close();
        System.out.println("反序列化操作2之后");
        System.out.println(s2);
        System.out.println("w2:" + w2);
    }
}
