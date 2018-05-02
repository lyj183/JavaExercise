package JavaSerializableExercise;

/**
 * @author: linyijin
 * @Date: Created in 2017/12/12 16:15
 * @Description: 只是一个简单的类，用于测试序列化
 **/

import java.io.Serializable;

public class Data implements Serializable{
    private static final long serialVersionUID = 3020892205345816881L;
    public int n;
    public Data (int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}
