package algorithm;

import databases.ConnectToSqlDB;

import java.util.List;
import java.util.Random;

/*
 *Created by mrahman on 04/02/2018.
 */
public class Numbers {

	/*
	 * Show all the different kind of sorting algorithm by applying into (num array).
	 * Display the execution time for each sorting.Example in below.
	 *
	 * Use any databases[MongoDB, Oracle or MySql] to store data and retrieve data.
	 *
	 * At the end. After running all the sorting algo, come to a conclusion which one is suitable on given data set.
	 *
	 */

	public static void main(String[] args) throws Exception {
		
		int [] num = new int[1000000];
		storeRandomNumbers(num);
		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
		//Selection Sort
		Sort algo = new Sort();
		algo.selectionSort(num);
		long selectionSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of "+ num.length + " numbers in Selection Sort take: " + selectionSortExecutionTime + " milli sec");
        connectToSqlDB.insertDataFromArrayToSqlTable(num, "selection_sort", "SortingNumbers");
        List<String> selectionSortNumbers = connectToSqlDB.readDataBase("selection_sort", "SortingNumbers");
        printValue(selectionSortNumbers);
		int n = num.length;
		randomize (num, n);
		//Insertion Sort
		algo.insertionSort(num);
		long insertionSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Insertion Sort take: " + insertionSortExecutionTime + " milli sec");
		connectToSqlDB.insertDataFromArrayToSqlTable(num, "insertion_sort", "SortingNumbers");
		List<String> insertionSortNumbers = connectToSqlDB.readDataBase("insertion_sort", "SortingNumbers");
		printValue(insertionSortNumbers);

		//By following above, Continue for rest of the Sorting Algorithm....

		storeRandomNumbers(num);


		randomize (num, n);

		//Heap Sort
		algo.heapSort(num);
		long heapSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Heap Sort take: " + heapSortExecutionTime + " milli sec");


		//Bubble sort
		algo.bubbleSort(num);
		long bubbleSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of "+ num.length + " numbers in bubble Sort take: " + bubbleSortExecutionTime + " milli sec");

		//Bucket Sort
		randomize(num, n);

		algo.bucketSort(num, 1000000);
		System.out.println("Total Execution Time of " + num.length + " numbers in BucketSort take: " + algo.executionTime + " milli sec");

		//Quick Sort
		randomize(num, n);

		//algo.quickSort(int[] array, int a, int b);
			long quickSortExecutionTime = algo.executionTime;
			System.out.println("Total Execution Time of " + num.length + " numbers in Quick Sort take: " + quickSortExecutionTime + " milli sec");


		//Shell Sort
		randomize(num, n);

		algo.shellSort(num);
		long shellSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Shell Sort take: " + shellSortExecutionTime + " milli sec");


		//Come to conclusion about which Sorting Algo is better in given data set.

		//Bucket Sort is better in this case, because there is a wide range of data set.

	}

	public static void storeRandomNumbers(int [] num){
		Random rand = new Random();
		for(int i=0; i<num.length; i++){
			num[i] = rand.nextInt(100);
		}
	}

	public static void randomize( int arr[], int n)
	{
		Random r = new Random();
		// Start from the last element and swap one by one. We don't
		// need to run for the first element that's why i > 0
		for (int i = n-1; i > 0; i--) {
			int j = r.nextInt(i);
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
	public static void printValue(List<String> array){
		for(String st:array){
			System.out.println(st);
		}
	}
}
