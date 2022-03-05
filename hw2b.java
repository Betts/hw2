import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.stream.Collectors;
import java.io.*;
import java.lang.Math;
import java.time.*;


// Taken from Chapter 7 (figure 7.7) of our textbook
// This is an Array-Based Lock Queue, which represents the implementation of our 
// vase-viewing ruleset. 
public class hw2b{
    ThreadLocal<Integer> mySlotIndex = new ThreadLocal<Integer> ()
    {
        protected Integer initialValue()
        {
            return 0;
        }
    };

    AtomicInteger tail;
    volatile boolean[] flag;
    int size;

    public ALock(int capacity){
        size = capacity;
        tail = new AtomicInteger(0);
        flag = new boolean[capacity];
        flag[0] = true;
    }

    public void lock() {
        int slot = tail.getAndIncrement() % size;
        mySlotIndex.set(slot);
        while (! flag[slot]) {};
    }

    public void unlock(){
        int slot = mySlotIndex.get();
        flag[slot] = false;
        flag[(slot + 1) % size] = true;
    }

    public static void main(String[] args){
        
       
    }
}