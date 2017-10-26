/**
 * Implementaton of Merge Sort.
 * @author richard.stansbury
 */

public class MergeSort {

    /**
     * Kicks off mergesort algorithm for a given array
     * @param data - array to sort
     */
    public static void MergeSort(int [] data)
    {
       MergeSort(data,0, data.length-1);
    }

    /**
     * Recursive function for merge sort
     * @param data - array to sort
     * @param first - index of first element of subarray
     * @param last - index of last element of subarray
     */
    public static void MergeSort(int [] data, int first, int last)
    {
        if (first < last) {
            int mid = (first+last)/2;

            //Recurse on left and right side
            MergeSort(data, first, mid);
            MergeSort(data, mid+1, last);

            //Merge left and right side
            Merge(data, first, mid, last);
        }
    }


    /**
     * Merges left and right subarrays
     * @param data - data array
     * @param first - left subarray start index
     * @param mid - middle index
     * @param last - right subarray end index
     */
    public static void Merge(int [] data, int first, int mid, int last)
    {

        //Determine size of left side and right side
        int numLeft = mid - first + 1;
        int numRight = last - mid;


        //Generate left and right temp arrays
        int [] left = new int[numLeft];
        System.arraycopy(data,first,left,0, numLeft);

        //Generate right temporary array
        int [] right = new int[numRight];
        System.arraycopy(data,mid+1,right, 0, numRight);


        //Set up indices
        int leftIndex =  0;
        int rightIndex = 0;
        int mergeIndex = first;

        //Loop comparing next unsorted from left and right temporary array
        // and copy the lowest of the two into the sorted array
        while ((leftIndex < numLeft) && (rightIndex < numRight)){

            //Left value is smaller than right value
            if (left[leftIndex] <= right[rightIndex]) {
                data[mergeIndex] = left[leftIndex];
                leftIndex++;
            }

            //Right value is smaller than left
            else {
                data[mergeIndex] = right[rightIndex];
                rightIndex++;
            }

            //Increment index in data array for next merge item
            mergeIndex++;

        }

        //Clear out left side (if any remaining)
        while (leftIndex < numLeft) {
            data[mergeIndex] = left[leftIndex];
            leftIndex++;
            mergeIndex++;
        }

        //Copy over right side (if any remaining)
        while (rightIndex < numRight) {
            data[mergeIndex] = right[rightIndex];
            rightIndex++;
            mergeIndex++;
        }

    }

    public static void main(String [] args) {

        int [] arr;
        int size = 20;

        //Ascending Test
        System.out.println("Ascending Order Test");
        arr = SortHelper.getAscendingArray(size);
        System.out.println(SortHelper.toArrayToString(arr));
        MergeSort.MergeSort(arr);
        System.out.println(SortHelper.toArrayToString(arr));

        //Descending Test
        System.out.println("Descending Order Test");
        arr = SortHelper.getDescendingArray(size);
        System.out.println(SortHelper.toArrayToString(arr));
        MergeSort.MergeSort(arr);
        System.out.println(SortHelper.toArrayToString(arr));

        //Random Test
        System.out.println("Random Order Test");
        arr = SortHelper.getRandomArray(size);
        System.out.println(SortHelper.toArrayToString(arr));
        MergeSort.MergeSort(arr);
        System.out.println(SortHelper.toArrayToString(arr));


    }



}
