package SortingAlgorithms;

import org.junit.Test;

import java.util.Random;
import java.util.Arrays;
public class QuickSort {
    public int[] quickSort(int[] array) {
        // Write your solution here
        quicksort(array, 0, array.length-1);
        return array;
    }

    public void quicksort(int[] array, int left, int right){
        if (left < right){ //at least a pair that needs to be looked into
            int pivot = array[(left+right)/2];
            System.out.println("pivot=" + pivot);
            int sortStart = arrange(array,left,right,pivot);
            System.out.println("sortStart="+sortStart);
            quicksort(array,left,sortStart-1);
            quicksort(array,sortStart,right);
        }
    }
    public int arrange(int[] array, int left, int right, int pivot){
        int temp; //used for swap
        while(left <= right) { //if there are elements needs to be looked at
            while(array[left] < pivot) {
                left++; //if the element is in the right place, move to the next
            }
            while (array[right] > pivot) {
                right--;
            }
            //left and right stops when current one out of order
            while (left <= right){ //confirm that out of order items are acutal
                temp = array[left]; array[left] = array[right]; array[right] = temp; //swap
                left++; right--; //look at the next pair
            }

        }

        return left; //can return right too
    }

    @Test
    public void testQuickSort(){

        int[] input = {1,4,5,7,9,8,6,2,3,4,5,7,9,8,3,2};
        System.out.println(Arrays.toString(quickSort(input)));
    }
}
