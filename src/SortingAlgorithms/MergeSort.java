package SortingAlgorithms;

import org.junit.Test;

import java.util.Arrays;

public class MergeSort {

    @Test
    public void testMerge(){
        int[] arr = {1,3,5,7,9,2,4,6,8,10,12};
        System.out.println("Original " + Arrays.toString(arr));
        int m = arr.length /2;
        int[] r = merge(Arrays.copyOfRange(arr,0,m), Arrays.copyOfRange(arr,m,arr.length) );

        System.out.println("Merged " + Arrays.toString(r));
    }

    @Test
    public void testmergeSort() {
        int[] arr = {7,6,5,4,3,2,1,0};
        int [] r = mergeSort(arr );
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(r));

    }

    public int[] mergeSort(int[] array) {
        // Write your solution here
        //Actual recursive function
        int m = array.length / 2;
        if (array.length > 1){ // if more than single element in array, sort and merge halves
            int[] left = mergeSort(Arrays.copyOfRange(array,0,m));

            int[] right = mergeSort(Arrays.copyOfRange(array,m,array.length));

            return merge(left,right);
        }
        else { // if only one element in array, return itself
            return array;
        }
    }

    public int [] merge(int[] l, int[] r) {
        int[] ret = new int[l.length + r.length]; //array to store the result
        int i = 0; int j = 0; int k = 0; //Index into each array for looping
        //Merge the intersection
        while ( i< l.length && j < r.length){
            if ( l[i] < r[j]) {
                ret[k] = l[i];
                i++;
            }
            else {
                ret[k] = r[j];
                j++;
            }
            k++;
        }
        //Copy of the remaning part of each half
        while ( i < l.length) {
            ret[k] = l[i];
            i++;k++;
        }
        while ( j< r.length) {
            ret[k] = r[j];
            j++;k++;
        }
        return ret;
    }


}


