package JavaAdvanceExercise;

/**
 * @author: linyijin
 * @Date: Created in 2017/12/12 15:50
 * @Description:
 **/

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
import java.util.*;

/**
 * @author: linyijin
 * @Date: Created in 2017/12/8 11:24
 * @Description: 提高篇
 **/

public class JavaListTest {
    // 1. asList 的缺陷
    /*
    public static void main(String[] args) {
        // 一、避免使用基本数据类型数组转换为列表。
        // 8个基本类型是无法作为asList的参数的， 要想作为泛型参数就必须使用其所对应的包装类型。
        // int[] ints = {1,2,3,4,5}; // list.size() 为1
        // 对象作为asList的参数
        Integer[] ints = {1,2,3,4,5};
        List list = Arrays.asList(ints);
        System.out.println("list'size: " + list.size());
        System.out.println("list.get(0) 的类型:" + list.get(0).getClass());
        System.out.println("list.get(0) == ints[0]：" + list.get(0).equals(ints[0]));
        // 二、asList返回的列表只不过是一个披着list的外衣，它并没有list的基本特性（变长）。
        // 该list是一个长度不可变的列表，传入参数的数组有多长，其返回的列表就只能是多长。
        // list.add(6); // 报错
    }
    */

    // 2. subList的缺陷
    public static void main(String[] args) {
        // 一、subList返回的只是原列表的一个视图，它所有的操作最终都会作用在原列表上。
        /*
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        // 通过构造函数新建一个包含list1的列表 list2
        List<Integer> list2 = new ArrayList<Integer>(list1);
        // 通过subList生成一个与list1一样的列表 list3
        List<Integer> list3 = list1.subList(0, list1.size());
        // 修改list3
        list3.add(3);
        System.out.println("list1 == list2：" + list1.equals(list2));
        System.out.println("list1 == list3：" + list1.equals(list3));
        */

        // 二、subList生成子列表后，不要试图去操作原列表。

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        // 通过subList生成一个与list1一样的列表 list3
        List<Integer> list3 = list1.subList(0, list1.size());
        // 对于子列表视图，它是动态生成的，生成之后就不要操作原列表了，否则必然都导致视图的不稳定而抛出异常。
        // 最好的办法就是将原列表设置为只读状态，要操作就操作子列表：
        // 对list1设置为只读状态
        // list1 = Collections.unmodifiableList(list1);
        // 修改list1
        list1.add(3);
        System.out.println("list1'size：" + list1.size());
        System.out.println("list3'size：" + list3.size()); // 报错


        // 三、推荐使用subList处理局部列表
        // 在开发过程中我们一定会遇到这样一个问题：
        // 获取一堆数据后，需要删除某段数据。例如，有一个列表存在1000条记录，我们需要删除100-200位置处的数据，可能我们会这样处理：
        /*
        for(int i = 0 ; i < list1.size() ; i++){
            if(i >= 100 && i <= 200){
                list1.remove(i);
                // 当然这段代码存在问题，list remove之后后面的元素会填充上来，
                // 所以需要对i进行简单的处理，当然这个不是这里讨论的问题。
            }
        }
        */
        // 这个应该是我们大部分人的处理方式吧，其实还有更好的方法，利用subList。
        // 在前面LZ已经讲过，子列表的操作都会反映在原列表上。所以下面一行代码全部搞定：
        // list1.subList(100, 200).clear();

        // 四、fail-fast机制
        // 当多个线程对集合进行结构上的改变的操作时，有可能会产生fail-fast机制。
        // 记住是有可能，而不是一定。
        // 例如：假设存在两个线程（线程1、线程2），线程1通过Iterator在遍历集合A中的元素，在某个时候线程2修改了集合A的结构
        // （是结构上面的修改，而不是简单的修改集合元素的内容）
        // 那么这个时候程序就会抛出 ConcurrentModificationException 异常，从而产生fail-fast机制。
        // 解决办法：
        // 使用CopyOnWriteArrayList来替换ArrayLis
        // 参考http://cmsblogs.com/?p=1220

    }
}

