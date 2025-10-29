package apps;

import adts.*;

public class duplicateDogList {

	public static void main(String[] args) {
        
        ArrayBasedList<String> dogs = new ArrayBasedList<>(12);
        
        dogs.add("Lassie");
        dogs.add("Rin Tin Tin");
        dogs.add("Snowy");
        dogs.add("Cujo");
        dogs.add("Snoopy");
        dogs.add("Lassie");
        dogs.add("Cujo");
        dogs.add("Beethoven");
        dogs.add("Snoopy");
        dogs.add("Benji");
        dogs.add("Lassie");
        dogs.add("Cujo");
        
        System.out.println("\noriginal list of dogs:\n" + dogs);
        
        /*
        System.out.println("Was first instance of Lassie removed?: " + dogs.remove("Lassie"));
        
        System.out.println("\nlist of dogs - one less Lassie:\n" + dogs);
        */
        
        ArrayBasedList<String> temp = new ArrayBasedList<>();
        
        for (String dog : dogs) {
        	if (!temp.contains(dog)) {
        		temp.add(dog);
        	}
        }
        dogs = temp;
 
        System.out.println("\n dupes removed:\n" + dogs);
	}

}
