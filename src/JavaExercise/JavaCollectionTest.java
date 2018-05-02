package JavaExercise;

/**
 * @author: linyijin
 * @Date: Created in 2017/12/12 16:04
 * @Description: Java 集合
 **/

import java.util.*;
import java.io.*;

public class JavaCollectionTest {
    //    Java 集合 - 数组转集合 Arrays.asList()
    public static void main(String[] args) {
        int n = 5;
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            name[i] = String.valueOf(i);
        }
        List<String> list = Arrays.asList(name);
        // Java 8之前
        // for (String li : list) {
        //     String string = li;
        //     System.out.print(string + " ");
        // }
        // Java 8之后，使用lambda表达式 - By linYijin
        list.forEach(m -> System.out.print(m + " "));
    }

    //    Java 集合 - 集合转数组 list.toArray()
/*
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("This ");
        list.add("is ");
        list.add("a ");
        list.add("IT ");
        list.add("tutorials ");
        list.add("website. ");
        String[] strings = list.toArray(new String[0]);
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            System.out.print(string);
        }
    }
*/

    //    Java 集合 - 集合比较
/*
    public static void main(String[] args) {
        String[] coins = {"Penny", "nickel", "dime", "Quarter", "dollar"};
        Set set = new TreeSet();
        for (int i = 0; i < coins.length; i++) {
            set.add(coins[i]);
        }
        System.out.println(Collections.min(set));
        System.out.println(Collections.min(set, String.CASE_INSENSITIVE_ORDER));
        for (int i = 0; i < 10; i++) {
            System.out.print("-");
        }
        System.out.println("");
        System.out.println(Collections.max(set));
        System.out.println(Collections.max(set, String.CASE_INSENSITIVE_ORDER));
    }
*/

    //    Java 集合 - HashMap遍历 Iterator 迭代器
/*
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("1", "1st");
        hashMap.put("2", "2nd");
        hashMap.put("3", "3rd");
        Collection collection = hashMap.values();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
*/

    //    Java 集合 - 集合输出
/*
    public static void main(String[] args) {
        System.out.println("TreeMap Example!\n");
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
        treeMap.put(1, "Sunday");
        treeMap.put(2, "Monday");
        treeMap.put(3, "Tuesday");
        treeMap.put(4, "Wednesday");
        treeMap.put(5, "Thursday");
        treeMap.put(6, "Friday");
        treeMap.put(7, "Saturday");
        System.out.println("Keys of tree map: " + treeMap.keySet());
        System.out.println("Values of tree map: " + treeMap.values());
        System.out.println("Key: 5 value: " + treeMap.get(5) + "\n");
        System.out.println("First key: " + treeMap.firstKey() + " Value: " + treeMap.get(treeMap.firstKey()) + "\n");
        System.out.println("Last key: " + treeMap.lastKey() + " Value: " + treeMap.get(treeMap.lastKey()) + "\n");
        System.out.println("Removing first data: " + treeMap.remove(treeMap.firstKey()));
        System.out.println("Now the tree map Keys: " + treeMap.keySet());
        System.out.println("Now the tree map contain: " + treeMap.values() + "\n");
        System.out.println("Removing last data: " + treeMap.remove(treeMap.lastKey()));
        System.out.println("Now the tree map Keys: " + treeMap.keySet());
        System.out.println("Now the tree map contain: " + treeMap.values());
    }
*/

    //    Java 集合 - 集合长度
/*
    public static void main(String[] args) {
        System.out.println("集合实例！\n");
        int size;
        Set hashSet = new HashSet();
        String string1 = "Yellow", string2 = "White", string3 = "Green", string4 = "Blue";
        Iterator iterator;
        hashSet.add(string1);
        hashSet.add(string2);
        hashSet.add(string3);
        hashSet.add(string4);
        System.out.print("集合数据：");
        iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        size = hashSet.size();
        if (hashSet.isEmpty()) {
            System.out.println("集合是空的");
        } else {
            System.out.println("集合长度：" + size);
        }
        System.out.println();
    }
*/

    //    Java 集合 - 集合打乱顺序 Collections.shuffle()
/*
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(new Integer(i));
        }
        System.out.println("打乱前：");
        System.out.println(list);

        for (int i = 0; i < 6; i++) {
            System.out.println("第" + i + "次打乱：");
            Collections.shuffle(list);
            System.out.println(list);
        }
    }
*/

    //    Java 集合 - 集合遍历
/*
    public static void main(String[] args) {
        listTest();
        setTest();
    }
    private static void listTest() {
        List<String> list = new ArrayList<String>();
        list.add("菜");
        list.add("鸟");
        list.add("教");
        list.add("程");
        list.add("程"); // 重复数据添加成功
        list.add("www.w3cschool.cc");

        // 使用iterator遍历list集合
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.println(value);
        }

        // 使用传统for遍历list集合
        for (int i = 0, size = list.size(); i < size; i++) {
            String value = list.get(i);
            System.out.println(value);
        }

        // 使用增强for遍历list集合
        for (String s :
                list) {
            System.out.println(s);
        }
    }
    private static void setTest() {
        Set<String> set = new HashSet<String>();
        set.add("JAVA");
        set.add("C");
        set.add("C++");
        set.add("JAVA"); // set 唯一性，重复数据添加失败
        set.add("JAVASCRIPT");

        // 使用iterator遍历set集合
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.println(value);
        }

        // set无序，不能索引，所以不能用get()，无法使用传统for遍历set集合

        // 使用增强for遍历set集合
        for (String s :
                set) {
            System.out.println(s);
        }
    }
*/

    //    Java 集合 - 集合反转 Collections.reverse()
/*
    public static void main(String[] args) {
        String[] coins = {"A", "B", "C", "D", "E"};
        List list = new ArrayList();
        for (int i = 0; i < coins.length; i++) {
            list.add(coins[i]);
        }
        ListIterator listIterator = list.listIterator();
        System.out.println("反转前");
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        Collections.reverse(list);
        listIterator = list.listIterator();
        System.out.println("反转后");
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }
*/

    //    Java 集合 - 删除集合中指定元素
/*
    public static void main(String[] args) {
        System.out.println("集合实例！\n");
        int size;
        HashSet hashSet = new HashSet();
        String string1 = "Yellow", string2 = "White", string3 = "Green", string4 = "Blue";
        Iterator iterator;
        hashSet.add(string1);
        hashSet.add(string2);
        hashSet.add(string3);
        hashSet.add(string4);
        System.out.print("集合数据：");
        iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        hashSet.remove(string2);
        System.out.println("删除" + string2 + "之后：\n");
        System.out.print("现在集合的数据是：");
        iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        size = hashSet.size();
        System.out.println("集合的大小是：" + size + "\n");
    }
*/

    //    Java 集合 - 只读集合 Collections.unmodifiableSet()
/*
    public static void main(String[] args) throws Exception {
        List stuff = Arrays.asList(new String[]{"a", "b"});
        System.out.println(stuff);

        List list = new ArrayList(stuff);
        list = Collections.unmodifiableList(list);
        System.out.println("list:" + list.toString());
        try {
            list.set(0, "new value");
        } catch (UnsupportedOperationException e) {
            System.out.println("ArrayList集合现在是只读");
        }

        Set set = new HashSet(stuff);
        set = Collections.unmodifiableSet(set);
        System.out.println("set:" + set.toString());
        try {
            set.add("new value");
        } catch (UnsupportedOperationException e) {
            System.out.println("HashSet集合现在是只读");
        }

        StringBuffer key = new StringBuffer();
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < stuff.size(); i++) {
            map.put(String.valueOf(i), String.valueOf(stuff.get(i)));
        }
        map = Collections.unmodifiableMap(map);
        System.out.println("map" + map.toString());
        try {
            map.put("2", "new value");
        } catch (UnsupportedOperationException e) {
            System.out.println("map集合现在是只读");
        }
    }
*/

    //    Java 集合 - List循环移动元素 Collections.rotate()
/*
    public static void main(String[] args) {
        List list = Arrays.asList("One|Two|Three|Four|Five|Six".split("\\|"));
        System.out.println("List: " + list);
        Collections.rotate(list, 2);
        System.out.println("rotate: " + list);
    }
*/

    //    Java 集合 - 查找List中的最大最小值
/*
    public static void main(String[] args) {
        List list = Arrays.asList("One Two Three Four Five Six One Three Four".split(" "));
        System.out.println(list);
        System.out.println("最大值：" + Collections.max(list));
        System.out.println("最小值：" + Collections.min(list));
    }
*/

    //    Java 集合 - 查遍历HashTable的键和值
/*
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("1", "One");
        hashtable.put("2", "Two");
        hashtable.put("3", "Three");
        Enumeration enumerationkeys = hashtable.keys();
        while (enumerationkeys.hasMoreElements()) {
            System.out.println(enumerationkeys.nextElement());
        }
        Enumeration enumerationElements = hashtable.elements();
        while (enumerationElements.hasMoreElements()) {
            System.out.println(enumerationElements.nextElement());
        }

    }
*/

    //    Java 集合 - 集合中添加不同类型元素
/*
    public static void main(String[] args) {
        List linkedList = new LinkedList();
        linkedList.add("linkedListeElement1");
        linkedList.add("linkedListElement2");
        linkedList.add("linkedListElement3");
        linkedList.add("linkedListElement4");
        displayAll(linkedList);
        List arrayList = new ArrayList();
        arrayList.add("arrayListElement1");
        arrayList.add("arrayListElement2");
        arrayList.add("arrayListElement3");
        arrayList.add("arrayListElement4");
        displayAll(arrayList);
        Set hashSet = new HashSet();
        hashSet.add("hashSetElement1");
        hashSet.add("hashSetElement2");
        hashSet.add("hashSetElement3");
        hashSet.add("hashSetElement4");
        displayAll(hashSet);
        TreeSet treeSet = new TreeSet();
        treeSet.add("treeSetElement1");
        treeSet.add("treeSetElement2");
        treeSet.add("treeSetElement3");
        treeSet.add("treeSetElement4");
        displayAll(treeSet);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("linkedHashSetElement1");
        linkedHashSet.add("linkedHashSetElement2");
        linkedHashSet.add("linkedHashSetElement3");
        linkedHashSet.add("linkedHashSetElement4");
        displayAll(linkedHashSet);
        Map map1 = new HashMap();
        map1.put("map1Key1", "map1Element1");
        map1.put("map1Key2", "map1Element2");
        map1.put("map1Key3", "map1Element3");
        map1.put("map1Key4", "map1Element4");
        displayAll(map1.keySet());
        displayAll(map1.values());
        TreeMap map2 = new TreeMap();
        map2.put("map2Key1", "map2Element1");
        map2.put("map2Key2", "map2Element2");
        map2.put("map2Key3", "map2Element3");
        map2.put("map2Key4", "map2Element4");
        displayAll(map2.keySet());
        displayAll(map2.values());
        LinkedHashMap map3 = new LinkedHashMap();
        map3.put("map3Key1", "map3Element1");
        map3.put("map3Key2", "map3Element2");
        map3.put("map3Key3", "map3Element3");
        map3.put("map3Key4", "map3Element4");
        displayAll(map3.keySet());
        displayAll(map3.values());
    }
    static void displayAll(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            String string = (String) iterator.next();
            System.out.print(string + " ");
        }
        System.out.println();
    }
*/

    //    Java 集合 - List元素替换 Collections.replaceAll()
/*
    public static void main(String[] args) {
        List list = Arrays.asList("One Two Three Four Five Six One Three Four".split(" "));
        System.out.println("List：" + list);
        Collections.replaceAll(list, "One", "one");
        System.out.println("replaceAll：" + list);
    }
*/

    //    Java 集合 - List截取
/*
    public static void main(String[] args) {
        List list = Arrays.asList("One Two Three Four Five Six One Three Four".split(" "));
        System.out.println("List：" + list);
        List sublist = Arrays.asList("Three Four".split(" "));
        System.out.println("SubList：" + sublist);
        System.out.println("indexOfSublist：" + Collections.indexOfSubList(list, sublist));
        System.out.println("lastIndexOfSublist：" + Collections.lastIndexOfSubList(list, sublist));
    }
*/

}
