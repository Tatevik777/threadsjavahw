package by.tatevik.threads.main;

import by.tatevik.threads.model.MyThread;
import by.tatevik.threads.model.MyThread2;

import static by.tatevik.threads.model.SumOfSquares.calculateSumOfSquares;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //task1
       // task1();
        //task2
      //  MyThread myThread1 = new MyThread();
      //  myThread1.start();
      //  MyThread myThread2 = new MyThread();
      //  myThread2.start();
        //task3
       // int N = 10; // Измените значение N, если необходимо
      //  int numThreads = 4; // Измените количество потоков, если необходимо
      //  int totalSum = calculateSumOfSquares(N, numThreads);
     //   System.out.println("Сумма квадратов первых " + N + " натуральных чисел: " + totalSum);
        // task5
        MyThread2.startThread();
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
