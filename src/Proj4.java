/****************************************************************************************
 * @file: Proj4.java
 * @description: This program analyzes the performance of a separate chaining hash table
 *          using job data. It reads data from a file, creates sorted,
 *          shuffled, and reversed lists of the data, then measures and compares
 *          the time taken for insert, search, and delete operations on each list.
 *          Results are displayed to console and saved to analysis.txt in CSV format.
 * @author: Max Finegan
 * @date: December 3, 2024
 ****************************************************************************************/




import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Proj4 {
    public static void main(String[] args) throws IOException {
        // Use command line arguments to specify the input file
        if (args.length != 2) {
            System.err.println("Usage: java Proj4 <input file> <number of lines>");
            System.exit(1);
        }

        String inputFileName = args[0];
        int numLines = Integer.parseInt(args[1]);

        // For file input
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        // Open the input file
        inputFileNameStream = new FileInputStream(inputFileName);
        inputFileNameScanner = new Scanner(inputFileNameStream);

        // ignore first line
        inputFileNameScanner.nextLine();

        // FINISH ME

        ArrayList<Job> jobs = new ArrayList<>();

        // All variables for a job object
        Integer workYear;
        String jobTitle;
        String jobCategory;
        String salaryCurrency;
        Integer salary;
        Integer salaryInUSD;
        String employeeResidence;
        String experienceLevel;
        String employmentType;
        String workSetting;
        String companyLocation;
        String companySize;

        String currLine;
        String[] parts;

        // Loop through the csv and make a new Job object out of each line
        for (int i = 0; i < numLines; i++) {
            currLine = inputFileNameScanner.nextLine(); // Get the current line

            parts = currLine.split(","); // Split the current line by commas

            // Create a new Job object with parsed data
            workYear = Integer.parseInt(parts[0]);
            jobTitle = parts[1];
            jobCategory = parts[2];
            salaryCurrency = parts[3];
            salary = Integer.parseInt(parts[4]);
            salaryInUSD = Integer.parseInt(parts[5]);
            employeeResidence = parts[6];
            experienceLevel = parts[7];
            employmentType = parts[8];
            workSetting = parts[9];
            companyLocation = parts[10];
            companySize = parts[11];

            // Add the Job to the ArrayList
            jobs.add(new Job(workYear, jobTitle, jobCategory, salaryCurrency, salary, salaryInUSD,
                    employeeResidence, experienceLevel, employmentType, workSetting, companyLocation, companySize));

        }

        // Sort the ArrayList
        ArrayList<Job> sortedJobs = new ArrayList<>(jobs);
        Collections.sort(sortedJobs);


        // Shuffle the ArrayList
        ArrayList<Job> shuffledJobs = new ArrayList<>(jobs);
        Collections.shuffle(shuffledJobs);


        // Reverse the ArrayList
        ArrayList<Job> reversedJobs = new ArrayList<>(jobs);
        Collections.sort(reversedJobs, Collections.reverseOrder());



        // Initialize the hash table
        SeparateChainingHashTable<Job> hashTable = new SeparateChainingHashTable<>();

        // File to write analysis results
        try (FileOutputStream fos = new FileOutputStream("src/analysis.txt", true); // Append mode
             PrintWriter writer = new PrintWriter(fos)) {

            // Perform operations on each dataset type
            System.out.println("Processing datasets...");
            performOperations(hashTable, sortedJobs, writer, "Sorted", numLines);
            performOperations(hashTable, shuffledJobs, writer, "Shuffled", numLines);
            performOperations(hashTable, reversedJobs, writer, "Reversed", numLines);
        }



    }



    // Perform insert, search, and delete operations on the hash table and measure their performance
    private static void performOperations(SeparateChainingHashTable<Job> hashTable, ArrayList<Job> dataset,
                                          PrintWriter writer, String listType, int numLines) {
        long startTime;
        long endTime;

        System.out.printf("Processing %s dataset with %d lines...%n", listType, numLines);

        // Insert
        startTime = System.nanoTime();
        for (Job j : dataset) {
            hashTable.insert(j);
        }
        endTime = System.nanoTime();
        double insertTime = (endTime - startTime) / 1e9; // Convert to seconds

        // Search
        startTime = System.nanoTime();
        for (Job j : dataset) {
            hashTable.contains(j);
        }
        endTime = System.nanoTime();
        double searchTime = (endTime - startTime) / 1e9; // Convert to seconds

        // Delete
        startTime = System.nanoTime();
        for (Job j : dataset) {
            hashTable.remove(j);
        }
        endTime = System.nanoTime();
        double deleteTime = (endTime - startTime) / 1e9; // Convert to seconds

        // Print results to the console
        System.out.printf("Results for %s dataset:%n", listType);
        System.out.printf("Insert Time: %.6f seconds%n", insertTime);
        System.out.printf("Search Time: %.6f seconds%n", searchTime);
        System.out.printf("Delete Time: %.6f seconds%n%n", deleteTime);

        // Write results to the analysis file
        writer.printf("%s,%d,%.6f,%.6f,%.6f%n", listType, numLines, insertTime, searchTime, deleteTime);
        writer.flush();
    }



}
