package by.tatevik.threads.model;

import java.util.List;

public class SumOfSquaresThread extends Thread{
    //- Объявляем три переменные. start и end будут хранить границы диапазона чисел,
    // которые этот поток будет обрабатывать. result - это список,
    // который будет использоваться для хранения суммы квадратов,
    // вычисленной потоком.
    private int start;
    private int end;
    private List<Integer> result;

    //- Это конструктор класса, который инициализирует переменные start,
    // end и result из аргументов, переданных при создании объекта.
    public SumOfSquaresThread(int start, int end, List<Integer> result) {
        this.start = start;
        this.end = end;
        this.result = result;
    }
//- Переопределяем метод run, который будет выполняться, когда
  //  поток запускается.
    @Override
    public void run() {
        int total = 0;// переменная total для хранения суммы квадратов в рамках данного потока.
        //  - Цикл for, который проходит через все числа от start до end,
        //  вычисляет квадрат каждого числа и добавляет его к total.
        for (int i = start; i <= end; i++) {
            total += i * i;
        }
        //- Используем synchronized, чтобы гарантировать, что только один поток
        // одновременно может изменить список result. Добавляем вычисленный
        // total в список.
        synchronized (result) {
            result.add(total);
        }
    }
}
