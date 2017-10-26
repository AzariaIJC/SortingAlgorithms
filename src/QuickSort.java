/**
 * Implementaton of Quick Sort.
 * @author richard.stansbury
 */

public class QuickSort {

    /**
     * Kicks off quickesort algorithm for a given array
     * @param data - array to sort
     */
    public static void QuickSort(int [] data)
    {
       QuickSort(data,0, data.length-1);
    }


    /**
     * Recursive function for quick sort
     * @param data - array to sort
     * @param first - index of first element of subarray
     * @param last - index of last element of subarray
     */
    public static void QuickSort(int [] data, int first, int last)
    {
        if (first < last) {
            int mid = (first+last)/2;

            //Find pivot using Median of 3
            int pivot = getPivot(data, first, last);

            //Partition left and right side based on pivot value
            pivot = partition(data, first, pivot, last);

            //Recurse on left and right side
            QuickSort(data, first, pivot);
            QuickSort(data, pivot+1, last);

        }
    }
    /**
     * Returns the median of three pivot for the array
     * @param data - array to sort
     * @param first - first index
     * @param last - last index
     * @return index of median
     */
    public static int getPivot(int [] data, int first, int last)
    {
        int mid = (first + last)/2;

        if (data[first] > data[mid]) {
            swap(data, first, mid);
        }

        if (data[first] > data[last]) {
            swap(data, first, last);
        }

        if (data[mid] > data[last]) {
            swap(data, mid, last);
        }

        return mid;
    }

    /**
     * Divides subarray into two regions.  Left side has a value less than pivot location value.
     * Right side has a value greater than pivot locaiton value
     *
     * @param data - array to sort
     * @param first - index of first element of subarray
     * @param pivot - index of pivot
     * @param last - index of last element of subarray
     * @return new location of pivot
     */
    public static int partition(int [] data, int first, int pivot, int last)
    {

        int pivotVal = data[pivot]; //Get pivot value

        int lastS1 = first; //initialize index for S1 (left side)

        swap(data,pivot,first); //Move pivot to first location so it is not misplaced

        //Traverse array moving each unknown value into the left region if less than pivot value.
        for (int firstUnknown = first;
                firstUnknown <= last;
                firstUnknown++) {

            if (data[firstUnknown] < pivotVal) {
                lastS1++;
                swap(data,firstUnknown, lastS1);
            }

        }

        //Move the pivot into the index between the left and right
        // regions
        swap(data,first,lastS1);
        return lastS1; //new Pivot
    }

    /**
     * Swaps the values within an array between two indices (indexX and indexY
     * @param data - array (pass by reference)
     * @param indexX - first index
     * @param indexY - second index
     */
    public static void swap(int [] data, int indexX, int indexY) {
        int tmp = data[indexX];
        data[indexX] = data[indexY];
        data[indexY] = tmp;
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
        int size = 100;

        //Ascending Test
        System.out.println("Ascending Order Test");
        arr = SortHelper.getAscendingArray(size);
        System.out.println(SortHelper.toArrayToString(arr));
        QuickSort.QuickSort(arr);
        System.out.println(SortHelper.toArrayToString(arr));

        //Descending Test
        System.out.println("Descending Order Test");
        arr = SortHelper.getDescendingArray(size);
        System.out.println(SortHelper.toArrayToString(arr));
        QuickSort.QuickSort(arr);
        System.out.println(SortHelper.toArrayToString(arr));

        //Random Test
        System.out.println("Random Order Test");
        arr = SortHelper.getRandomArray(size);
        System.out.println(SortHelper.toArrayToString(arr));
        QuickSort.QuickSort(arr);
        System.out.println(SortHelper.toArrayToString(arr));


    }



}
