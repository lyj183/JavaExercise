package JavaExercise;

/**
 * @author: linyijin
 * @Date: Created in 2017/12/12 16:03
 * @Description: Java 数组
 **/

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class JavaArrayTest {
    //    Java 实例 - 数组排序\元素查找\添加元素\获取数组长度\数组反转

    public static void main(String[] args) {
        int array[] = {2, 5, -2, 6, -3, 8, 0, -7, -9, 4};
        printArray("数组为：", array);
        Arrays.sort(array);                                              // Arrays.sort() 排序
        printArray("1.数组排序结果为", array);
        int index1 = Arrays.binarySearch(array, 2);
        System.out.println("2.元素2在第" + index1 + "个位置");
        int index2 = Arrays.binarySearch(array, 1);                      // Arrays.binarySearch() 查询
        System.out.println("3.元素1所在位置（负数为不存在）：" + index2);
        int newIndex = -index2 - 1;
        array = insertElement(array, 1, newIndex);
        printArray("4.数组添加元素1", array);
        System.out.println("***************************");
        String[][] data = new String[2][5];
        System.out.println("第一维数组长度: " + data.length);              // Arrays.length 数组长度
        System.out.println("第二维数组长度: " + data[0].length);
        System.out.println("***************************");
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        System.out.println("反转前排序: " + arrayList);
        Collections.reverse(arrayList);                                  // Collections.reverse(arrayList) 数组反转
        System.out.println("反转后排序: " + arrayList);
    }

    private static void printArray(String message, int[] array) {
        System.out.print(message + ": [length: " + array.length + "] ");
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println();
    }

    private static int[] insertElement(int[] original, int element, int index) {
        int length = original.length;
        int[] destination = new int[length + 1];
        System.arraycopy(original, 0, destination, 0, index);  // 复制index之前的数组
        destination[index] = element;  // index位置的数组
        System.arraycopy(original, index, destination, index + 1, length - index);  // 复制index之后的数组
        return destination;
    }
    // 说明：
    // System提供了一个静态方法arraycopy(),我们可以使用它来实现数组之间的复制。其函数原型是：
    // public static void arraycopy(Object src,
    //                              int srcPos,
    //                              Object dest,
    //                              int destPos,
    //                              int length)
    // src:源数组；	srcPos:源数组要复制的起始位置；
    // dest:目的数组；	destPos:目的数组放置的起始位置；	length:复制的长度。


    //    Java 实例 - 数组获取最大最小值
/*
    public static void main(String[] args) {
        Integer[] numbers = {8, 2, 7, 1, 4, 9, 5};                    //int 是基本数据类型 Integer是其包装类，注意是一个类。
        int min = (int) Collections.min(Arrays.asList(numbers));      // Collections.min(arrayList) 数组获取最小值
        int max = (int) Collections.max(Arrays.asList(numbers));      // Collections.max(arrayList) 数组获取最大值
        System.out.println("最小值：" + min);
        System.out.println("最大值：" + max);
    }
*/


    //    Java 实例 - 数组合并
/*
    public static void main(String[] args) {
        String[] a = {"A", "E", "I"};
        String[] b = {"O", "U"};
        List list = new ArrayList(Arrays.asList(a));
        list.addAll(Arrays.asList(b));                                // listA.addAll(listB) 数组合并
        Object[] c = list.toArray();
        System.out.println(Arrays.toString(c));
    }
*/

    //    Java 实例 - 数组填充
/*
    public static void main(String[] args) {
        int[] array = new int[6];
        Arrays.fill(array, 100);                                      // Arrays.fill() 数组填充元素
        for (int element :
                array) {
            System.out.println(element);
        }
        System.out.println();
        Arrays.fill(array, 3, 5, 50);          // Arrays.fill() 数组替换元素
        for (int i = 0, n = array.length; i < n; i++) {
            System.out.println(array[i]);
        }
    }
*/

    //    Java 实例 - 数组扩容\删除数组元素
/*
    public static void main(String[] args) {
        String[] names = new String[]{"A", "B", "C"};
        String[] extended = new String[5];
        extended[3] = "D";
        extended[4] = "E";
        System.arraycopy(names, 0, extended, 0, names.length);
        for (String str :
                extended) {
            System.out.println(str);
        }
        System.out.println("***************************");
        List arrayList = new ArrayList(Arrays.asList(extended));
        System.out.println("删除元素前：" + arrayList);
        arrayList.remove(1);                                            // arrayList.remove() 删除指定index元素
        System.out.println("按index删除元素后：" + arrayList);
        arrayList.clear();                                                    // arrayList.clear() 删除所有元素
        System.out.println("删除全部元素：" + arrayList);
        arrayList.add(0, "第0个元素");
        arrayList.add(1, "第1个元素");
        arrayList.add(2, "第2个元素");
        System.out.println("添加新元素后：" + arrayList);
        arrayList.remove("第0个元素");                                      // arrayList.remove() 删除指定元素
        System.out.println("按value删除元素后：" + arrayList);
    }
*/

    //    Java 实例 - 数组是否有指定元素\是否相等\差集\交集
/*
    public static void main(String[] args) {
        List arrayList1 = new ArrayList();
        List arrayList2 = new ArrayList();
        arrayList2.add(0, "common1");
        arrayList2.add(1, "common2");
        arrayList2.add(2, "notcommon1");
        arrayList2.add(3, "notcommon2");
        arrayList1.add(0, "common1");
        arrayList1.add(1, "common2");
        arrayList1.add(2, "notcommon3");
        System.out.println("arrayList1的元素：" + arrayList1);
        System.out.println("arrayList2的元素：" + arrayList2);
        System.out.println("arrayList1是否包含字符串common1？：" + arrayList1.contains("common1"));        // arrayList.contains() 查找
        System.out.println("arrayList2是否包含数组arrayList1？：" + arrayList2.containsAll(arrayList1));
        System.out.println("arrayList1是否与arrayList2相等？：" + arrayList1.equals(arrayList2));         // arrayList1.equals(arrayList2) 相等比较
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        System.out.println("array1的元素：" + Arrays.toString(array1));
        System.out.println("array2的元素：" + Arrays.toString(array2));
        System.out.println("array1是否与array2相等？：" + Arrays.equals(array1, array2));                 // Arrays的相等比较

        // arrayList1.removeAll(arrayList2);                                                            // 差集
        // System.out.println("arrayList1与arrayList2的差集为：" + arrayList1);
        // arrayList1.retainAll(arrayList2);                                                            // 交集
        // System.out.println("arrayList1与arrayList2的交集为：" + arrayList1);
    }
*/

    //    Java 实例 - 数组并集
/*
    public static void main(String[] args) {
        String[] array1 = {"1", "2", "3", "4"};
        String[] array2 = {"4", "5", "6"};
        String[] result_union = union(array1, array2);
        System.out.println("并集的结果：" + Arrays.asList(result_union));
    }

    public static String[] union(String[] arr1, String[] arr2) {
        Set<String> set = new HashSet<String>(); // 求两个字符串数组的并集，利用set的元素唯一性
        set.addAll(Arrays.asList(arr1));
        set.addAll(Arrays.asList(arr2));
        String[] result = {}; // String[] result = new String[0];
        return set.toArray(result);
    }
*/
}
