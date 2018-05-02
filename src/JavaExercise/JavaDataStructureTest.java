package JavaExercise;

/**
 * @author: linyijin
 * @Date: Created in 2017/12/12 16:00
 * @Description: Java 数据结构
 **/

import java.util.*;
import java.io.*;

public class JavaDataStructureTest {
    //    Java 实例 - 枚举（Enumeration）
    // boolean hasMoreElements( ) 测试此枚举是否包含更多的元素。
    // Object nextElement( ) 如果此枚举对象至少还有一个可提供的元素，则返回此枚举的下一个元素。
/*
    public static void main(String[] args) {
        Enumeration enumeration;
        Vector vector = new Vector();
        vector.add("1");
        vector.add("2");
        vector.add("3");
        vector.add("4");
        vector.add("5");
        vector.add("6");
        vector.add("7");
        enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
*/

    //    Java 实例 - 位集合（BitSet）
    public static void main(String[] args) {
        BitSet bits1 = new BitSet(16);
        BitSet bits2 = new BitSet(16);
        // set some bits
        for (int i = 0; i < 16; i++) {
            if ((i % 2) == 0) bits1.set(i);
            if ((i % 5) != 0) bits2.set(i);
        }
        System.out.println("Initial pattern in bits1: ");
        System.out.println(bits1);
        System.out.println("\nInitial pattern in bits2: ");
        System.out.println(bits2);
        // AND bits 对此目标位 set 和参数位 set 执行逻辑与操作
        bits2.and(bits1);
        System.out.println("\nbits2 AND bits1: ");
        System.out.println(bits2);
        // OR bits 对此位 set 和位 set 参数执行逻辑或操作。
        bits2.or(bits1);
        System.out.println("\nbits2 OR bits1: ");
        System.out.println(bits2);
        // XOR bits 对此位 set 和位 set 参数执行逻辑异或操作
        bits2.xor(bits1);
        System.out.println("\nbits2 XOR bits1: ");
        System.out.println(bits2);
    }

    //    Java 实例 - 向量（Vector）
    // 向量（Vector）类和传统数组非常相似，但是Vector的大小能根据需要动态的变化。
    // 和数组一样，Vector对象的元素也能通过索引访问。
    // 使用Vector类最主要的好处就是在创建对象的时候不必给对象指定大小，它的大小会根据需要动态的变化。
    // Vector类实现了一个动态数组。和ArrayList和相似，但是两者是不同的：
    // 1、Vector是同步访问的。同一时刻只能有一个线程访问。
    // 2、Vector包含了许多传统的方法，这些方法不属于集合框架。
    /*
    public static void main(String[] args) {
        // initial size is 3, increment is 2
        Vector vector = new Vector(3, 2);
        System.out.println("1、Initial size: " + vector.size());
        System.out.println("2、Initial capacity: " + vector.capacity());
        vector.addElement(new Integer(1));
        vector.addElement(new Integer(2));
        vector.addElement(new Integer(3));
        vector.addElement(new Integer(4));
        System.out.println("3、Capacity after four additions: " + vector.capacity());

        vector.addElement(new Double(5.45));
        System.out.println("4、Current capacity: " + vector.capacity());
        vector.addElement(new Double(6.08));
        vector.addElement(new Integer(7));
        System.out.println("5、Current capacity: " + vector.capacity());
        vector.addElement(new Float(9.4));
        vector.addElement(new Integer(10));
        System.out.println("6、Current capacity: " + vector.capacity());
        vector.addElement(new Integer(11));
        vector.addElement(new Integer(12));
        System.out.println("First element: " + (Integer) vector.firstElement());
        System.out.println("Last element: " + (Integer) vector.lastElement());
        if (vector.contains(new Integer(3))) {
            System.out.println("Vector contains 3.");
        }
        // enumerate the elements in the vector.
        Enumeration vEnum = vector.elements();
        System.out.println("\nElements in vector:");
        while (vEnum.hasMoreElements()) {
            System.out.print(vEnum.nextElement() + " ");
        }
        System.out.println();
    }
    */

    //    Java 实例 - 栈（Stack）栈是Vector的一个子类，它实现了一个标准的后进先出的栈。
    /*
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("stack: " + stack);
        showpush(stack, 42);
        showpush(stack, 66);
        showpush(stack, 99);
        showpop(stack);
        showpop(stack);
        showpop(stack);
        try {
            showpop(stack);
        } catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
    }
    static void showpush(Stack st, int a) {
        st.push(new Integer(a));
        System.out.println("push(" + a + ")");        // 压入
        System.out.println("stack: " + st);
    }
    static void showpop(Stack st) {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();               // 取出
        System.out.println(a);
        System.out.println("stack: " + st);
    }
    */

    //    Java 实例 - 字典（Dictionary）
    // Dictionary类已经过时了。在实际开发中，你可以实现Map接口来获取键/值的存储功能。
    /*
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("Zara", "8");
        map.put("Mahnaz", "31");
        map.put("Ayan", "12");
        map.put("Daisy", "14");
        System.out.println();
        System.out.println(" Map Elements");
        System.out.print("\t" + map);
    }
    */

    //    Java 实例 - 哈希表（Hashtable）它和HashMap类很相似，但是它支持同步。线程安全的。
/*
    public static void main(String[] args) {
        // Create a hash map
        Hashtable hashtable = new Hashtable();
        Enumeration names;
        String nameString;
        double bal;
        hashtable.put("Zara", new Double(3434.34));
        hashtable.put("Mahnaz", new Double(123.22));
        hashtable.put("Ayan", new Double(1378.00));
        hashtable.put("Daisy", new Double(99.22));
        hashtable.put("Qadir", new Double(-19.08));
        // Show all values in hash table.
        names = hashtable.keys();                                              // 往枚举中存值 .keys()
        while (names.hasMoreElements()) {
            nameString = (String) names.nextElement();                         // 从枚举中取值
            System.out.println(nameString + ": " + hashtable.get(nameString)); // 从哈希表中取值
        }
        System.out.println();
        // Deposit 1,000 into Zara's account
        bal = ((Double) hashtable.get("Zara")).doubleValue();
        hashtable.put("Zara", new Double(bal + 1000));
        System.out.println("Zara's new balance: " + hashtable.get("Zara"));
    }
*/

    //    Java 实例 - 属性（Properties）继承于 Hashtable.Properties 类表示了一个持久的属性集，属性列表中每个键及其对应值都是一个字符串。
/*
    public static void main(String[] args) {
        Properties capitals = new Properties();
        Set states;
        String string;
        capitals.put("Illinois", "Springfield");
        capitals.put("Missouri", "Jefferson City");
        capitals.put("Washington", "Olympia");
        capitals.put("California", "Sacramento");
        capitals.put("Indiana", "Indianapolis");
        // Show all states and capitals in hashtable.
        states = capitals.keySet();                                              // 往 Set 中存值 .keySet()
        Iterator iterator = states.iterator();                                   // 用 Set 给 Iterator 赋值
        while (iterator.hasNext()) {
            string = (String) iterator.next();
            System.out.println("The capital of " +
                    string + " is " + capitals.getProperty(string) + ".");       // 从 Properties 中取值
        }
        System.out.println();
        // look for state not in list -- specify default
        string = capitals.getProperty("Florida", "Not Found");
        System.out.println("The capital of Florida is " + string + ".");
    }
*/

}
