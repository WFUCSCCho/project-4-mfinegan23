/*******************************************************
 * @file: SeparateChainingHashTable.java
 * @description: This program implements a hash table using
 *               separate chaining for collision handling.
 *               It supports operations such as insert, remove,
 *               search, and making the table empty.
 *               Rehashing is performed when the load factor
 *               exceeds the capacity.
 * @author: Max Finegan
 * @date: December 3, 2024
 *******************************************************/




import java.util.LinkedList;
import java.util.List;

// SeparateChaining Hash table class
//
// CONSTRUCTION: an approximate initial size or default of 101
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// boolean contains( x )  --> Return true if x is present
// void makeEmpty( )      --> Remove all items

public class SeparateChainingHashTable<AnyType> {
    /**
     * Construct the hash table.
     */
    public SeparateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    /**
     * Construct the hash table.
     *
     * @param size approximate table size.
     */
    public SeparateChainingHashTable(int size) {
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++)
            theLists[i] = new LinkedList<>();
    }

    /**
     * Insert into the hash table. If the item is
     * already present, then do nothing. Rehash if
     * the insertion exceeds the table size.
     *
     * @param x the item to insert.
     */
    public void insert(AnyType x) {
        // FINISH ME

        // Find the right list for the element
        List<AnyType> whichList = theLists[myhash(x)];
        // Add the element if it's not already there
        if (!whichList.contains(x)) {
            whichList.add(x);
            currentSize++;

            // Rehash if the number of elements exceeds the table size
            if (currentSize > theLists.length)
                rehash();
        }
    }

    /**
     * Remove from the hash table.
     *
     * @param x the item to remove.
     */
    public void remove(AnyType x) {
        // FINISH ME

        // Find the right list for the element
        List<AnyType> whichList = theLists[myhash(x)];
        // Remove the element if it's present
        if (whichList.contains(x)) {
            whichList.remove(x);
            currentSize--;
        }
    }

    /**
     * Find an item in the hash table.
     *
     * @param x the item to search for.
     * @return true if x is not found.
     */
    public boolean contains(AnyType x) {
        // FINISH ME

        // Find the right list and check for the element
        List<AnyType> whichList = theLists[myhash(x)];
        return whichList.contains(x);
    }

    /**
     * Make the hash table logically empty.
     */
    public void makeEmpty() {
        // FINISH ME

        // Clear each list in the hash table
        for (int i = 0; i < theLists.length; i++) {
            theLists[i].clear();
        }
        currentSize = 0;
    }

    /**
     * A hash routine for String objects.
     *
     * @param key       the String to hash.
     * @param tableSize the size of the hash table.
     * @return the hash value.
     */
    public static int hash(String key, int tableSize) {
        int hashVal = 0;

        for (int i = 0; i < key.length(); i++)
            hashVal = 37 * hashVal + key.charAt(i);

        hashVal %= tableSize;
        if (hashVal < 0)
            hashVal += tableSize;

        return hashVal;
    }

    private void rehash() {
        // FINISH ME

        // Save the current hash table
        List<AnyType>[] oldLists = theLists;

        // Create a new table with double the size
        theLists = new LinkedList[nextPrime(2 * theLists.length)];
        for (int i = 0; i < theLists.length; i++)
            theLists[i] = new LinkedList<>();

        // Reset the current size and reinsert all elements
        currentSize = 0;
        for (List<AnyType> list : oldLists) {
            for (AnyType item : list)
                insert(item);
        }
    }

    private int myhash(AnyType x) {
        int hashVal = x.hashCode();

        hashVal %= theLists.length;
        if (hashVal < 0)
            hashVal += theLists.length;

        return hashVal;
    }

    private static final int DEFAULT_TABLE_SIZE = 101;

    /**
     * The array of Lists.
     */
    private List<AnyType>[] theLists;
    private int currentSize;

    /**
     * Internal method to find a prime number at least as large as n.
     *
     * @param n the starting number (must be positive).
     * @return a prime number larger than or equal to n.
     */
    private static int nextPrime(int n) {
        if (n % 2 == 0)
            n++;

        for (; !isPrime(n); n += 2)
            ;

        return n;
    }

    /**
     * Internal method to test if a number is prime.
     * Not an efficient algorithm.
     *
     * @param n the number to test.
     * @return the result of the test.
     */
    private static boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;

        if (n == 1 || n % 2 == 0)
            return false;

        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;

        return true;
    }

}


