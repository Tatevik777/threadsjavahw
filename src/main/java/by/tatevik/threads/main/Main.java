package by.tatevik.threads.main;

import by.tatevik.threads.model.MyThread;
import by.tatevik.threads.model.MyThread2;

import static by.tatevik.threads.model.SumOfSquares.calculateSumOfSquares;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //task1
        task1();
        //task2
        MyThread myThread1=new MyThread();
        myThread1.start();
        MyThread myThread2=new MyThread();
        myThread2.start();
        //task3
        int N = 10; // Измените значение N, если необходимо
        int numThreads = 4; // Измените количество потоков, если необходимо
        int totalSum = calculateSumOfSquares(N, numThreads);
        System.out.println("Сумма квадратов первых " + N + " натуральных чисел: " + totalSum);
        // task5
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
    public static void task1(){
        //even numbers
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    if (i % 2 == 0) {
                        System.out.println("even thread " + i);
                    }
                }
            }
        };
        t1.start();
        //odd numbers
        Thread t2 = new Thread() {
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    if (i % 2 != 0) {
                        System.out.println("odd thread " + i);
                    }
                }
            }
        };
        t2.start();

    }
}
