package datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class UseQueue {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Queue that includes add,peek,remove,poll elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * 
		 */
		Queue<String> queue = new LinkedList<>();
		queue.poll();

		queue.add("LBJ");
		queue.add("Harden");
		queue.add("Steph");
		queue.add("Jokic");

		System.out.println(queue);

		if(queue.peek().equals("LBJ")){ //peek method find the top value
			System.out.println(queue.poll()); // poll method find the top value and remove
		}

		System.out.println("Iterator");

		Iterator it = queue.iterator() ;
		while(it.hasNext()){
			System.out.println(it.next());
		}


		System.out.println("Remove method");
		System.out.println(queue.remove("Harden"));
		System.out.println(queue);


		System.out.println("For each loop");
		for (String st : queue
		) {
			System.out.println(st);
		}

	}
}
