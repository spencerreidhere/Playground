/**
 * 
 */
package main;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dennis
 *
 */
public class Functional {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> myList = Arrays.asList("element1", "element2", "element3");

		// Nachteil: Die Verarbeitung kann nicht parallelisiert werden
		for (String listEntry : myList) {
			System.out.println(listEntry);
		}

		// Nachteil mehr Code
		myList.forEach(new Consumer<String>() {
			public void accept(String t) {
				System.out.println(t);
			}
		});

		
		// Lösung Lambda Expressions
		myList.forEach((String element) -> System.out.println(element));
		
		myList.forEach((String myListElement) -> System.out.println(myListElement));
		
		System.out.println("--");
		myList.forEach(element -> System.out.println(element));
		
		
		// Streams
		Collection<String> collection = Arrays.asList("Hello","Java");
		
		long countLongStrings = collection.stream().filter(new Predicate<String>() {
			@Override
			public boolean test(String element) {
				return element.length() > 4;
			}
		}).count();
		
		System.out.println(countLongStrings);
		
		long countLongStrings2 = collection.stream().filter((String element) -> element.length() > 4).count();
		
		System.out.println(countLongStrings2);
		
		
		User user1 = new User("Dennis",10);
		User user2 = new User("Dennis2",11);
		
		
		
		Collection<User> users = Arrays.asList(user1,user2);
		
		users.stream().filter((User user) -> user.getAge() > 10).collect(Collectors.toList());
		
		
		users.forEach(action);
		
		
	}

}
