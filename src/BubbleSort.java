/**
 * Implementaton of Bubble Sort.
 * @author richard.stansbury
 */

public class BubbleSort {

    /**
     * Implements Bubble Sort on an array
     * @param data - array to sort
     */
    public static void BubbleSort(int [] data)
    {
        boolean swapped;

        //Multiple passes.
        for(int i = 0; i < data.length-1; i++) {

            //With each pass, compare each value with its neighbor
            // and switch its values.  Each pass results in the
            // smallest item being moved to the front.
            swapped = false;
            for (int j= data.length -1; j > i; --j) {

                //Compare i with the node to its left (i-1)
                if (data[j] < data[j-1]) {
                    swap(data, j, j-1); //Swap values
                    swapped = true;
                }
            }

            //If no swaps for an entire pass, then all values are in sorted order
            if (!swapped) return;
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
        BubbleSort.BubbleSort(arr);
        System.out.println(SortHelper.toArrayToString(arr));

        //Descending Test
        System.out.println("Descending Order Test");
        arr = SortHelper.getDescendingArray(size);
        System.out.println(SortHelper.toArrayToString(arr));
        BubbleSort.BubbleSort(arr);
        System.out.println(SortHelper.toArrayToString(arr));

        //Random Test
        System.out.println("Random Order Test");
        arr = SortHelper.getRandomArray(size);
        System.out.println(SortHelper.toArrayToString(arr));
        BubbleSort.BubbleSort(arr);
        System.out.println(SortHelper.toArrayToString(arr));


    }



}
