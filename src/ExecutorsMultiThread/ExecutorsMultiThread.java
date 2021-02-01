package ExecutorsMultiThread;

import java.util.List;
import java.util.concurrent.*;

public class ExecutorsMultiThread {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = null;
        try {
            //executorService = Executors.newFixedThreadPool(5);

            // Reutiliza a thread ao invés de passar um valor fixo!
            // ex: caso a primeira tarefa termine ele reutiliza a thread
            executorService = Executors.newCachedThreadPool();

            Tarefa t1 = new Tarefa();
            Tarefa t2 = new Tarefa();
            Tarefa t3 = new Tarefa();
            Tarefa t4 = new Tarefa();

            // Método InvokeAll executa todas as tarefas
//            List<Future<String>> futures = executorService.invokeAll(List.of(t1, t2, t3, t4));
//            for (Future<String> future : futures) {
//                System.out.println(future.get());
//            }

            // Método InvokeAny retorna o resultado da primeira tarefa que foi concluida
            String s = executorService.invokeAny(List.of(t1, t2, t3, t4));
            System.out.println(s);


//            Future<String> future1 = executorService.submit(new Tarefa());
//            Future<String> future2 = executorService.submit(new Tarefa());
//            Future<String> future3 = executorService.submit(new Tarefa());
//            Future<String> future4 = executorService.submit(new Tarefa());
//            Future<String> future5 = executorService.submit(new Tarefa());
//
//            System.out.println(future1.get());
//            System.out.println(future2.get());
//            System.out.println(future3.get());
//            System.out.println(future4.get());
//            System.out.println(future5.get());

            executorService.shutdown();
        } catch (Exception e) {
            throw e;
        } finally {
            if (executorService != null)
                executorService.shutdownNow();
        }
    }

    public static class Tarefa implements Callable<String> {

        @Override
        public String call() throws Exception {
            return Thread.currentThread().getName();
        }
    }
}
