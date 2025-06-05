import java.util.Arrays; // for printing array

/**
 * A class to demonstrate minimum heap operations using arrays
 */
public class Realistic {

    /** Set up our test array. */
    static int[] arr = { 10, -5, 11, 2 };

    /**
     * Scan the entire array to find and remove its smallest value.
     * The method uses array arr[] created above.
     * 
     * @return int with the smallest value in array arr
     */
    public static int getSmallest() {
        // Assume smallest is first element
        int smallest_index = 0;
        // Scan the remaining elements, replacing the position of the smallest element
        // with the position of any element found to be smaller.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[smallest_index]) {
                // found new smallest, update index
                smallest_index = i;
            }
        }
        // When loop is done, smallest_index points to smallest element. Save it in a
        // variable so that we can return its value when we are done.
        int result = arr[smallest_index];
        // Prepare to shrink the processed array by one element, effectively removing
        // its smallest element. A temporary array will hold the remaining elements.
        int[] temporary = new int[arr.length - 1];

        /*
         * Use two loops to copy the elements of arr[] to temporary[], except for the
         * smallest element. The first loop copies all the elements before the smallest
         * element and the second loop the elements after it.
         * 
         * EXPLANATION OF THE LOOPS (per last week's assignment): the first loop copies
         * all the elements before the smallest element to the temporary array. To
         * insure it does not "touch" the smallest element, the index of the loop in in
         * the range
         * 0 ≤ i < smallest_index.
         * 
         * The second loop copies all the elements after the smallest element to the
         * temporary array. To ensure this loop doesn't touch the smallest element
         * either, its range is
         * smallest_index < i < arr.length
         * 
         * In the first loop temporary and principal array (arr) indices are
         * synchronized. In the second array, the temporary array index becomes i-1
         * while the principal array index remains i. The shift from temporary[i] in the
         * first loop to temporary[i-1] in the second loop is to avoid a gap due to
         * skipping the smallest element. Also the i-1 index in the second loop ensures
         * that the temporary array index will not get out of bounds.
         */
        for (int i = 0; i < smallest_index; i++) {
            temporary[i] = arr[i];
        }
        for (int i = smallest_index + 1; i < arr.length; i++) {
            temporary[i - 1] = arr[i];
        }
        // replace principal array with temporary array.
        arr = temporary;
        return result; // smallest element
    } // method getSmallest


    /**
     * 
     * 
     * Similar functionality as getSmallest(), but:
     * -Returns an Integer object
     * -Returns null if the array is empty
     * Modifies the array by removing the smallest element
     * 
     * @return Integer with the smallest element, or null if array is empty
     * 
     */

     public static Integer remove() {
        // If array is empty, nothing to remove so return null
        if (arr.length == 0) {
            return null;
        }

        // Assume smallest element is the start
        int smallest_index = 0;

        // Loop through to find index of smallest
        for(int i = 1; i < arr.length; i++) {

            if (arr[i] < arr[smallest_index]) {
                smallest_index = i;
            }
        }

        // Save smallest element into variable to return later
        int smallestValue = arr[smallest_index];
        // Create a new array that will be one element smaller
        int[] temporary = new int[arr.length - 1];

        //Copy all elements before the smallest into temporary array

        for(int i = 0; i < smallest_index; i++) {

            temporary[i] = arr[i];
        }

        //Copy all elements after smalelst into temporary array, and shifting them all left by one to close gap

        for(int i = smallest_index; i < arr.length; i++) {
            temporary[i - 1] = arr[i];
        }
        
        //Replace original array with the new one
        arr = temporary;

        //Return smallest value
        return smallestValue; //to type Integer

     }

    /**
     * Adds a new element to the end of the principal array arr after it resizes up
     * to accomodate the new element.
     * 
     * @param value int to add to the array
     */
    public static void add(int value) {
        // Create a larger temporary array
        int[] temporary = new int[arr.length + 1];
        // Copy the principal array to the temporary one
        for (int i = 0; i < arr.length; i++) {
            temporary[i] = arr[i];
        }
        // Place the new value to the end of the temporary array.
        temporary[arr.length] = value;
        // Replace principal array with temporary array and we are done
        arr = temporary;
    } // method add

    /** Driver/simple test code */
    public static void main(String[] args) {
        System.out.printf("\n\nArray before removal of smallest element: %s",
                Arrays.toString(arr));

        //Call new remove method in main
        //Will return null if array is empty

        Integer removed = remove();

        // Checks if value was actually removed
        // If it was than output the removed element

        if (removed != null) {
            System.out.printf("\nRemoved element: %d", removed);
        } else {
            System.out.println("\nArray was empty");
        }

    


    } // method main
} // class Realistic