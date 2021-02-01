package CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFuture_1 {
    public static void main(String[] args) {
        CompletableFuture<String> processe = processe();

        CompletableFuture<String> thenApply = processe.thenApply(s -> s.concat("Future"));

        CompletableFuture<Void> thenAccept = thenApply.thenAccept(System.out::println);

        System.err.println("########################################");
        sleep();
        sleep();
        sleep();
    }

    private static CompletableFuture<String> processe() {
        return CompletableFuture.supplyAsync(() -> {
            sleep();
            return "Completable ";
        });
    }

    private static final void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
