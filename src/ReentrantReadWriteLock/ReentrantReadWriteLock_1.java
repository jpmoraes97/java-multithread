package ReentrantReadWriteLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLock_1 {

    private static int i = -1;
    private static ReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Runnable r1 = () -> {
            Lock writeLock = lock.writeLock();
            writeLock.lock();
            String name = Thread.currentThread().getName();
            System.out.println(name.concat(" escrevendo: ") + i);
            i++;
            System.out.println(name.concat(" escrito: ") + i);
            writeLock.unlock();
        };

        Runnable r2 = () -> {
            Lock readLock = lock.readLock();
            readLock.lock();
            System.out.println("Lendo: " + i);
            System.out.println("Lido: " + 1);
            readLock.unlock();
        };

        for (int i = 0; i < 10; i++) {
            executorService.execute(r1);
            executorService.execute(r2);
        }

        executorService.shutdown();
    }
}
