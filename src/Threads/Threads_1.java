package Threads;

public class Threads_1 {
    public static void main(String[] args) {
        // Thread atual
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());

        // Nova thread
        Thread thread1 = new Thread(new MeuRunnable());
        //thread1.run(); // apenas executando na mesma  thread
        thread1.start(); // executando em uma nova thread

        // Runnable como lambda
        Thread thread2 = new Thread(() -> {
            String name = Thread.currentThread().getName();
            System.out.println(name);
        });
        thread2.start();
        //thread2.start(); // Não faça, vai lançar exceção!!

        //Threads diferences com o mesmo Runnable
        Thread thread3 = new Thread(new MeuRunnable());
        thread3.start();
    }
}
