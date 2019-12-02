package test;

public class VolatileTest {

    int i;                            // 普通变量
    final int j;
    static VolatileTest obj;

    public VolatileTest() {     // 构造函数
        i = 1;                        // 写普通域
        j = 2;
    }

    public static void writer () {    // 写线程 A 执行
        try {
            Thread.sleep(100);
        }catch (Exception e) {

        }
        obj = new VolatileTest ();
    }

    public static void reader () {       // 读线程 B 执行
        try {
            Thread.sleep(100);
        }catch (Exception e) {

        }
        VolatileTest object = obj;       // 读对象引用
        int a = object.i;                // 读普通域
        int b = object.j;                // 读 final 域
        System.out.println(a + "   " + b);
    }

    public static void main(String[] args) {
        new Thread(() -> VolatileTest.writer()).start();
        new Thread(() -> VolatileTest.reader()).start();
    }
}
