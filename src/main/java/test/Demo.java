package test;

public class Demo {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        Thread t = new Thread(b);
        t.start();
        a.print();
    }
}

class A {
    public void print() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B implements Runnable {
    A a;

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}