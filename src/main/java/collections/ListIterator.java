package main.java.collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListIterator {
    public static void main( String[] args ) {
        List<String> strings = new LinkedList<>();
        Collections.addAll(strings, "Java", "ist", "toll");
        System.out.println(strings); // [Java, ist, toll]
        java.util.ListIterator<String> iter = strings.listIterator();
        String next = iter.next();
        System.out.println(next);                   // Java
        iter.next();                                // ist
        System.out.println( iter.next() );          // toll
//        System.out.printf( iter.next() );         // java.util.NoSuchElementException
        System.out.println( iter.previous() );      // toll

        List<Integer> numbers = new LinkedList<>();
        Collections.addAll( numbers, 1, 2, 3, 4, 5, -1 );
        java.util.ListIterator<Integer> iterator = numbers.listIterator();

        while(iterator.hasNext()) {
            Integer nextInt = iterator.next();
            if (nextInt < 0) {
                iterator.remove();
            }
        }
        System.out.println(numbers); // [1, 2, 3, 4, 5]

        List<Integer> numbers2 = new LinkedList<>();
        Collections.addAll( numbers2, 1, 2, 3, 4, 5, -1 );
        java.util.ListIterator<Integer> iterator2 = numbers2.listIterator();

        while(iterator2.hasNext()) {
            Integer nextInt = iterator2.next();
            if (nextInt == 2) {
                numbers2.remove(nextInt);   // java.util.ConcurrentModificationException
                                            // Die next() Methode aus ListIterator wirft die o.g. Exception,
                                            // da die Liste beim Iterieren geändert wurde!
            }
        }
        System.out.println(numbers2);

    }
}
