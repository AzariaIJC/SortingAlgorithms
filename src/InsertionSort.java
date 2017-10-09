/**
 * Implementaton of Insertion Sort.
 * @author richard.stansbury
 */
public class InsertionSort {



    /**
     * Performs insertion sort on an array
     * @param data - array to sort.
     */
    public static void InsertionSort(int [] data)
    {
        for (int i=1; i < data.length; i++) {

            //Set aside the value we wish to insert.
            int tmp = data[i];

            //Insert the value into its place in the sorted
            // portion of the array by shifting items over
            // to the right.
            int j;
            for (j = i; j > 0 && (tmp < data[j-1]); j--) {
                data[j] = data[j -1];
            }

            //Insert the value at its new location.
            data[j] = tmp;

        }
    }



    public static void main(String [] args) {

        int [] arr;
        int size = 20;

        //Ascending Test
        System.out.println("Ascending Order Test");
        arr = SortHelper.getAscendingArray(size);
        System.out.println(SortHelper.toArrayToString(arr));
        InsertionSort.InsertionSort(arr);
        System.out.println(SortHelper.toArrayToString(arr));

        //Descending Test
        System.out.println("Descending Order Test");
        arr = SortHelper.getDescendingArray(size);
        System.out.println(SortHelper.toArrayToString(arr));
        InsertionSort.InsertionSort(arr);
        System.out.println(SortHelper.toArrayToString(arr));

        //Random Test
        System.out.println("Random Order Test");
        arr = SortHelper.getRandomArray(size);
        System.out.println(SortHelper.toArrayToString(arr));
        InsertionSort.InsertionSort(arr);
        System.out.println(SortHelper.toArrayToString(arr));


    }



}
