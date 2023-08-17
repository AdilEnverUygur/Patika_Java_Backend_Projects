package ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class NumberSplitter {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            numbers.add(i);
        }

        int chunkSize = 2500;

        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<Callable<List<Integer>>> tasks = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            final int startIndex = i * chunkSize;
            final int endIndex = (i + 1) * chunkSize;
            tasks.add(() -> processChunk(numbers.subList(startIndex, endIndex)));
        }

        List<Future<List<Integer>>> results = executor.invokeAll(tasks);

        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();

        for (Future<List<Integer>> result : results) {
            List<Integer> chunkResult = result.get();
            for (Integer num : chunkResult) {
                if (num % 2 == 0) {
                    evenNumbers.add(num);
                } else {
                    oddNumbers.add(num);
                }
            }
        }

        executor.shutdown();

        System.out.println("Odd numbers: " + oddNumbers);
        System.out.println("Even numbers: " + evenNumbers);
    }

    private static List<Integer> processChunk(List<Integer> chunk) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : chunk) {
            result.add(num);
        }
        return result;
    }
}

