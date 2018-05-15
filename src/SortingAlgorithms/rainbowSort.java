package SortingAlgorithms;

import org.junit.Test;

public class rainbowSort {
    public void rainbowSort(int[] array,int left,int right){
        if (left < right){ //at least a pair that needs to be looked into
            int pivot = array[(left+right)/2];
            System.out.println("pivot=" + pivot);
            int sortStart = arrange(array,left,right,pivot);
            System.out.println("sortStart="+sortStart);
            rainbowSort(array,left,sortStart-1);
            rainbowSort(array,sortStart,right);
        }
    }

    public int arrange(int[] array, int left, int right, int pivot){
        int temp; //used for swap
        while(left <= right) { //if there are elements needs to be looked at
            while(array[left] <= pivot) {
                left++; //if the element is in the right place, move to the next
            }
            while (array[right] >= pivot) {
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
    public void testRainbowSort(){
        int[] array={1,1,1,4,4,4,5,5,3,3,3,2,2,7,7,7,9};
        rainbowSort(array,0,array.length);
        System.out.println(array);
    }

}
