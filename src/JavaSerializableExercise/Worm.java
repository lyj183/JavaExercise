package JavaSerializableExercise;

/**
 * @author: linyijin
 * @Date: Created in 2017/12/12 16:16
 * @Description: 用于测试序列化，每个Worm对象都与worm中的下一段链接，同时又有属于不同类（Data）的对象引用数组链接。
 **/

import java.io.Serializable;
import java.util.Random;

public class Worm implements Serializable{
    private static final long serialVersionUID = -553072805519953336L;
    private static Random random = new Random(47);
    private Data[] d = {
            new Data(random.nextInt(10)),
            new Data(random.nextInt(10)),
            new Data(random.nextInt(10)),
    };
    private Worm next;
    private char c;

    public Worm(int i, char x) {
        System.out.println("Worm constructor:" +i);
        c = x;
        if (--i > 0) {
            next = new Worm(i, (char)(x+1));
        }
    }

    public Worm() {
        System.out.println("Default constructor!");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(":");
        stringBuilder.append(c);
        stringBuilder.append("(");
        for (Data data:
                d) {
            stringBuilder.append(data);
        }
        stringBuilder.append(")");
        if (next!=null) {
            stringBuilder.append(next);
        }
        return stringBuilder.toString();
    }
}
