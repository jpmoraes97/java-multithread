package SynchronousQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueue_1 {

    // Funciona quando uma tarefa faz put e outra take!!
    private static final SynchronousQueue<String> FILA = new SynchronousQueue<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Runnable r1 = () -> {
            put();
            System.out.println("Inseriu na fila!!");
        };

        Runnable r2 = () -> {
            String take = take();
            System.out.println("Pegou da fila!!" + take);
        };

        executorService.execute(r1);
        executorService.execute(r2);

        executorService.shutdown();
    }

    private static String take() {
        try {
            return FILA.take();
            //return FILA.poll(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
            return "Exceção";
        }
    }

    private static void put() {
        try {
            FILA.put("Palmeiras");
            //FILA.offer("Palmeiras", 1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
