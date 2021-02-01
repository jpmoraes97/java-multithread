package ExecutorsSingleThreadCallable;

import java.util.concurrent.*;

public class ExecutorsSingleThreadCallable_2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newSingleThreadExecutor();
            Future<String> future = executorService.submit(new Tarefa());
            
            //String valor = future.get();
            String valor = future.get(10, TimeUnit.SECONDS);

            System.out.println("Valor retornado no future: " + valor);
        } catch (Exception e) {
            throw e;
        } finally {
            executorService.shutdown();
        }

    }

    public static class Tarefa implements Callable<String> {

        @Override
        public String call() throws Exception {
            return Thread.currentThread().getName().concat(" devolvendo a string!!");
        }
    }
}
