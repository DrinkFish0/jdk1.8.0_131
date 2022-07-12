import org.junit.Test;

/**
 * String.intern() 方法
 * @author DrinkFish
 */
public class StringInternTest {
    /**
     * s1 等价于 “ab” 并放入字符串常量池，s2 赋值时，由于字符串常量池中有 “ab”，所以直接将地址赋给 s2。
     */
    @Test
    public void test1() {
        String s1 = "a" + "b";
        String s2 = "ab";
        System.out.println(s1 == s2);   //true
        System.out.println(s1 == "ab"); //true
        System.out.println(s2 == "ab"); //true
    }

    /**
     * s1 使用 new 关键字在堆中创建一个对象 “ab”，在常量池中创建一个对象 “ab”，一共创建 2 个对象。
     * s2 创建的对象有 new StringBuilder() 、new String("a")、常量池中的“a”、new String("b")、
     * 常量池中的 "b"，StringBuilder.toString() 中会创建 new String("ab")，
     * 但是在字符串常量池中不生成“ab”。一共创建 6 个对象。
     */
    @Test
    public void test2() {
        String s1 = new String("ab");
        String s2 = new String("a") + new String("b");
        System.out.println(s1 == s2);   //false
        System.out.println(s1 == "ab"); //false
        System.out.println(s2 == "ab"); //false
    }

    /**
     * s1 在堆中创建对象 “ab”，当执行 s1.intern() 时，判断常量池是否有 与 s1 相同的字符串，
     * 这里显然没有，所以将对象 s1 添加到字符串常量池中，并返回 s1 对象的引用。所以 s1 和 s2 相等。
     */
    @Test
    public void test3() {
        String s1 = new String("a") + new String("b");
        String s2 = s1.intern();
        System.out.println(s1 == s2);   //true
        System.out.println(s1 == "ab"); //true
        System.out.println(s2 == "ab"); //true
    }

    /**
     * 首先在常量池中创建对象 “ab”，然后在堆中创建对象 s1，执行 s1.intern() 时，
     * 首先判断常量池中是否存在等于 s1 对象的字符串，当前已存在，所以直接返回常量池中的对象 “ab” 给 s2，它是和 s1 不相等的。
     */
    @Test
    public void test4() {
        String str = "ab";
        String s1 = new String("a") + new String("b");
        String s2 = s1.intern();
        System.out.println(s1 == s2);   //false
        System.out.println(s1 == "ab"); //false
        System.out.println(s2 == "ab"); //true
    }
}
