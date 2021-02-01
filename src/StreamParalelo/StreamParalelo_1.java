package StreamParalelo;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class StreamParalelo_1 {
    public static void main(String[] args) {
        Instant inicio = Instant.now();
        Map<Double, Double> mapa = new ConcurrentHashMap<>();
        IntStream.range(1, 10000000)
                .parallel()
                .mapToDouble(num -> Math.pow(num, 3))
                .filter(num -> num % 2 == 0)
                .forEach(num -> mapa.put(num, Math.pow(num, 3)));
        Instant fim = Instant.now();
        System.out.println(Duration.between(inicio, fim));
    }
}
