import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.stream.Collectors;



public class hw2a extends Thread{
    static AtomicInteger mazeCounter = new AtomicInteger(1);
    static AtomicBoolean cupcake = new AtomicBoolean(); // will Initialize as not true
    static AtomicBoolean firstGuy = new AtomicBoolean(); // will Initialize as not true
    static AtomicBoolean alertMino = new AtomicBoolean(); 
    long firstGuyID;
    
    public static void main(String[] args){
        // We are allowed to choose a value for N, so I have gone with 8
        // This represents the number of threads / people that will enter the maze.

        List<Long> threadList = new ArrayList<Long>();
        
        // We'll be utilizing ExecutorService and an 8 thread pool
        ExecutorService executor = Executors.newFixedThreadPool(8);
        executor.execute(() -> {
            
            long firstGuyID = 0;

            while (alertMino.get() != true)
            {
                //System.out.println(alertMino.get());   
                // The first person to enter will take up the important duty. This simulates that
                if (firstGuy.get() != true)
                {
                    firstGuy.set(true);
                    firstGuyID = Thread.currentThread().getId();
                }

                // This block checks to see if the current thread is the appointed firstGuy
                // and executes code associated with the First Persons role
                if (Thread.currentThread().getId() == firstGuyID)
                {
                    if (cupcake.get() != false)
                    {
                        cupcake.set(false);
                        mazeCounter.getAndIncrement();
                    }
                    
                    // If we have refilled the cake (set true to false) 8 times and we are
                    // the first guy in, then we alert the minotaur that 
                    //all 8 people have gone through at least once.

                    if (mazeCounter.get() >= 8||firstGuyID == Thread.currentThread().getId())
                    {
                        System.out.println("We have all entered at least once!");
                        alertMino.set(true);;
                    }
                }

                // Tasks for all threads
                if (cupcake.get() != true)
                {
                    if (!threadList.contains(Thread.currentThread().getId()))
                    {
                        threadList.add(Thread.currentThread().getId());
                        cupcake.set(true);
                    }
                }
            }
        });
        executor.shutdown();
    }
}
