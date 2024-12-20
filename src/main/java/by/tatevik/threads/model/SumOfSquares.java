package by.tatevik.threads.model;

import java.util.ArrayList;
import java.util.List;

public class SumOfSquares {
    public static int calculateSumOfSquares(int N, int numThreads) throws InterruptedException {
        //- Создаем два списка: один для хранения потоков (threads),
        // а другой для хранения результатов от каждого потока (results).
        List<Thread> threads = new ArrayList<>();
        List<Integer> results = new ArrayList<>();
        //- Вычисляем размер "чанка" (порции) для каждого потока,
        // деля N на количество потоков.
        int chunkSize = N / numThreads;
// цикл для создания и запуска потоков.
        for (int i = 0; i < numThreads; i++) {
//- Определяем границы start и end для каждого потока. Если это последний поток,
// то конечное значение будет N,
// иначе - передаем в следующий поток следующий "чанк".
            int start = i * chunkSize + 1;
            int end = (i == numThreads - 1) ? N : (i + 1) * chunkSize;
            //- Создаем новый объект потока с заданными границами и списком результатов.
            Thread thread = new SumOfSquaresThread(start, end, results);
            //- Добавляем созданный поток в список threads и запускаем его.
            threads.add(thread);
            thread.start();
        }
       // - После создания и запуска потоков
        //мы ждем завершения каждого потока с помощью метода join.
        for (Thread thread : threads) {
            thread.join();
        }
     //   - Создаем переменную totalSum и суммируем все результаты из списка results.

        int totalSum = 0;
        for (int sum : results) {
            totalSum += sum;
        }
//- Возвращаем общую сумму, полученную от всех потоков.
        return totalSum;
    }
}
