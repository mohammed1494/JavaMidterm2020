package datastructure;

import java.util.ArrayList;
import java.util.Iterator;

public class UseArrayList {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use ArrayList that includes add,remove,retrieve elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * Store all the sorted data into one of the databases.
		 * 
		 */

		ArrayList<String> arrayex = new ArrayList<>();

		System.out.println("Add");
		arrayex.add("Kobe B");
		arrayex.add("LBJ");
		System.out.println(arrayex);

		arrayex.add(1,"Anthony D");
		arrayex.add(2,"Dennis Schroder");


		System.out.println("Iterator ");
		Iterator it = arrayex.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("Remove");
		arrayex.remove(2);

		System.out.println("For Each loop");

		for (String st : arrayex
		) {
			System.out.println(st);
		}

	}
}

