package algorithm;

public class Sort {

    long executionTime = 0;
	/*
	 * Please implement all the sorting algorithm. Feel free to add helper methods.
	 * Store all the sorted data into one of the databases.
	 */


    public int[] selectionSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;

        for(int j=0; j<array.length-1; j++){
            int min = j;
            for(int i=j+1; i<array.length; i++) {
                if (array[i] < array[min])
                    min = i;
            }

            int temp = array[min];
            array[min] = array[j];
            array[j] = temp;
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] insertionSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;
        //implement here

        int n = list.length;
        for (int i = 1; i < n; ++i) {
            int ex = list[i];
            int j = i - 1;

            while (j >= 0 && list[j] > ex) {
                list[j + 1] = list[j];
                j = j - 1;
            }
            list[j + 1] = ex;
        }



        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] bubbleSort(int[] array) {
            final long startTime = System.currentTimeMillis();
            int[] list = array;
            //implement here

            int n = list.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (list[j] > list[j + 1]) {
                        int temp = list[j];
                        list[j] = list[j + 1];
                        list[j + 1] = temp;
                    }
                }
            }

            final long endTime = System.currentTimeMillis();
            final long executionTime = endTime - startTime;
            this.executionTime = executionTime;
        return list;
    }



    public void merge(int list[], int a, int b, int c) {
        int z = b - a + 1;
        int y = c - b;

        int[] left = new int[z];
        int[] right = new int[y];

        for (int i = 0; i < z; ++i) {
            left[i] = list[a + i];
        }
        for (int j = 0; j < y; ++j) {
            right[j] = list[b + 1 + j];
        }
        int i = 0, j = 0;

        int k = a;
        while (i < z && j < y) {
            if (left[i] <= right[j]) {
                list[k] = left[i];
                i++;
            } else {
                list[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < z) {
            list[k] = left[i];
            i++;
            k++;
        }

        while (j < y) {
            list[k] = right[j];
            j++;
            k++;
        }
    }

    public int[] mergeSort(int[] array, int a, int b) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        //implement here

        if (a < b) {

            int c = (a + b) / 2;

            mergeSort(list, a, c);
            mergeSort(list, c + 1, b);

            merge(list, a, c, b);
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }


    int partition(int list[], int low, int high) {
        int pivot = list[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (list[j] <= pivot) {
                i++;
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
        int temp = list[i + 1];
        list[i + 1] = list[high];
        list[high] = temp;

        return i + 1;
    }

    public int[] quickSort(int[] array, int a, int b) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        //implement here

        if (a < b) {

            int pi = partition(list, a, b);

            quickSort(list, a, pi - 1);
            quickSort(list, pi + 1, b);
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    void heap(int list[], int a, int i) {
        int largest = i;
        int b = 2 * i + 1;
        int c = 2 * i + 2;

        if (b < a && list[b] > list[largest])
            largest = b;


        if (c < a && list[c] > list[largest])
            largest = c;

        if (largest != i) {
            int swap = list[i];
            list[i] = list[largest];
            list[largest] = swap;

            heap(list, a, largest);
        }
    }

    public int[] heapSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        //implement here
        int n = list.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heap(list, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;

            heap(list, i, 0);
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }


    public int[] bucketSort(int[] array, int maxValue) {
        final long startTime = System.currentTimeMillis();
        //implement here

        int[] bucket = new int[maxValue + 1];
        int[] sortedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            bucket[array[i]]++;
        }
        int v = 0;
        for (int i = 0; i < bucket.length; i++)
            for (int j = 0; j < bucket[i]; j++)
                sortedArray[v++] = i;


        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return sortedArray;
    }

    public int[] shellSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        //implement here
        int n = list.length;

        for (int a = n / 2; a > 0; a /= 2) {
            for (int i = a; i < n; i += 1) {
                int temp = list[i];
                int j;
                for (j = i; j >= a && list[j - a] > temp; j -= a) {
                    list[j] = list[j - a];
                }
                list[j] = temp;
            }
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public static void printSortedArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}