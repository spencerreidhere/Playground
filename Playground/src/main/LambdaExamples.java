package main;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaExamples {

	public LambdaExamples() {

		List<String> myList = Arrays.asList("A,B,C,D");

		 // Klassisches Beispiel:
		for (String element : myList) {
			System.out.println(element);
		}
		
		/**
		 * Durch das Interface Iterable ist es möglich an einer Liste einfach per
		 * foreach zuzugreifen.
		 */
		myList.forEach(new Consumer<String>() {
			@Override
			public void accept(String element) {
				System.out.println(element);
			}
		});

		/**
		 * Da es sich bei Consumer um ein FunctionalInterface handelt können wir den
		 * obigen Code mit Hilfe von LambdaExpressions folgenden Code schreiben
		 */
		myList.forEach((String element) -> System.out.println(element));
		
		
		// Sonderfall: Da es nur ein Element gibt, kann die Typbezeichnung weggelassen werden.
		myList.forEach(element -> System.out.println(element));

	}

}
