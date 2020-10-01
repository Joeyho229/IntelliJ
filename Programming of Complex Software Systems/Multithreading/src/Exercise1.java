class Mytask implements Runnable {
    String threadName;
    Thread t;

    Mytask(String name) {
        this.threadName = name;
    }

    void taskStart(){
        if (t == null) {
            Thread t = new Thread(this, this.threadName);
            System.out.println(this.threadName + " is starting...");
            t.start();
        }
    }

    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(this.threadName + " is printing...");
            System.out.println("Hello World " +i);
            try {
                Thread.sleep(1000);     // When its sleep it will wait on each other to finish before moving on
            } catch (InterruptedException e) {
                System.out.println(this.threadName + " does not want to sleep...");
            }
        }
    }
}

public class Exercise1 {
    public static void main(String args[]) {
        Mytask task1 = new Mytask("thread1");
        Mytask task2 = new Mytask("thread1");
        task1.taskStart();
        task2.taskStart();
    }
}