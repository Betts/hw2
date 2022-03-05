# Homework 2
Jacob Betts
COP 4520

hw2a.java Contains my solution for problem 1. 

My Strategy for Problem 1:

In the rules for my world the first person to ender the labrynth knows that they are the first person.
The others do not know their position, and do not need to know. They only need to know that they are not first.

The strategy for problem 1 boils down to this:
There are N total people who need to pass through the maze at least once. In my set of rules, person 1 knows that they are the first to enter the maze, but every other person does not need to know their position Person 1 will be the only person who is allowed to order new cakes. Every other person is instructed to eat the first cake they see and leave the empty plate. After this they are instructed to ignore all plates regardless of the amount of cake on them and continue through. Person 1 will count the number of times that the cake has been eaten. Once the cake has been eaten N number of times, person 1 will inform the minotaur that all parties have entered and solved the maze at least once.

We will now convert this to multithreaded programming in java. In our program each person is represented by a thread. We are told in the problem that we are allowed to choose the number that will represent N. In my program I will set N = 8.

In my program I will give each thread the task of checking if a Boolean is true or false.  If the Boolean is false, they will set it to true one time. After setting it to true one time they will continue to check the boolean value, but they will no longer make any changes to it. The first threaad will perform a similar process. The first thread will check the Boolean value to see whether it is true or false. If it is true, it will set it to false, and increase a counter by 1. This process will continue until the counter reaches N. Once the counter reaches N the thread will signal to the while loop which contains this entire process, and signal that all parties have entered the maze at least once.



hw2b.java Contains my solutions for problem 2. 

Problem 2:

In this problem the Minotaur has returned, and now he is showing his guests his crystal vase. We are presented with three stategies that we must compare and choose from. 

I will discuss the advantages and disadvantages of each strategy now.

Strategy 1:
The first strategies issue, is that each guest must complete the act of opening the door before they know whether or not they may enter the room and view the vase. This cuases issues with people having to queue up just to perform the act of checking whether or not the room is available. If the room is not available, then you have stood around in line or fought your way through a crowd for nothing. The other issue is that the queue in this strategy is not even guaranteed since it is not part of our ruleset. We are simply hoping they MIGHT queue up or form a system of fairness on their own. Essentially this strategy boils down to needing two instances of luck to secure a spot in the room with the vase. 

Strategy 2:
The second strategies issue is that there is no fair way to distribute the viewing of the vase, since there is no queue. With this plan you have to be lucky and happen upon the door at a moment when it is free, and you again have no guarantee that you will ever see the vase. 

Strategy 3:

This is my strategy of choice. I think that this strategy is the fairest that could be implemented, and it eliminates one of the major disadvantages from strategy 1, where you are waiting simply for the chance to check the door. With this system if you are the first person in line, then are guaranteed to be the next person who is let into the room when it becomes available. The other systems do not offer this. 

To implement strategy 3 I will be using code from chapter 7 of our textbook for an Array-Based Queue Lock (found in section 7.5). The lock itself represents the room with the vase, and acquiring the lock represents being present in the room viewing the vase. The "flag[j]" boolean variable is set to true when the next person in line moves forward, and acquires permission to enter the room. When that person/thread leaves the room/gives up the lock then this flag boolean variable is set to false for the current person who left the room, and true for the next person in line. The flag variable is representative of the verbal queue of permission to enter that each person in the front of the line is given when the current occupant of the room leaves. Since we have been given no ending condition, or instructions that state that we have to include the party itself in our code, I believe that this is all that I have to include. To be honest I'm a bit confused on what the actual requirements are for this part, but based on what is on the assignment page I think I have fulfilled all of the requirements. 

There is one disadvantage to strategy 3 that I would point out. In strategy 3, if no one is present when someone leaves the room, and a new person shows up, that new person will assume that someone is currently in the room, and begin to form a line. I feel like all three strategies have disadvantages however, and in terms of fairness, I felt like this was the best option. 


