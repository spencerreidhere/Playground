package main;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExamples {

	public StreamExamples() {

		List<String> myList = Arrays.asList("A1","A2");
		
		long countLongStrings = myList.stream().filter(new Predicate<String>() {
			@Override
			public boolean test(String element) {
				return element.length() > 4;
			}
		}).count();
		
		System.out.println("Es gibt "+ countLongStrings + " lange Zeichenketten");
		
		
		// Das ganze noch einfacher beschrieben mit Lambdas
		countLongStrings = myList.stream().filter((String element) -> element.length() > 4).count(); 

		System.out.println("Muss gleich sein wie oben: "+ countLongStrings);
		
		
		User user1 = new User("User1", 27);
		User user2 = new User("User2", 50);
		Collection<User> users = Arrays.asList(user1,user2);

		
		//ohne Lambdas
		long countFullAgeUsers = users.stream().filter(new Predicate<User>() {
			public boolean test(User user) {
				return user.getAge() > 17;
			};
		}).count();

		System.out.println("Es gibt "+ countFullAgeUsers + " Benutzer");
		
		//mit Lambdas
		countFullAgeUsers = users.stream().filter((User user) -> user.getAge() > 17).count();
		
		System.out.println("Muss gleich sein wie oben: "+ countFullAgeUsers);

	}
	
}
