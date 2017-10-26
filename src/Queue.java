/**
 * Array-based list queue
 */

public class Queue {


    //Class Variables
    private int [] arr;  //Array to store the data.
    private int count; //number of elements in the queue.
    private int front; //Index of front of queue
    private int back; //Index of back of queue.



    public Queue(int size) {
        arr = new int[size];
        count = 0;
        front = 0;
        back = size - 1;
    }



    /**
     * Adss a new value to the back of the queue.
     * @param value - value to be added.
     */
    public void enqueue(int value)
    {
        if (isFull()) {
            System.out.println("Cannot enqueue.  Queue is full.");
            return;
        }


        //Add item to back of queue.
        back = (back + 1) % arr.length;
        arr[back] = value;
        count++;
    }


    /**
     * Returns the value from the front of queue and removes it from the queue.
     * @return value removed from front of queue.
     */
    public int dequeue()
    {
        if (isEmpty()) {
            System.out.println("Cannot deueue.  Queue is empty.");
            return -1;
        }

        //Remove a value from the front of the queue.  Then return its value.

        int value = arr[front];
        front = (front + 1) % arr.length;
        count--;
        return value;
    }


    /**
     * Returns the value of the front element of the queue.
     * @return value of the front element of the queue.
     */
    public int front()
    {
        if (isEmpty()) {
            System.out.println("Cannot return front.  Queue is empty.");
            return -1;
        }

        return arr[front];
    }


    /**
     * @return true if empty.  False otherwise.
     */
    public boolean isEmpty()
    {
        return (count == 0);
    }

    /**
     * @return true if full, false otherwise.
     */
    public boolean isFull()
    {
        return (count == arr.length);
    }

}