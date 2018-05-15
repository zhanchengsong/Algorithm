import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KSmallest {

    public static int[] KSmallest(int[] array, int k){
        if (array.length == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[k];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) { //Higher priority -> negative
                if (o1 < o2) return 1;
                else if (o1.equals(o2)) return 0;
                else return -1;

            }
        });
        for (int i = 0 ; i < array.length; i ++){
            if (i < k) {
                // utilize the maxHeap so it would always maintainn priority
                // AKA, the one with higher priority,will go out the first
                // maxHeap will rearrange the orders so that it will have
                // Lower Value of Priority ->(In) [, , ,] -> Higher Value of Priority (Out)
                // Since we used the maxHeap, larger value have higher prioirty and will go out first
                System.out.println("Offer " + array[i] + " into maxHeap");
                maxHeap.offer(array[i]);
            }
            else if (array[i] < maxHeap.peek()){ // Look at the largest one within the maxHeap, if current value is smaller
                System.out.println("Peek at " + maxHeap.peek() + " and current value is " + array[i]);
                maxHeap.poll(); // Get out the largest value
                maxHeap.offer(array[i]); // put in the current value
            }
        }

        for (int i = 0; i < k; i++){
            result[i] = maxHeap.poll();
        }

        return result;

    }
    @Test
    public void testPQ (){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) return 1;
                else if (o1 < o2) return -1;
                else return 0;
            }
        });

        maxHeap.offer(6);
        maxHeap.offer(5);
        maxHeap.offer(4);
        maxHeap.offer(3);
        maxHeap.offer(2);
        maxHeap.offer(1);

        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }

    @Test
    public void TestKSmallest(){
        int[] input = {1,4,5,3,2,9,10};
        int[] output = KSmallest.KSmallest(input,7);

        for (int i : output) {
            System.out.println(i);
        }
    }

}


