package basic.Thread;

public class MyRunnable implements Runnable{

    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " is running." + " in " + Thread.currentThread().getName());
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
