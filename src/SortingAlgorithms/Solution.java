package SortingAlgorithms;

import org.junit.Test;

import java.util.Arrays;

public class Solution {


    public int[] moveZero(int[] array) {
        // Write your solution here
        int left = 0; int right = array.length-1;
        while (left < right) {
            if ( array[left] == 0 && array[right]!=0) {
                swap(array, left, right);
                left++; right--;
            }
            else if ( array[left] == 0 && array[right]==0 ) {
                right--;
            }
            else {
                left++;
            }
        }
        return array;
    }

    public void swap(int[] array, int i, int j){
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    @Test
    public void testMoveZero(){
        int [] input = {1,2,3,0,0,3,3,1};
        System.out.println(Arrays.toString(moveZero(input)));
    }
}