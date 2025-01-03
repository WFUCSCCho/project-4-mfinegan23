# Project 4 @ CSC 201 Fall 2024: Hash Tables

## Pledged Work Policy

This is a ___Pledged Work___ assignment.  This means that the work you submit for grading ___must___ be your work product.  
You may not submit the work of others outside of your team, or the modification of work of others outside of your team.
You are encouraged to talk with each other about general problems.  For example, you may talk to someone about "What does
it mean when the compiler says there is a semicolon missing on line 20", or "I can not get my assignment template to
download from GitHub, what did you do?".  However, you may not engage in "Could you send me a copy of your work so I can
see how to get started?".  You may get full and detailed assistance from me, the Teaching Assistant (TA), and the TAs in
the Computer Science Center.  If you have any question about the appropriateness of assistance, do not hesitate to
consult with me.

If I believe you have violated our ___Pledge Work___ agreement, I will pursue this matter through the college Honor Council.

## Overview

A hash table is a fundamental data structure that stores key-value pairs. It uses a hash function to compute an index
(hash) into an array of buckets or slots, from which the desired value can be found. The hash function is used to 
transform the key into the index of the array that will be used to store the value. Hash tables offer average case 
O(1) time complexity for lookups, insertions, and deletions, assuming that the hash function is well-designed and the
load factor is kept low.

In this project, you will 

1. Implement a hash table that uses separate chaining to handle collisions.
2. Perform the hash table insert, search, and delete operations using already-sorted, shuffled, and reversed datasets 
lists as input.
3. Time the insert, search, and delete operation performances for the different number of inputs.
4. Graph and analyze the performance of the hash table operations.
5. Document your dataset and results in a `README.md` file.

## Invocation and I/O Files:

The name of the program is `Proj4` ( provided with a `main` method in`Proj4.java` ).

You are encouraged to run and debug code in __IntelliJ IDEA__. Also, the program can be invoked from the command-line as:

```shell
java Proj4 {dataset-file} {number-of-lines}
```
## 1. **Implement Separate Chaining Hash Table**

I have enclosed one starter code:
1. `SeparateChainingHashTable.java`
2. `TestSeparateChainingHashTable.java`
3. `Proj4.java`

The `SeparateChainingHashTable.java` file contains an overall structure of that Separate Chaining Hash Table class, and 
you are expected to complete the code where it is indicated (Search for // FINISH ME). The 
`TestSeparateChainingHashTable.java` file must not be modified, and it will be used for testing your Separate Chaining 
Hash Table class. It does not check for every error, but I hope that it will be helpful for you. The Proj4.java file 
contains a starter code for you to implement the main driver of the program.

The program takes in two command line arguments: 1) the filename if your dataset and 2) the number of lines of your 
dataset to read.

## 2. **Perform Hash Table insert, search, and delete operations on Already-Sorted, Shuffled, and Reversed Lists**

You will read your dataset and store the data in an ArrayList. To sort and randomize your ArrayList, you will use the
`Collections.sort()`, `Collections.shuffle()`, and `Collections.sort(al, Collections.reverseOrder())` commands,
respectively.

## 3. **Time Sorting Algorithm Performance**

For the hash table insert, search, and delete operations, you will use `System.nanoTime()` to calculate
the time it takes to run them on already-sorted, shuffled, and reversed lists.

Your program will print out the number of lines evaluated and the times insert, search, and delete each of the dataset 
elements into the already-sorted, shuffled, and reversed lists to the screen in a human-readable format (i.e., nice to 
look at) and also separately to a file named `analysis.txt` in CSV format. Each time the program runs, it will append 
the timing results to `analysis.txt`. At the end of your run, your hash table should be completely empty.

## 4. **Graph and Analyze the Performance of the Sorting Algorithms**

Run your program several times for different number of lines of your dataset, N, by choosing different values of the
second command line argument. After several runs, your `analysis.txt` file will be filled with timing and comparison data.

Using your favorite graphing software (e.g., MS Excel or Google Sheets), plot the running time (in seconds) vs. N for 
each case. Take a screenshot of your graph and put them here by modifying this file, committing, and pushing
it to this repository.

Insertion, search, and deletion running time (already sorted):

<img width="592" alt="Screenshot 2024-12-03 at 12 01 36 PM" src="https://github.com/user-attachments/assets/b8194fc8-75b5-4d85-aa53-a5ab651bb538">




Insertion, search, and deletion running time (shuffled):

<img width="592" alt="Screenshot 2024-12-03 at 12 02 07 PM" src="https://github.com/user-attachments/assets/231e1f11-c49b-4c19-a99c-f9f4454e0bbe">



Insertion, search, and deletion running time (reversed):

<img width="592" alt="Screenshot 2024-12-03 at 12 02 23 PM" src="https://github.com/user-attachments/assets/3315af6b-1bf2-4aa8-981a-25be5910b15e">





## 5. **Document your Dataset and Results**
Document the source of your dataset and any modifications you made to it. Describe the results of your analysis and 
how it compares to the theoretical performance of the hash table operations.

Dataset Source: Jobs and Salaries in Data Science: https://www.kaggle.com/datasets/hummaamqaasim/jobs-in-data  

Dataset Modifications ("None" if unchanged): None

Result Analysis: 

Insertions: The data shows a linear increase in insertion time, especially for sorted datasets, suggesting bucket collisions or inefficiencies in the hash function.
Shuffled and reversed datasets perform better, likely due to more even key distribution.

Searches and Deletions: Both operations for shuffled and reversed data also exhibit slight growth with dataset size, deviating from the expected O(1) behavior. Both operations for sorted data seem to be O(1).

Some potential causes of linear growth:
Bucket Collisions: A suboptimal hash function or uneven key distribution leads to larger bucket sizes.
Implementation Overhead: Resizing operations or linked-list traversals within buckets contribute to the observed scaling.
Dataset Patterns: Sorted datasets exacerbate collisions, increasing traversal times.

While the hash table works as designed, its performance scales closer to O(N) in practice, particularly for larger, sorted datasets. Optimizing the hash function or increasing randomness in the data could improve alignment with theoretical expectations of O(1).

## Submission:

Your project will be developed and graded via GitHub. Your final "push" is your final submission, and it must occur
before it is due. On Canvas, enter the url to your Github repository. Your project will not be graded without it.

## Recommendations:

I ___strongly suggest___ that you carefully think through your strategy before just jumping into the code.  Once that
is working, start adding in new features individually.  A good place to start is building your class.

*In order to get full points of Commenting and Code Style, you need to add comments to every method and head comments
for each file (providing file description, author, date, and acknowledgement).

```
/∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗*
∗ @file: filename.java
∗ @description: This program implements . . .
∗ @author: Your Name
∗ @date: December 5, 2024
∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗/
```
