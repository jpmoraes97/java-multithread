package Semaphore;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Semaphore_2 {

    private static Semaphore SEMAFORO = new Semaphore(3);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Runnable r1 = () -> {
            String name = Thread.currentThread().getName();
            int usuario = new Random().nextInt(100);

            boolean conseguiu = false;
            while (!conseguiu) {
                conseguiu = tryAcquire();
            }

            System.out.println("Usuário: " + usuario + " Acessou a thread ".concat(name));

            SEMAFORO.release();
        };

        for (int i = 0; i < 500; i++) {
            executorService.execute(r1);
        }
    }

    private static boolean tryAcquire() {
        try {
            SEMAFORO.tryAcquire(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } finally {
            return false;
        }
    }
}
