package datastructure;

import java.util.*;

public class UseMap {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Map that includes storing and retrieving elements.
		 * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 *
		 */

		List<String> LALPlayers = new ArrayList<>();
		LALPlayers.add("LBJ");
		LALPlayers.add("Davis");
		LALPlayers.add("Kuzma");


		List<String> GSW = new ArrayList<>();
		GSW.add("Steph Curry");
		GSW.add("Draymond");
		GSW.add("Klay");


		List<String> POR = new ArrayList<>();
		POR.add("Lillard");
		POR.add("CJ");
		POR.add("Jusuf");


		Map<String, List<String>> list = new HashMap<String, List<String>>();
		list.put("LAL",LALPlayers);
		list.put("GSW",GSW);
		list.put("POR", POR);

		System.out.println(list);


		System.out.println("For each loop");
		for (Map.Entry<String, List<String>> st : list.entrySet()){
			System.out.println(st.getKey()+ " -> " +st.getValue());
		}

		System.out.println("Iterator");
		Set set = list.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
