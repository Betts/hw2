import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.stream.Collectors;
import java.io.*;
import java.lang.Math;
import java.time.*;



public class hw2a extends Thread{
    static AtomicInteger mazeCounter = new AtomicInteger(1);
    static long sum = 0;
    static AtomicInteger totalPrimes = new AtomicInteger(0);
    static AtomicBoolean cupcake = new AtomicBoolean(); // will Initialize as not true
    static AtomicBoolean alert = new AtomicBoolean(); // will Initialize as not true
     static AtomicBoolean firstGuy = new AtomicBoolean(); // will Initialize as not true
    


    public void run() {
        if ()
    }


    public static void main(String[] args) throws FileNotFoundException {
        // We are allowed to choose a value for N, so I have gone with 8
        // This represents the number of threads / people that will enter the maze.
        int numPeople = 8;
        long firstGuyID;
        boolean alertMino = false;
        List<Long> threadList = new ArrayList<Long>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        
        for (int i = 0; i < N; i++)
        {
            ExecutorService exectutor = Executors.newSingleThreadExecutor();

        }

        // We'll be utilizing ExecutorService and an 8 thread pool
        ExecutorService executor = Executors.newFixedThreadPool(8);
        executor.execute(() -> {
            
            //If Firstguy not false
                // Firstguy = true
                // firstGuyID = Thread.currentThread().getID();
            //else
            while (alertMino == false)
            {
                
            
                // The first person to enter will take up the important duty. This simulates that
                if (firstGuy.get() != true)
                {
                    firstGuy.set(true);
                    firstGuyID = Thread.currentThread().getID();
                }

                // This block checks to see if the current thread is the appointed firstGuy
                // and executes code associated with the First Persons role
                if (Thread.currentThread().getID(); == firstGuyID)
                {
                    if (cupcake.get() != true)
                    {
                        cupcake.set(true);
                        mazeCounter.getAndIncrement();
                    }

                    if (mazeCounter.get() >= 8)
                    {
                        System.out.println("We have all entered at least once!")
                        alertMino = true;
                    }
                }
                
                // Tasks for all threads

                if (cupcake.get == True)
                {
                    if(threadList.contains)
                }
                

            }


            // While loop that breaks when allEnt = True;
                // For loop that runs from 1 - n and spawns a new thread. Do getandset + 1 to atomicint Threadcount with each thread spawned. 
                // threadid = getandincrement Threadcount for previous line
        
                // Threads runnable task:
                    // If threadid = 0
                    // Check if Cake = True/False. 
                        // if true, do nothing. if false, getandset to true and getandincrement cakeCount + 1;
                    // Check cakeCount
                    // If cakeCount == N
                    // Alert to Minotaur that all have passed through
                        // allEnt = True;
            

            

            // Spawn N threads
            
            // Thread code:
            //
            // If thread N - check Boolean. If True, do nothing. If False, change to true, increase counter.
            // Now check counter. If counter == N - 1, alert minotaur. 
            
            // Else (Not Thread N)
            // Check selfBool. If false, then check Boolean. If Boolean is True, set to False one time, and set selfBool to True.
            // If selfBool is true, do nothing.

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