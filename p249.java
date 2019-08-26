/**
 * @author Rubén Saiz
 */
package p249;

import java.util.Scanner;

public class p249 {

    static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left+right)/2;
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
    }

    static void merge(int[] array, int left, int mid, int right) {
        // calculating lengths
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        // creating temporary subarrays
        int leftArray[] = new int [lengthLeft];
        int rightArray[] = new int [lengthRight];

        // copying our sorted subarrays into temporaries
        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = array[left+i];
        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = array[mid+i+1];

        // iterators containing current index of temp subarrays
        int leftIndex = 0;
        int rightIndex = 0;

        // copying from leftArray and rightArray back into array
        for (int i = left; i < right + 1; i++) {
            // if there are still uncopied elements in R and L, copy minimum of the two
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            // if all the elements have been copied from rightArray, copy the rest of leftArray
            else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            // if all the elements have been copied from leftArray, copy the rest of rightArray
            else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

    final static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        int burros, result, n, casos = s.nextInt();
        int[] arr = new int[1_000_000];

        for (int i = 0; i < casos; i++) {

            burros = s.nextInt();
            n = s.nextInt();

            result = 0;

            for (int j = 0; j < n; j++) arr[j] = s.nextInt();
            mergeSort( arr, 0, n-1);

            for (int j = 0; j < n-1; j++) {
                if (arr[j] == arr[j+1]) { result++; j++; }
            }

            System.out.println( Math.min(result, burros) );
        }

    }

}
