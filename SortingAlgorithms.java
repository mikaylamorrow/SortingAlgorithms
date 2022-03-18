package SortingAlgorithms;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class SortingAlgorithms {

    public static void main(String[] args) {
        System.out.println("Please enter the size of your file:");

        Scanner input = new Scanner(System.in);
        int listSize = input.nextInt();

        int[] array = new int[listSize];
        Random rand = new Random();

        for (int i = 0; i < listSize; i++) {
            array[i] = rand.nextInt(1000);
        }

        Instant start = Instant.now();
        BubbleSort(array.clone());
        Instant finish = Instant.now();
        System.out.println("BubbleSort Time is: "+ Duration.between(start, finish).toMillis());
  
        start = Instant.now();
        SCBubbleSort(array.clone());
        finish = Instant.now();
        System.out.println("SC BubbleSort Time is: "+ Duration.between(start, finish).toMillis());

        start = Instant.now();
        selectionSort(array.clone());
        finish = Instant.now();
        System.out.println("SelectionSort Time is: " + Duration.between(start, finish).toMillis());

        start = Instant.now();
        insertionSort(array.clone());
        finish = Instant.now();
        System.out.println("InsertionSort Time is: " + Duration.between(start, finish).toMillis());

        start = Instant.now();
        mergeSort(array.clone());
        finish = Instant.now();
        System.out.println("MergeSort Time is: " + Duration.between(start, finish).toMillis());

        start = Instant.now();
        quickSort(array.clone(), 0, array.length - 1);
        finish = Instant.now();
        System.out.println("QuickSort Time is: " + Duration.between(start, finish).toMillis());
    }

    public static void BubbleSort(int[] array) {
        long count = 0;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    count++;
                }
            }
        }
    }

    public static void SCBubbleSort(int[] array) {
        long count = 0;

        for (int i = 0; i < array.length; i++) {
            boolean swap = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    count++;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

    public static void selectionSort(int[] array) {
        long count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
                count++;
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void insertionSort(int arr[]) {
        int i, key, j;
        long count = 0;
        for (i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                count++;
            }
            arr[j + 1] = key;

        }
        
    }

    public static void mergeSort(int[] array) {

        if (array.length < 2) {
            return;
        }

        int mid = array.length / 2;
        int[] l = new int[mid];
        int[] r = new int[array.length - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = array[i];
        }

        for (int i = mid; i < array.length; i++) {
            r[i - mid] = array[i];
        }

        mergeSort(l);
        mergeSort(r);
        merge(array, l, r, mid, array.length - mid);

    }

    public static void merge(int[] array, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                array[k] = l[i];
                i++;
            } else {
                array[k] = r[j];
                j++;
            }
            k++;
        }
        while (i < left) {
            array[k++] = l[i++];
        }
        while (j < right) {
            array[k++] = r[j++];
        }

    }

    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }

}
