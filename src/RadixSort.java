/**
 * Implementaton of Radix Sort.
 * @author richard.stansbury
 */

public class RadixSort {

    public static final int radix = 10;
    public static final int digits = 10;
    public static final int bits = 31;

    /**
     * Implements radix on an array
     * @param data - array to sort
     */
    public static void RadixSort(int [] data)
    {

        int d, j, k, factor;
        Queue[] queues = new Queue[radix]; // radix is 10;
        for (d = 0; d < radix; d++)
            queues[d] = new Queue(data.length);

        for (d = 1, factor = 1; d <= digits; factor *= radix, d++) {
            //Place in buckets
            for (j = 0; j < data.length; j++)
                queues[(data[j] / factor) % radix].enqueue(data[j]);
            //Merge buckets
            for (j = k = 0; j < radix; j++)
                while (!queues[j].isEmpty())
                    data[k++] = queues[j].dequeue();
        }
    }



    public static void main(String [] args) {

        int [] arr;
        int size = 20;

        //Ascending Test
        System.out.println("Ascending Order Test");
        arr = SortHelper.getAscendingArray(size);
        System.out.println(SortHelper.toArrayToString(arr));
        RadixSort.RadixSort(arr);
        System.out.println(SortHelper.toArrayToString(arr));

        //Descending Test
        System.out.println("Descending Order Test");
        arr = SortHelper.getDescendingArray(size);
        System.out.println(SortHelper.toArrayToString(arr));
        RadixSort.RadixSort(arr);
        System.out.println(SortHelper.toArrayToString(arr));

        //Random Test
        System.out.println("Random Order Test");
        arr = SortHelper.getRandomArray(size);
        System.out.println(SortHelper.toArrayToString(arr));
        RadixSort.RadixSort(arr);
        System.out.println(SortHelper.toArrayToString(arr));


    }



}
