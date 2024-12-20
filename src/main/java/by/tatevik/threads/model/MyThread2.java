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
    public static void startThread(){
        MyThread2 thread1 = new MyThread2("Поток 1");
        MyThread2 thread2 = new MyThread2("Поток 2");

        thread1.start();  // Запускаем Поток 1
        try {
            Thread.sleep(100); // Небольшая задержка перед запуском Потока 2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();  // Запускаем Поток 2

        // Ждем завершения Потока 2
        try {
            thread2.join(); // Ждем, пока Поток 2 завершится
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ждем завершения Потока 1
        try {
            thread1.join(); // Ждем, пока Поток 1 завершится
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Оба потока завершены.");

    }
    }

