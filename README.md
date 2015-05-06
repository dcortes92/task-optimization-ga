# Task Manager Optimization
===============

<p>This is an adaptation of the traveling salesman problem (http://www.theprojectspot.com/tutorial-post/applying-a-genetic-algorithm-to-the-travelling-salesman-problem/5). 
In this case, the traveler is seen as a process of tasks of e.g. a manufacturing company. Each task has a duration and also there's time to pass from one task to another.</p>

<p>A Genetic Algorithm is still used to get to a solution. However, this time is static. So, a reference matrix is used to store the durations. The matrix has NxN dimentions.</p>

## Matrix:

| A | B | C | D |
|---|---|---|---|
| 0 | 2 | 5 | 1 |
| 3 | 0 | 4 | 2 |
| 1 | 3 | 0 | 6 |
| 4 | 8 | 2 | 0 |

This can be read as: "To go from task A to task B it takes 2 hours". Going from task A to task A takes 0 hours, and so on.

## Input
<p>The input is the matrix like the previous example.</p>

## Output
<p>The output is a process, ordering the tasks according to the solution provided by the GA. For example, 
A -> D -> C -> B. This is the optimal order in which the tasks need to be done in order to minimize the time.</p>