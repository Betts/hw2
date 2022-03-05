# Homework 2
Jacob Betts
COP 4520

hw2a Contains my solution for problem 1. 

My Strategy for Problem 1:

In the rules for my world the first person to ender the labrynth knows that they are the first person.
The others do not know their position, and do not need to know. They only need to know that they are not first.

The strategy for problem 1 boils down to this:
There are N total people who need to pass through the maze at least once. In my set of rules, person 1 knows that they are the first to enter the maze,
but every other person does not need to know their position. Person 1 will be the only person who is allowed to order new cakes. 
Every other person is instructed to eat the first cake they see and leave the empty plate. After this they are instructed to 
ignore all plates regardless of the amount of cake on them and continue through. Person 1 will count the number of times that the cake has been eaten.
Once the cake has been eaten N number of times, person 1 will inform the minotaur that all parties have entered and solved the maze at least once.

We will now convert this to multithreaded programming in java. In our program each person is represented by a thread. We are told in the problem that we are
allowed to choose the number that will represent N. In my program I will set N = 8.

In my program I will give each thread the task of checking if a Boolean is true or false. 
If the Boolean is false, they will set it to true one time. After setting it to true one time they will 
continue to check the boolean value, but they will no longer make any changes to it. 
The first threaad will perform a similar process. The first thread will check the Boolean value to see whether it is true or false.
If it is true, it will set it to false, and increase a counter by 1. This process will continue until the counter reaches N. 
Once the counter reaches N the thread will signal to the while loop which contains this entire process, and signal that all parties have entered the maze at least once.


hw2b Contains my solutions for problem 2. This may change as work progresses. 

Initializing both files with my solution for HW1 as a base. Might erase entirely and start over. 
