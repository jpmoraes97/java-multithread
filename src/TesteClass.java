import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class TesteClass {
    public static void main(String[] args) {

        Instant inicio = Instant.now();
        Map<Double, Double> mapa = new ConcurrentHashMap<>();
        IntStream.range(1, 1000000)
                .parallel()
                .mapToDouble(numero -> Math.pow(numero, 5))
                .filter(numero -> numero % 2 == 0)
                .forEach(numero -> mapa.put(numero, Math.pow(numero, 5)));
        Instant fim = Instant.now();
        System.out.println(Duration.between(inicio, fim));
    }
}
