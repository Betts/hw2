import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.stream.Collectors;
import java.io.*;
import java.lang.Math;
import java.time.*;



public class hw2b{
    static AtomicInteger counter = new AtomicInteger(1);
    static long sum = 0;
    static AtomicInteger totalPrimes = new AtomicInteger(0);

    public static void main(String[] args) throws FileNotFoundException {
        // Limit is 10^8, and it is the maximum value that our boss has requested
        int limit = 100000000;
        List<Integer> lst = new ArrayList<>();

        // We'll be utilizing ExecutorService and an 8 thread pool
        ExecutorService executor = Executors.newFixedThreadPool(8);
        executor.execute(() -> {
            long start = System.currentTimeMillis();
            int i = 0;

            // Will run through 1 to the set limit, and test each number to see if it is a prime
            while (i < limit)
        {
            i = counter.getAndIncrement();
            if (isPrime(i))
            {
                lst.add(i);
                sum = sum + i;
                totalPrimes.getAndIncrement();
            }
        }

        List<Integer> lst1 = lst.stream().sorted(Comparator.reverseOrder()).limit(10).collect(Collectors.toList()); 
        Collections.reverse(lst1);
        long end = System.currentTimeMillis();
        long totalTime = end - start;
        System.out.println("complete");
        try (PrintStream o = new PrintStream(new File("primes.txt"))) {
            PrintStream console = System.out;
            System.setOut(o);
            System.out.println("Total Time: " + totalTime +" ms.");
            System.out.println("Total Primes Found: " + totalPrimes);
            System.out.println("Sum of Primes: " + sum);
            System.out.println("Top 10 primes: " + lst1);
            System.setOut(console);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        });
        executor.shutdown();
    }

    // Method to check whether the incoming number is a prime or not. 
    // Returns False if num is not a prime, returns True if num is a prime. 
    public static boolean isPrime(int num)
    {
        if (num <= 1)
        {
            return false;
        }

        int sqNum = (int) Math.sqrt(num);

        for (int i = 2; i <= sqNum; i++)
        {
            if (num % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}