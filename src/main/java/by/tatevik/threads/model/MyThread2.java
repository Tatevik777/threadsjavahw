package by.tatevik.threads.model;

public class MyThread2 extends Thread{
    private String threadName;

    public MyThread2(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(threadName + " - сообщение " + (i + 1));
            try {
                Thread.sleep(1000); // Задержка на 1 секунду
            } catch (InterruptedException e) {
                System.out.println(threadName + " был прерван.");
            }
        }
    }
}
