package ExecutorsSingleThreadCallable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorsSingleThreadCallable {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newSingleThreadExecutor();

            // podemos executar várias tarefas no mesmo executor
//            executorService.execute(new Tarefa());
//            executorService.execute(new Tarefa());

            Future<?> future = executorService.submit(new Tarefa());
            boolean done = future.isDone();
            System.out.println(done);

            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            throw e;
        } finally {
            if (executorService != null)
                executorService.shutdown();
            //executorService.shutdownNow();
        }
    }


    public static class Tarefa implements Runnable {

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println("Exececutando a tarefa na thread: ".concat(name));
        }
    }
}
