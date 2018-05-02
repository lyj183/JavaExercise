package JavaAdviseExercise;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @author: linyijin
 * @Date: Created in 2017/12/20 10:07
 * @Description:
 **/
public class JavaAdviseExercise {
    //1、建议1：不要在常量和变量中出现易混淆的字母
/*
    public static void main(String[] args) {
        long i = 1l;
        System.out.println("i的两倍是：" + (i + i));
    }
*/
    // 2、建议4：避免带有变长参数的方法重载
/*
    public void calPrice(int price, int discount) {
        float knockdownPrice = price * discount / 100.0F;
        System.out.println("简单折扣后的价格是：" + formateCurrency(knockdownPrice));
    }
    public void calPrice(int price, int... discounts) {
        float knockdownPrice = price;
        for (int discount :
                discounts) {
            knockdownPrice = knockdownPrice * discount / 100;
        }
        System.out.println("复杂折扣后的价格是：" + formateCurrency(knockdownPrice));
    }
    private String formateCurrency(float price) {
        return NumberFormat.getCurrencyInstance().format(price/100);
    }

    public static void main(String[] args) {
        JavaAdviseExercise client = new JavaAdviseExercise();
        client.calPrice(49900, 75);
    }
*/
    // 3、建议7：警惕自增的陷阱
/*
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            count = count++;
        }
        System.out.println("count=" + count);
    }
*/
    // 4、建议15：break万万不可忘
/*
    public static void main(String[] args) {
        System.out.println("2 = "+toChineseNumberCase(2));
    }
    public static String toChineseNumberCase(int n) {
        String chineseNumber = "";
        switch (n) {
            case 0:chineseNumber = "零";
            case 1:chineseNumber = "壹";
            case 2:chineseNumber = "贰";
            case 3:chineseNumber = "叁";
            case 4:chineseNumber = "肆";
            case 5:chineseNumber = "伍";
            case 6:chineseNumber = "陆";
            case 7:chineseNumber = "柒";
            case 8:chineseNumber = "捌";
            case 9:chineseNumber = "玖";
        }
        return chineseNumber;
    }
*/
    // 5、建议21：用偶判断，不用奇判断
/*
    public static void main(String[] args) {
        int[] i = {1, 2, 0, -1, -2};
        for (int j = 0; j < i.length; j++) {
            String string = i[j] + "->" + (i[j]%2 == 1 ? "奇数" : "偶数"); // 错误
            System.out.println(string);
        }
        System.out.println("****************************");
        for (int j = 0; j < i.length; j++) {
            String string = i[j] + "->" + (i[j]%2 == 0 ? "偶数" : "奇数"); // 正确
            System.out.println(string);
        }
    }
*/
    // 6、建议22：用整数类型处理货币
    public static void main(String[] args) {
        System.out.println(10.00-9.60); // 错误
        System.out.println("****************************");
        BigDecimal abig = new BigDecimal(10.00);
        BigDecimal bbig = new BigDecimal(9.60);
        System.out.println(abig.subtract(bbig).setScale(2, BigDecimal.ROUND_HALF_UP)); // 正确

    }
}
