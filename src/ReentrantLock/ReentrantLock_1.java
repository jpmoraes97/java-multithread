package ReentrantLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock_1 {

    private static int i = -1;

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Runnable r1 = () -> {
            lock.lock();
            String name = Thread.currentThread().getName();
            i++;
            System.out.println(name.concat(" lendo e incrementando: ") + i);
            lock.unlock();
        };

        for (int i = 0; i < 10; i++) {
            executorService.execute(r1);
        }

        executorService.shutdown();
    }
}
