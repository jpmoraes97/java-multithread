package ExecutorsScheduled;

import java.util.concurrent.*;

public class ExecutorsScheduled {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        //ScheduledFuture<String> future = scheduledExecutorService.schedule(new Tarefa(), 20, TimeUnit.SECONDS);
        //String s = future.get();
        //System.out.println(s);

        // Tarefa como Runnable
        //scheduledExecutorService.schedule(new TarefaRunnable(), 5, TimeUnit.SECONDS);

        // FixedRate, não pode ter shutdown
        //scheduledExecutorService.scheduleAtFixedRate(new TarefaRunnable(), 0, 1, TimeUnit.SECONDS);

        // FixedDelay
        // Sempre vai ter um intervalo entre as tarefas que estão sendo executadas!
        scheduledExecutorService.scheduleWithFixedDelay(new TarefaRunnable(), 0, 1, TimeUnit.SECONDS);

        //scheduledExecutorService.shutdown();
    }

    public static class Tarefa implements Callable<String> {

        @Override
        public String call() throws Exception {
            return Thread.currentThread().getName().concat(" devolvendo a string!!");
        }
    }

    public static class TarefaRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName().concat(" Runnable!!"));
        }
    }
}
