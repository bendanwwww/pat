package test;

public class ThreadTest {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {});
        long t1 = System.currentTimeMillis();
        for(int i = 0 ; i < 100000 ; i++) {
            Thread thread = new Thread(() -> {});
            //thread.start();
        }
        System.out.println("thread ------ " + (System.currentTimeMillis() - t1));

        long t2 = System.currentTimeMillis();
        for(int i = 0 ; i < 100000 ; i++) {
            Object o = new Object();
        }
        System.out.println("object ------ " + (System.currentTimeMillis() - t2));
    }
}
