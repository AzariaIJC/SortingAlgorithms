/**
 * Implementaton of Selection Sort.
 * @author richard.stansbury
 */

public class SelectionSort {

    /**
     * An implementation of selection sort.
     * @param data - array to sort.
     */
    public static void SelectionSort(int [] data)
    {
        int smallest;

        //Selects the smallest item with each pass and places it in the
        // appropriate location in the sorted area of the array.
        // with each pass the sorted area grows by 1.
        for (int i=0; i < data.length-1; i++) {

            //Search for the smallest item in the unsorted region
            smallest = i;

            for (int j = i+1; j < data.length; j++) {
                if (data[j] < data[smallest]) {
                    smallest = j;
                }
            }

            //If the index i is not the same as the smallest, then
            // swap the smallest value with the value at i.
            if (smallest != i) {
                swap(data, i, smallest);
            }
        }
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

    public static void main(String [] args) {

        int [] arr;
        int size = 20;

        //Ascending Test
        System.out.println("Ascending Order Test");
        arr = SortHelper.getAscendingArray(size);
        System.out.println(SortHelper.toArrayToString(arr));
        SelectionSort.SelectionSort(arr);
        System.out.println(SortHelper.toArrayToString(arr));

        //Descending Test
        System.out.println("Descending Order Test");
        arr = SortHelper.getDescendingArray(size);
        System.out.println(SortHelper.toArrayToString(arr));
        SelectionSort.SelectionSort(arr);
        System.out.println(SortHelper.toArrayToString(arr));

        //Random Test
        System.out.println("Random Order Test");
        arr = SortHelper.getRandomArray(size);
        System.out.println(SortHelper.toArrayToString(arr));
        SelectionSort.SelectionSort(arr);
        System.out.println(SortHelper.toArrayToString(arr));


    }



}
