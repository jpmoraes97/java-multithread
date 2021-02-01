package ClassesAtomicas;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ClassesAtomicas {
    //public static AtomicInteger i = new AtomicInteger();
    //public static AtomicLong i = new AtomicLong();
    public static AtomicBoolean aBoolean = new AtomicBoolean();

    public static void main(String[] args) {
        MeuRunnable runnable = new MeuRunnable();

        Thread thread0 = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }

    public static class MeuRunnable implements Runnable {

        @Override
        public void run() {
            //System.out.println(Thread.currentThread().getName().concat(":") + i.incrementAndGet());
            //System.out.println(Thread.currentThread().getName().concat(":") + i.incrementAndGet());
            System.out.println(Thread.currentThread().getName().concat(":") +
                    aBoolean.compareAndExchange(false, true));

        }
    }
}
